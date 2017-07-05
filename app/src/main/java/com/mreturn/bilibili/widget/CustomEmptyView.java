package com.mreturn.bilibili.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.mreturn.bilibili.R;

/**
 * Created by mReturn
 * on 2017/7/5.
 * 自定义 没有内容时展示的页面
 */

public class CustomEmptyView extends FrameLayout{

    ImageView ivEmpty;
    TextView tvEmpty;

    public CustomEmptyView(Context context) {
        super(context);
        initView(context);
    }

    public CustomEmptyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CustomEmptyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.layout_empty,this);
        tvEmpty = (TextView) view.findViewById(R.id.tv_empty);
        ivEmpty = (ImageView) view.findViewById(R.id.iv_empty);
    }
    public void setEmptyText(String text){
        tvEmpty.setText(text);
    }

    public void setImageRes(int imgRes){
        ivEmpty.setImageResource(imgRes);
    }
}
