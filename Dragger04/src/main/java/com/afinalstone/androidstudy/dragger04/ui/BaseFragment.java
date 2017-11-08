package com.afinalstone.androidstudy.dragger04.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */

public class BaseFragment extends Fragment {

    private String pageImageUrl;
    public static final String KeyPage = "pageImageUrl";

    public static BaseFragment getInstance(String pageImageUrl){
        Bundle bundle = new Bundle();
        bundle.putString(KeyPage, pageImageUrl);
        BaseFragment baseFragment = new BaseFragment();
        baseFragment.setArguments(bundle);
        return baseFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageImageUrl = getArguments().getString(KeyPage);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ImageView iv = new ImageView(getContext());
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Picasso.with(getContext()).load(pageImageUrl).into(iv);
        return iv;
    }
}
