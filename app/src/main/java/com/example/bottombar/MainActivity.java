package com.example.bottombar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomBar bottomBar = findViewById(R.id.mBottomBar);
        List<BottomBarItemData> list = new ArrayList<>();
        list.add(new BottomBarItemData(R.mipmap.bottom_icon_pitchon_1, R.mipmap.bottom_icon_unselected_1, "栏目1"));
        list.add(new BottomBarItemData(R.mipmap.bottom_icon_pitchon_2, R.mipmap.bottom_icon_unselected_2, "栏目1"));
        list.add(new BottomBarItemData(R.mipmap.bottom_icon_pitchon_3, R.mipmap.bottom_icon_unselected_3, "栏目1"));
        list.add(new BottomBarItemData(R.mipmap.bottom_icon_pitchon_4, R.mipmap.bottom_icon_unselected_4, "栏目1"));
        list.add(new BottomBarItemData(R.mipmap.bottom_icon_pitchon_5, R.mipmap.bottom_icon_unselected_5, "栏目1"));
        bottomBar.setItemDatas(list)
                .setItemlayoutid(R.layout.bottom_item_icon_text_layout)
                .setSelColor("#258FC1")
                .setUnselColor("#666666")
                .setListener(new BottomBarItemClickListener() {
                    @Override
                    public void onItemClick(int position) {

                        Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_LONG).show();
                    }
                })
                .initview();
    }
}
