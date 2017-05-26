package com.androidwanga.serenitynanian.serenityproject;

import android.support.design.internal.SnackbarContentLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SnackBarActivity extends AppCompatActivity {

    private CoordinatorLayout mCoordinatorLayout ;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);


        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);

        initSnackbar();
    }

    private void initSnackbar() {
        //通过调用静态方法make创建Snackbar对象；
        snackbar = Snackbar.make(mCoordinatorLayout, "MessageView", Snackbar.LENGTH_INDEFINITE);
        //给actionView的字体设置颜色
        snackbar.setActionTextColor(getResources().getColor(R.color.colorAccent));
        snackbar.setAction("actionView", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SnackBarActivity.this, "点击了actionview", Toast.LENGTH_SHORT).show();
            }
        });
        //显示snackbar
        snackbar.show();

        changeSnackbarBackground();
    }

    //改变MessageView字体颜色
    public void changeMessageViewTextColor(){
        ViewGroup view = (ViewGroup) snackbar.getView();
        SnackbarContentLayout childAt = (SnackbarContentLayout) view.getChildAt(0);
        //得到MessageView
        TextView messageView = (TextView) childAt.getChildAt(0);
        messageView.setTextColor(getResources().getColor(android.R.color.white));
    }

    //改变Snackbar的背景颜色
    public void changeSnackbarBackground() {
        View view = snackbar.getView();
        view.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
    }
    public void button(View view) {
        snackbar.show();
    }
}
