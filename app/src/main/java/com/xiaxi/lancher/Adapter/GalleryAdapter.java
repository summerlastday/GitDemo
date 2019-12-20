package com.xiaxi.lancher.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import com.xiaxi.lancher.R;


/**
 * Created by Administrator on 2019/12/17.
 */

public class GalleryAdapter extends PagerAdapter{
    private  int[] mData;
    private  Context mContext;
    public GalleryAdapter(Context context,int[] data){
        this.mContext=context;
        this.mData=data;
    }
    @Override
    public int getCount() {
        return mData.length;
    }

    @Override
    public Object instantiateItem(final ViewGroup container,final int position) {
        View view=View.inflate(container.getContext(),R.layout.item,null);
        ImageView imageView=view.findViewById(R.id.iv_icon);
        imageView.setImageResource(mData[position]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"当前条目:"+position,Toast.LENGTH_SHORT).show();
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject( View view,  Object object) {
        return view==object;
    }

    @Override
    public void destroyItem( ViewGroup container, int position,  Object object) {
        container.removeView((View)object);
    }
}
