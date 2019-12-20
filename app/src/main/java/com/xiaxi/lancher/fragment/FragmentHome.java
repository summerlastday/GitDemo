package com.xiaxi.lancher.fragment;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.xiaxi.lancher.Adapter.AppsAdapter;
import com.xiaxi.lancher.MainActivity;
import com.xiaxi.lancher.R;

import java.util.List;

/**
 * Created by Administrator on 2019/12/11.
 */

public class FragmentHome extends Fragment {
    private GridView appsGridView;
    private List<ResolveInfo> appList;
    AppsAdapter adapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.homefragment_layout,null);
        appsGridView = (GridView)view.findViewById(R.id.apps_list);

        //获取app列表
        appList = getAppList();
        adapter=new AppsAdapter(getActivity(),appList);
        appsGridView.setAdapter(adapter);
        appsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                ResolveInfo info = appList.get(position);
                openAppLication(info);
            }
        });
        return view;
    }
    //获取APP列表
    private List<ResolveInfo> getAppList(){
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        return getActivity().getPackageManager().queryIntentActivities(mainIntent, 0);
    }

    //打开App
    private void openAppLication(ResolveInfo info){
        //该应用的包名
        String pkg = info.activityInfo.packageName;
        //应用的主activity类(MAIN)
        String cls = info.activityInfo.name;
        //ComponentName（组件名称）是用来打开其他应用程序中的Activity或服务的。
        ComponentName componet = new ComponentName(pkg, cls);
        Intent intent = new Intent();
        intent.setComponent(componet);
        startActivity(intent);
    }
}
