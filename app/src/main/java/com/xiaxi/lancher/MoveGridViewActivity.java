package com.xiaxi.lancher;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import com.xiaxi.lancher.Util.MoveGridView;
import com.xiaxi.lancher.Util.UninstallListener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 可拖拽的GridView效果实现, 长按可拖拽删除数据源
 */
public class MoveGridViewActivity extends Activity {
    private MoveGridView mMoveGridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_grid_view);
        mMoveGridView = (MoveGridView) findViewById(R.id.gridview);
        final ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 10; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemText", "NO." + String.valueOf(i));// 按序号做ItemText
            lstImageItem.add(map);
        }
        final SimpleAdapter saImageItems = new SimpleAdapter(this,
                lstImageItem,// 数据来源
                R.layout.gridview_item,
                // 动态数组与ImageItem对应的子项
                new String[] { "ItemText" },
                // ImageItem的XML文件里面的一个ImageView,两个TextView ID
                new int[] { R.id.ItemText });
        // 添加并且显示
        mMoveGridView.setAdapter(saImageItems);
        //监听到卸载删除数据
        mMoveGridView.setOnUninstallListener(new UninstallListener() {

            @Override
            public void onUninstallListener(int position) {
                lstImageItem.remove(position);
                saImageItems.notifyDataSetChanged();
            }
        });

    }
}
