package com.xiaxi.lancher.Adapter;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiaxi.lancher.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/12/5.
 */

public class AppsAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    ArrayList<ResolveInfo> appList;

//    public final class AppItem {
//        public ImageView appIcon;
//        public TextView appName;
//    }

    public AppsAdapter(Context context, List<ResolveInfo> apps) {
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        appList = (ArrayList<ResolveInfo>) apps;
    }

    @Override
    public int getCount() {
        return appList.size();
    }

    @Override
    public Object getItem(int position) {
        return appList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView appIcon = null;
        TextView appName = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.icon_layout, null);
            appIcon = (ImageView) convertView.findViewById(R.id.app_icon);
           appName = (TextView) convertView.findViewById(R.id.app_name);
            ViewCache cache = new ViewCache();
            cache.appIcon = appIcon;
            cache.appName = appName;
            convertView.setTag(cache);
        } else {
            ViewCache cache = (ViewCache) convertView.getTag();
            appIcon = cache.appIcon;
            appName=cache.appName;
        }
        ResolveInfo info = appList.get(position);
        appIcon.setImageDrawable(info.loadIcon(mContext.getPackageManager()));
        appName.setText(info.loadLabel(mContext.getPackageManager()));
        return convertView;
    }
    private final class ViewCache {
        public ImageView appIcon;
        public TextView appName;
    }

}
