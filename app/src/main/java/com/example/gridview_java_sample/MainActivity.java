package com.example.gridview_java_sample;

//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

import android.widget.GridView;
import android.widget.Adapter;

public class MainActivity extends AppCompatActivity {

    // 表示する画像の名前（拡張子無し）
    private String members[] = {
            "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine","ten"
    };

    // Resource IDを格納するarray
    private List<Integer> imgList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // for-each member名をR.drawable.名前としてintに変換してarrayに登録
        for (String member: members){
            int imageId = getResources().getIdentifier(
                    member,"drawable", getPackageName());
            imgList.add(imageId);
        }

        // GridViewのインスタンスを生成
        GridView gridview = findViewById(R.id.gridview);
        // BaseAdapter を継承したGridAdapterのインスタンスを生成
        // 子要素のレイアウトファイル grid_items.xml を
        // activity_main.xml に inflate するためにGridAdapterに引数として渡す
        GridAdapter adapter = new GridAdapter(this.getApplicationContext(),
                R.layout.grid_items,
                imgList,
                members
        );

        // gridViewにadapterをセット
        gridview.setAdapter(adapter);

    }
}
