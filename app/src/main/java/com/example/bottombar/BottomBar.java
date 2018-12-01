package com.example.bottombar;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Pan on 2018/11/28.
 */

public class BottomBar extends FrameLayout implements View.OnClickListener {

    Context context;
    AttributeSet attributeSet;
    List<BottomBarItemData> itemDatas;
    BottomBarItemClickListener listener;
    int selItemPosition = 0;
    int itemlayoutid;
    String selColor = "#ff0000";
    String unselColor = "#666666";
    LinearLayout linearLayout;

    public BottomBar setItemDatas(List<BottomBarItemData> itemDatas) {
        this.itemDatas = itemDatas;
        return this;
    }

    public BottomBar setListener(BottomBarItemClickListener listener) {
        this.listener = listener;
        return this;
    }

    public BottomBar setItemlayoutid(int itemlayoutid) {
        this.itemlayoutid = itemlayoutid;
        return this;
    }

    public BottomBar(@NonNull Context context) {
        super(context);
        this.context = context;
    }


    public BottomBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        attributeSet = attrs;
    }

    public BottomBar setSelColor(String selColor) {
        this.selColor = selColor;
        return this;
    }

    public BottomBar setUnselColor(String unselColor) {
        this.unselColor = unselColor;
        return this;
    }

    public BottomBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        attributeSet = attrs;
    }


    public void initview() {

        View view = View.inflate(context, R.layout.layout_bottom_bar, this);
        linearLayout = view.findViewById(R.id.mBottomBarLL);

        if (itemDatas != null) {
            int size = itemDatas.size();
            for (int i = 0; i < size; i++) {
                LayoutInflater.from(context).inflate(itemlayoutid, linearLayout);
                LinearLayout item = (LinearLayout) linearLayout.getChildAt(i);
                item.setTag(i);
                item.setOnClickListener(this);
                ImageView imageView = (ImageView) item.getChildAt(0);
                TextView textView = (TextView) item.getChildAt(1);
                BottomBarItemData itemData = itemDatas.get(i);
                imageView.setImageResource(itemData.unselimgid);
                textView.setText(itemData.text);
                textView.setTextColor(Color.parseColor(unselColor));

            }

            LinearLayout item = (LinearLayout) linearLayout.getChildAt(selItemPosition);
            item.setTag(selItemPosition);
            item.setOnClickListener(this);
            ImageView imageView = (ImageView) item.getChildAt(0);
            TextView textView = (TextView) item.getChildAt(1);
            BottomBarItemData itemData = itemDatas.get(selItemPosition);
            imageView.setImageResource(itemData.selimgid);
            textView.setTextColor(Color.parseColor(selColor));


        }


    }

    @Override
    public void onClick(View v) {
        int tag = (int) v.getTag();

        int size = itemDatas.size();
        for (int i = 0; i < size; i++) {
            LinearLayout item = (LinearLayout) linearLayout.getChildAt(i);
            ImageView imageView = (ImageView) item.getChildAt(0);
            TextView textView = (TextView) item.getChildAt(1);
            BottomBarItemData itemData = itemDatas.get(i);
            imageView.setImageResource(itemData.unselimgid);
            textView.setTextColor(Color.parseColor(unselColor));

        }


        LinearLayout item = (LinearLayout) linearLayout.getChildAt(tag);
        ImageView imageView = (ImageView) item.getChildAt(0);
        TextView textView = (TextView) item.getChildAt(1);
        BottomBarItemData itemData = itemDatas.get(tag);
        imageView.setImageResource(itemData.selimgid);
        textView.setTextColor(Color.parseColor(selColor));

        listener.onItemClick(tag);

    }
}
