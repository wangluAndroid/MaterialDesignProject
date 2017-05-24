package com.androidwanga.serenitynanian.serenityproject;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class SwipeDismissBehaviorActivity extends AppCompatActivity {

    private LinearLayout mSwipeDissmissBehaviorLayout ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_dismiss_behavior);

        mSwipeDissmissBehaviorLayout = (LinearLayout) findViewById(R.id.swipedismissbehavior);

        SwipeDismissBehavior swipeDismissBehavior = new SwipeDismissBehavior();

        /**
         * 设置滑动的方向，有三个值：
         * 1.SWIPE_DIRECTION_START_TO_END 表示只能从左向右滑动
         * 2.SWIPE_DIRECTION_END_TO_START 表示只能从右向左滑动
         * 3.SWIPE_DIRECTION_ANY 表示向左向右都可以滑动
         */
        swipeDismissBehavior.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_START_TO_END);
        //在View的透明度改变之前的最小的滑动距离----也就是View滑动了最小距离后才会出现透明度的变化
        swipeDismissBehavior.setStartAlphaSwipeDistance(0.5f);
        //对View的透明度变化持续的最大滑动距离
        swipeDismissBehavior.setEndAlphaSwipeDistance(1f);
        /**
         * 设置滑动的灵敏度
         * Larger values are more sensitive. 1.0f is normal.
         */
        swipeDismissBehavior.setSensitivity(100f);

        swipeDismissBehavior.setListener(new SwipeDismissBehavior.OnDismissListener() {
            @Override
            public void onDismiss(View view) {
                System.out.println("SwipeDismissBehaviorActivity.onDismiss");
            }

            @Override
            public void onDragStateChanged(int state) {
                System.out.println("SwipeDismissBehaviorActivity.onDragStateChanged");
            }
        });

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) mSwipeDissmissBehaviorLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.setBehavior(swipeDismissBehavior);
        }
    }
}
