package com.xiaxi.lancher.fragment;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.xiaxi.lancher.Adapter.ResolveAdapter;
import com.xiaxi.lancher.MainActivity;
import com.xiaxi.lancher.Model.ResolveModel;
import com.xiaxi.lancher.R;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.PrivateCredentialPermission;

/**
 * Created by Administrator on 2019/12/11.
 */

public class Secondpagefragment extends Fragment {
    private PopupWindow popupWindow;
    private View contentView;
    Button openPopWindow;
    ListView mlistview;
    GridView mGridview;
    ResolveAdapter madapter;
    ResolveModel resolveModel;
    String type="img1";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.secondpagefragment_layout, null);
        openPopWindow = (Button) view.findViewById(R.id.openPopWindow);
        mlistview = (ListView) view.findViewById(R.id.mlistview);
        mGridview = (GridView) view.findViewById(R.id.Mgridview);
        openPopWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.showAtLocation(contentView, Gravity.BOTTOM, 0, 0);
            }
        });
        show3();
        loadData();
        showPopwindow();
        return view;
    }

    // 自定义适配器
    private void show3() {
        if (type.equals("img1")){
            madapter = new ResolveAdapter(getActivity(), R.layout.listview_layout);
            mlistview.setAdapter(madapter);
            mlistview.setVisibility(View.VISIBLE);
            mGridview.setVisibility(View.GONE);
        }else {
            madapter = new ResolveAdapter(getActivity(), R.layout.gridview_layout);
            mGridview.setAdapter(madapter);
            mGridview.setVisibility(View.VISIBLE);
            mlistview.setVisibility(View.GONE);
        }
    }

    /**
     * 刷新画面
     */
    private void refreshUI(List<ResolveModel> list) {
        madapter.setData(list);

    }

    private void loadData() {
        List<ResolveModel> mContentList = new ArrayList<ResolveModel>();
        ResolveModel model = new ResolveModel();
        model.setName("张三1");
        model.setIconimg(R.drawable.high_light);
        mContentList.add(model);
        ResolveModel model1 = new ResolveModel();
        model1.setName("张三2");
        model1.setIconimg(R.drawable.high_light);
        mContentList.add(model1);
        ResolveModel model2 = new ResolveModel();
        model2.setName("张三3");
        model2.setIconimg(R.drawable.high_light);
        mContentList.add(model2);
        ResolveModel model3 = new ResolveModel();
        model3.setName("张三3");
        model3.setName("张三4");
        model.setIconimg(R.drawable.high_light);
        mContentList.add(model3);
        ResolveModel model4 = new ResolveModel();
        model4.setName("张三5");
        model4.setIconimg(R.drawable.high_light);
        mContentList.add(model4);
        ResolveModel model5 = new ResolveModel();
        model5.setName("张三6");
        model5.setIconimg(R.drawable.high_light);
        mContentList.add(model5);
        ResolveModel model6 = new ResolveModel();
        model6.setName("张三7");
        model6.setIconimg(R.drawable.high_light);
        mContentList.add(model6);
        ResolveModel model61 = new ResolveModel();
        model61.setName("张三3");
        model61.setIconimg(R.drawable.high_light);
        mContentList.add(model61);

        refreshUI(mContentList);
    }

    /**
     * 显示popupWindow
     */
    private void showPopwindow() {
        //加载弹出框的布局
        contentView = LayoutInflater.from(getActivity()).inflate(
                R.layout.pop, null);
        popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);// 取得焦点
        //注意  要是点击外部空白处弹框消息  那么必须给弹框设置一个背景色  不然是不起作用的
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //点击外部消失
        popupWindow.setOutsideTouchable(true);
        //设置可以点击
        popupWindow.setTouchable(true);
        //进入退出的动画，指定刚才定义的style
        popupWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
        // 按下android回退物理键 PopipWindow消失解决
        Button button = (Button) contentView.findViewById(R.id.button_ok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "点击一下", Toast.LENGTH_LONG).show();
//                openPopWindow.setVisibility(View.INVISIBLE);
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
                type="img1";
                show3();
                loadData();
            }
        });
        Button button_return = (Button) contentView.findViewById(R.id.button_return);
        button_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type="2";
                show3();
                loadData();
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
            }
        });
    }

}
