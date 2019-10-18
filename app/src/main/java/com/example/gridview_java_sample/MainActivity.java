package com.example.gridview_java_sample;

//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.view.ViewGroup;
import android.widget.Adapter;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {

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
        GridAdapter adapter1 = new GridAdapter(this.getApplicationContext(),
                R.layout.grid_items,
                imgList,
                members
        );

        // gridViewにadapterをセット
        gridview.setAdapter(adapter1);

        // item clickのListnerをセット
        gridview.setOnItemClickListener(this);

        Spinner spinner=findViewById(R.id.plain_spinnar);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.plain_array,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getApplication(), SubActivity.class);
        intent.putExtra("IMAGEID", imgList.get(position));
        startActivity( intent );
    }

}
