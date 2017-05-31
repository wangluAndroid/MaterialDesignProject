package com.androidwanga.serenitynanian.serenityproject;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BehaviorActivity extends AppCompatActivity {

    private TextView dependency ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior);

        dependency = (TextView) findViewById(R.id.dependency);
        dependency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewCompat.offsetTopAndBottom(dependency,5);
            }
        });

    }
}
