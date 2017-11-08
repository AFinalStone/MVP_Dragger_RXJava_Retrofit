package com.afinalstone.androidstudy.dragger03.di.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/11/6.
 */

@Module
public class VpAdapterModule {
    private Context context;

    public VpAdapterModule(Context context) {
        this.context = context;
    }

    @Provides
    Context providesContext(){
        return context;
    }

    @Provides
    List<String> providesImageList(){
        List<String> list = new ArrayList<>();
        list.add("http://pic26.photophoto.cn/20130323/0005018467298586_b.jpg");
        list.add("http://pic.qiantucdn.com/58pic/17/56/37/90y58PICe3w_1024.jpg");
        list.add("http://pic2.16pic.com/00/24/38/16pic_2438497_b.jpg");
        list.add("http://e.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=1a3963408f94a4c20a76ef2f3bc437e3/e4dde71190ef76c66b5e79649516fdfaae5167f5.jpg");
        return list;
    }
}
