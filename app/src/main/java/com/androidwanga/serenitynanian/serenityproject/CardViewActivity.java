package com.androidwanga.serenitynanian.serenityproject;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

public class CardViewActivity extends AppCompatActivity {

    private CardView mCardView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        mCardView = (CardView) findViewById(R.id.cardview_cardview);
        //设置CradView背景
        mCardView.setCardBackgroundColor(ColorStateList.valueOf(getResources().getColor(android.R.color.holo_orange_dark)));
        //设置CardView的阴影
        mCardView.setCardElevation(3);
        //设置圆角
        mCardView.setRadius(10);
        //设置兼容padding
        mCardView.setUseCompatPadding(true);
        mCardView.setPreventCornerOverlap(true);
    }
}
