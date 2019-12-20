package com.xiaxi.lancher;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.xiaxi.lancher.fragment.FragmentHome;
import com.xiaxi.lancher.fragment.Secondpagefragment;
import com.xiaxi.lancher.fragment.Thirdpagefragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    ImageView first_imageview,second_imageview,third_imageview;
    ViewPager viewPager;
    List<Fragment> list;
    public static final int REQUEST_READ_PHONE_STATE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        initdata();
        // 切换到指定页面
        viewPager.setCurrentItem(1);
    }
    private void initdata(){
        //获取电话状态的权限
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_READ_PHONE_STATE);
        } else {
            first_imageview=(ImageView)findViewById(R.id.first_imageview);
            second_imageview=(ImageView)findViewById(R.id.second_imageview);
            third_imageview=(ImageView)findViewById(R.id.third_imageview);
            list = new ArrayList<Fragment>();
            list.add(new FragmentHome());
            list.add(new Secondpagefragment());
            list.add(new Thirdpagefragment());
            FragmentManager fm =getSupportFragmentManager();
            FragmentPagerAdapter adapter = new FragmentPagerAdapter(fm) {

                @Override
                public int getCount() {
                    // TODO Auto-generated method stub
                    return list.size();
                }

                @Override
                public Fragment getItem(int arg0) {
                    // TODO Auto-generated method stub
                    return list.get(arg0);
                }
            };
            viewPager.setAdapter(adapter);
            viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }
                @Override
                public void onPageSelected(int position) {
                    switch (position) {
                        case 0:
                            first_imageview.setImageResource(R.drawable.high_light);
                            second_imageview.setImageResource(R.drawable.non_high_light);
                            third_imageview.setImageResource(R.drawable.non_high_light);
                            break;
                        case 1:
                            first_imageview.setImageResource(R.drawable.non_high_light);
                            second_imageview.setImageResource(R.drawable.high_light);
                            third_imageview.setImageResource(R.drawable.non_high_light);
                            break;
                        case 2:
                            first_imageview.setImageResource(R.drawable.non_high_light);
                            second_imageview.setImageResource(R.drawable.non_high_light);
                            third_imageview.setImageResource(R.drawable.high_light);
                            break;
                        default:
                            break;
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }

            });

        }

    }
}
