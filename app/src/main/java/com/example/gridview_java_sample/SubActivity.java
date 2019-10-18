package com.example.gridview_java_sample;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        int imageId = intent.getIntExtra("IMAGEID", 0);

        ImageView imageView = findViewById(R.id.image_view);
        imageView.setImageResource(imageId);

    }
}