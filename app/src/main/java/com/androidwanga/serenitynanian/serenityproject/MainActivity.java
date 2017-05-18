package com.androidwanga.serenitynanian.serenityproject;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mToolbar ;
    private Button mBottomSheetDialog ;
    private Button mCoordinatorLayout;
    private Button mCollapsingToolbarLayout ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Button) findViewById(R.id.but_toolbar);
        mBottomSheetDialog = (Button) findViewById(R.id.but_bottomsheetdialog);

        mCoordinatorLayout = (Button) findViewById(R.id.coordinatorLayout);
        mCollapsingToolbarLayout = (Button) findViewById(R.id.collapsingToolbarLayout);

        mToolbar.setOnClickListener(this);
        mBottomSheetDialog.setOnClickListener(this);
        mCoordinatorLayout.setOnClickListener(this);
        mCollapsingToolbarLayout.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.but_toolbar:
                goToOtherActivity(ToolbarActivity.class);
                break ;
            case R.id.but_bottomsheetdialog:
                goToOtherActivity(BottomSheetDialogActivity.class);
                break ;
            case R.id.coordinatorLayout:
                goToOtherActivity(CoordinatorLayoutActivity.class);
                break ;
            case R.id.collapsingToolbarLayout:
                goToOtherActivity(CollapsingToolbarLayoutActivity.class);
                break ;

        }
    }

    private void goToOtherActivity(Class clazz) {
        Intent intent = new Intent(this,clazz);
        startActivity(intent);
    }
}
