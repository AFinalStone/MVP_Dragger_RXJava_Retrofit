Drager2的使用<一>

原文地址：http://blog.csdn.net/u012943767/article/details/51897247

之前也研究过很多次Dagger2这东西了，可能以后RxJava+Retrofit+MVP+Dagger2是Android发展的主流框架，看了Dagger2的实现代码，有点不明所以。上网也有很多文章介绍依赖注入、Dagger2的组件等等那些，这样这样这样什么组件呀、模块呀、注入呀。但是感觉对于入门来说那些文章都没有说到点子上，具体怎么用这个核心点而且应该怎么写代码？为什么这样写，并没有很明确的说明。我来回看了几遍代码之后，总结出了一点经验，不知道说的对不对。

没有了解过Android MVP结构的同学可能不利于阅读。

为什么使用Dagger2

对于这个问题我也困惑了很久，Java代码就是这样写，并没有考虑过依赖注入是什么鬼，并且依赖注入有什么不好。这篇文章详细介绍了依赖注入,感兴趣的可以传送过去看看。

简单来说，依赖注入就是为了控制反转和解耦的，这些高深的名词儿可能一时也不懂。不要紧，我举个栗子就能明白了，请看代码：

```java
class A{

}

class B{
    A a;
    public B(){
        a = new A();
    }
}
```

上面的代码很简单，class B持有一个class A的对象，然后假如根据业务需求需要修改A类的某些实现，这样的话就需要修改B类中的创建A对象的方式。假想一下，当你的代码规模达到一定的程度的时候，需要改一部分代码，牵一而发动全身，需要改的代码量多，而且容易出错。还有一个不好的情况就是，当要对A进行单元测试的时候，就要测试B，这样的耦合可能不是程序员希望看见的。Dagger2就是为了解决这样的问题而出现的。这里只是一个简单的例子，可能描述依赖注入的原理不是很清晰，如果不是很了解的话可以从网上搜索出很多文章。

Dagger2的配置

目录添加apt支持，apt是用于自动生成代码来进行依赖注入的。
项目中的build.gradle添加：

```gradle
dependencies {
    ...
    //dagger2
    provided 'org.glassfish:javax.annotation:10.0-b28'
    compile 'com.google.dagger:dagger:2.5'
    compile 'com.google.dagger:dagger-compiler:2.5'
}
```

例子

这里通过一个例子来向Activity注入一些成员变量。(例子代码来自网上),来说明Dagger2的基本使用。

例子使用的是MVP模式，内容是通过注入一个Presenter，然后通过Presenter来设置TextView显示内容为user.name;

其中User的代码如下：

```java
public class User {
    public String name;

    public User(String name) {
        this.name = name;
    }
}
```

Presenter的代码：

```java
public class DaggerPresenter {
    DaggerActivity activity;
    User user;

    public DaggerPresenter(DaggerActivity activity, User user) {
        this.user = user;
        this.activity = activity;
    }

    public void showUserName() {
        activity.showUserName(user.name);
    }
}
```

现在的场景是有一个DaggerActivity，里面持有一个DaggerPresenter的成员，我们该如何使用Dagger2来注入这个成员呢？

第一步：编写Module

我这里编写了一个ActivityModule，代码如下：

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
    public User provideUser() {
        return new User("user form ActivityModule");
    }

    @Provides
    public DaggerPresenter provideDaggerPresenter(DaggerActivity activity, User user) {
        return new DaggerPresenter(activity, user);
    }
}
```

首先这里编写有一些规则的，类需要用@Module注解来标示，可以看到我这个AcitivtyModule中定义了一个构造函数，需要传进来一个DaggerActivity对象。
[]()
首先我们需要明确一个点，就是Module的作用是用来提供生成依赖对象的，比如我要注入DaggerPresenter，那么这个Module的作用就是需要生成一个DaggerPresenter的对象，来让Dagger2注入到DaggerActivity中。

所以我们这里需要编写一个函数provideDaggerPresenter,这个函数可以从上面的代码看出，我们需要对这个函数使用@Provides注解，然后，我们这里需要传入两个参数，一个DaggerActivity，一个User对象。那么，这两个参数从何而来呢?

细心的同学可能会发现，我上面的代码中还定义了两个函数，分别为provideUser和provideActivity，大家猜出点什么没有(嘿嘿)，这里provideDaggerPresenter的两个参数就是通过这两个函数来获取的。如果没有声明这两个函数的话，可能编译期间会报错哟。通过上述内容，各位同学应该明白了Module应该如何编写了吧。

编写Module有以下几个注意点：

- 类需要用@Module来标明注解
- 这里有一点规则，用@Provides注解的函数需要以provide开头，然后后面接什么内容都可以，看自己喜欢，事实上，经过我的测试，我把provideActivity()改成provideA()同样是可以注入成功的，所以大家可以知道，这里是根据返回值类型来标识的，方法名并不重要，只需要保证以provide开头即可。

第二步：编写ActivityComponent

请看代码：

```java
@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(DaggerActivity daggerActivity);
}
```

这里的代码够少吧，哈哈，我们编写的这个Component需要用@Component注解来标识，同时声明了modules为上面编写的ActivityComponent,然后提供了一个方法，叫做inject，用来在Activity中注入。(这里为什么要写一个方法叫做inject我暂时还没弄清楚，改名字是可以的，但是参数类型不能改，并且一定要指定module=ActivityModule才能注入)，这里我们暂且理解为提供一个方法来注入对象吧。

第三步：AndroidStudio -> Build -> Make Project

写到这里的时候就可以Make Project了，完成之后apt会自动生成一个以Dagger开头的Component，比如，我们上面写的是ActivityComponent,生成了类名就为DaggerActivityComponent。这个类我们可以直接使用。

第四步，注入Activity中

在第三步中已经生成了一个DaggerActivityComponent了，我们在Activity的onCreated函数中编写如下代码：

```java
 DaggerActivityComponent.builder()
    .activityModule(new ActivityModule(this))
    .build()
    .inject(this);
```

可以看到我们首先调用这个了类的builder(),然后调用一些方法。这些方法也有一些规律噢，比如我们的ActivityComponent指定的module是ActivityModule，DaggerActivityComponent就会有一个名为activityModule的方法，我们需要调用它，并传入参数，这里我们直接new了一个ActivityModule进去。

好了，到此为止，我们已经使用Dagger2形成了关联，我们还需要注入Presenter。在Activity中：
```java

@Inject
DaggerPresenter presenter;

````
我们直接使用注解@Inject就可以对这个成员进行注入了。

下面是我的Activity的完整代码：
```java
public class DaggerActivity extends AppCompatActivity {

    private static final String TAG = "DaggerActivity";
    TextView text_name;
    TextView text_sex;

    @Inject
    DaggerPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragger);
        text_name = (TextView) findViewById(R.id.text_name);
        text_sex = (TextView) findViewById(R.id.text_sex);
        inject();
        presenter.showUserName();
        presenter.showUserSex();
        //Log.i(TAG, "client = " + (client == null ? "null" : client));
    }

    private void inject() {
        DaggerActivityComponent.builder().activityModule(new ActivityModule(this))
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

上面的代码运行起来的结果就是在DaggerActivity的TextView中显示了一串字符串"user form ActivityModule",虽然例子简单，但是基本上实现了简单依赖注入，希望对于Dagger2的入门有点启发。