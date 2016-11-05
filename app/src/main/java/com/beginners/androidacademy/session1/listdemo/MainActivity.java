package com.beginners.androidacademy.session1.listdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openListViewDemo(View view) {
        startActivity(new Intent(this, ListViewDemoActivity.class));
    }

    public void openRecyclerViewDemo(View view) {
        startActivity(new Intent(this, RecyclerViewDemoActivity.class));

    }
}
