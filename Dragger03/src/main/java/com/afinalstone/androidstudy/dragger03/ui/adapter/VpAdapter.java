package com.afinalstone.androidstudy.dragger03.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

public class VpAdapter extends PagerAdapter {
    private Context context;
    private List<String> list;  
  
    @Inject
    public VpAdapter(Context context, List<String> list) {
        this.context = context;  
        this.list = list;  
    }  
  
    @Override  
    public int getCount() {  
        return list.size();  
    }  
  
    @Override  
    public boolean isViewFromObject(View view, Object object) {
        return view==object;  
    }  
  
    @Override  
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView iv = new ImageView(context);  
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Picasso.with(context).load(list.get(position)).into(iv);
        container.addView(iv);  
        return iv;  
    }  
  
    @Override  
    public void destroyItem(ViewGroup container, int position, Object object) {  
        container.removeView((View) object);  
    }  
}  

