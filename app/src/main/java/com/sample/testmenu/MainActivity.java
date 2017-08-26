package com.sample.testmenu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import cn.kotliner.support.v7.widget.ScaleOnScrollListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MyAdapter());
//        new LinearSnapHelper().attachToRecyclerView(recyclerView);
//        recyclerView.scrollToPosition(Integer.MAX_VALUE / 2);

        recyclerView.addOnScrollListener(new ScaleOnScrollListener() {
            @Override
            protected void onScrolled(@NonNull View view, float percent) {
                super.onScrolled(view, percent);
                TextView textView = (TextView) view.findViewById(R.id.item_root);
                textView.setText(Float.toString(percent));
            }
        });

        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                recyclerView.smoothScrollBy(0, 2);
                recyclerView.postDelayed(this, 100);
            }
        });
    }

}
