package com.xiaxi.lancher.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.xiaxi.lancher.Adapter.GalleryAdapter;
import com.xiaxi.lancher.MainActivity;
import com.xiaxi.lancher.R;

/**
 * Created by Administrator on 2019/12/11.
 */

public class Thirdpagefragment extends Fragment {
    private ViewPager mViewPager;
    private LinearLayout ll_layout;
    private int[] mPics = new int[]{R.mipmap.img1, R.mipmap.img2, R.mipmap.img3, R.mipmap.img4, R.mipmap.icon_1};

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.thirdpage_layout,null);
          mViewPager=(ViewPager)view.findViewById(R.id.viewPager);
          ll_layout=(LinearLayout)view.findViewById(R.id.ll_layout);
//          mViewPager.setPageMargin(20);
        //设置适配器
        mViewPager.setAdapter(new GalleryAdapter(getActivity(), mPics));
          mViewPager.setOffscreenPageLimit(mPics.length);
          mViewPager.setCurrentItem(1);
          ll_layout.setOnTouchListener(new View.OnTouchListener() {
              @Override
              public boolean onTouch(View view, MotionEvent motionEvent) {
                  return mViewPager.dispatchTouchEvent(motionEvent);
              }
          });
        return view;
    }
}
