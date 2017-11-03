Drager2的使用<二>

好啦，现在我们的项目又有新需求了，我们希望提供一个全局的OkHttpClient和Retrofit对象来进行网络请求，他的生命周期是和APP一致的，这个时候我们就需要定制AppComponent了。

首先我们按照老规矩，第一步先编写Module,一下是ApiModule：
```java
package com.afinalstone.androidstudy;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module
public class ApiModule {
    public static final String END_POINT = "http://www.baidu.com";


    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .build();
        return client;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(END_POINT)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    User provideUser(){
        return new User("name form ApiProvide","女");
    }

}
```
请注意，我这里的provide方法额外添加了一个@SingleTon注解，这里说明是全局单例的对象，而且我这里改动了一小部分代码，把ActivityModule的provideUser移动到这里来了,我这里是为了演示依赖过程。

接下来编写AppComponent了：

```java
@Singleton
@Component(modules = {ApiModule.class})
public interface AppComponent {

    OkHttpClient getClient();

    Retrofit getRetrofit();

    User getUser();
}
```

这里的AppComponent提供了3个方法，分别用来暴露OkHttpClient、Retrofit和User对象的，这里暂且不提为什么要暴露，大家别急，继续往下看。

第三部就是Make Project了，之后就会生成一个叫做DaggerAppComponent的类，之后我们在MyApplicaiotn中实例化这个Component:

```java
public class MyApplication extends Application {


    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
```
这里别忘了在AndroidManifest中设置为自定义的MyApplicaiton哦。上面的代码很简单，我们只是实例化了一个AppComponent,然后提供了一个方法用于获取这个Component。

然后我们需要修改一下ActivityComponent，改成下面这样：

```java
@ActivityScope
@Component(modules = ActivityModule.class,dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(DaggerActivity daggerActivity);
}
```
改动的地方呢是添加了一个@ActivityScope然后，添加了一个dependencies = AppComponent.class。没错，Component之间也可以依赖的。

解释一下这个ActivityScope，这里查询了网上的资料之后，据说是可以和Activity的生命周期绑定，没有声明这个注解的话编译会报异常。我暂时无法对这个Scope理解清晰，不做评论。

```java
@Scope
public @interface ActivityScope {
}
```
最后一步啦，改动DaggerActivity：

```java
public class DaggerActivity extends AppCompatActivity {

    private static final String TAG = "DaggerActivity";
    TextView text_name;
    TextView text_sex;

    @Inject
    DaggerPresenter presenter;

    @Inject
    OkHttpClient client;

    @Inject
    Retrofit retrofit;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragger);
        text_name = (TextView) findViewById(R.id.text_name);
        text_sex = (TextView) findViewById(R.id.text_sex);
        inject();
        presenter.showUserName();
        presenter.showUserSex();
        Log.i(TAG, "client = " + (client == null ? "null" : client));
        Log.i(TAG, "retrofit = " + (retrofit == null ? "null" : retrofit));
    }

    private void inject() {
        AppComponent appComponent = ((MyApplication) getApplication()).getAppComponent();
        DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .activityModule(new ActivityModule(this))
                .build().inject(this);
    }

    public void showUserName(String name) {
        text_name.setText(name);
    }

    public void showUserSex(String sex) {
        text_sex.setText(sex);
    }
}
```
可以看到我这里添加了两个注入，分别注入了一个OkHttpClient和一个Retrofit对象，然后在注入的时候也把AppComponent也添加进来了。然后我们先看运行结果，后面我会解释一下整个依赖关系。

运行结果：

Log输出：

```log
DaggerActivity: client = okhttp3.OkHttpClient@c8bee8e
DaggerActivity: retrofit = retrofit2.Retrofit@a1806af
```

然后在手机上运行的话，TextView会显示"name from ApiProvide",从结果看来我们已经成功注入了这3个对象。

现在估计大家有些疑问。

首先我们看回ActivityModule：

```java
@Module
public class ActivityModule {

    private DaggerActivity activity;

    public ActivityModule(DaggerActivity activity) {
        this.activity = activity;
    }

    @Provides
    public DaggerActivity provideActivity() {
        return activity;
    }

    @Provides
    public DaggerPresenter provideDaggerPresenter(DaggerActivity activity, User user) {
        return new DaggerPresenter(activity, user);
    }
}
```
这里的provideUser方法已经去掉了，那么根据我前面说的话，那我们需要从哪里获取这个User对象呢。我们看回前面的：

```java
@ActivityScope
@Component(modules = ActivityModule.class,dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(DaggerActivity daggerActivity);
}
```
可以看到这个ActivityComponent是依赖AppComponent的，AppComponent中定义了3个方法：

```java
@Singleton
@Component(modules = {ApiModule.class})
public interface AppComponent {

    OkHttpClient getClient();

    Retrofit getRetrofit();

    User getUser();
}
```
分别用来提供这三个对象的，这样就可以解释清楚了，他们存在依赖关系，就像我们对象之间的继承一样，值得注意的是这三个方法也是根据返回值类型来识别的，他们会分别找到AppComponent中的module(ApiModule)中的provide方法来获取对象。

这里我们发现一个有趣的现象，首先我们提供这三个方法可以被Activity的成员变量注入(可以看到，我们成功的注入的OkHttpClient和Retrofit)，同时也可以让被依赖的Component(ActivityComponent)所使用.

如果我们不把这三个对象声明在AppComponent中,在编译的过程中就会报异常。在专业术语好像叫做:暴露给子图？

结论

我这里只是对于怎么使用Dagger2来了一个流程，并且做出了一些通俗化的解释。听到很多人说这个Dagger2入门困难，可能是因为需要理解完Dagger2通过APT生成的代码的流程才能完全理解吧。但是我们通常学习一个框架是学会怎么使用，使用过了之后，才会对它的原理进行了解，然而Dagger2的使用起来也并不简单，对于一个没有接触过Dagger1，又没有了解过依赖注入的概念的人来说，一下子需要看明白还是有点难度的。我也是经历了很多次入门到放弃，感觉自己现在也是理解的不太清晰，其实都是猜的（嘿嘿）。总之这篇文章的着重点是为了让大家知道如何使用Dagger2，并没有解释过内部的原理，但是希望这些东西能带给一些想入门Dagger2又感觉难以理解的人一点点启发吧。

