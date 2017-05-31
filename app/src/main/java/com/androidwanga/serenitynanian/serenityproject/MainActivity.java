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
    private Button mSwipeDismissBehavior ;
    private Button mTextInputLayout ;
    private Button mSnackbar ;
    private Button mBehavior ;
    private Button mFloatingActionButton ;
    private Button mCardView ;
    private Button mTabLayout ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Button) findViewById(R.id.but_toolbar);
        mBottomSheetDialog = (Button) findViewById(R.id.but_bottomsheetdialog);

        mCoordinatorLayout = (Button) findViewById(R.id.coordinatorLayout);
        mCollapsingToolbarLayout = (Button) findViewById(R.id.collapsingToolbarLayout);
        mSwipeDismissBehavior = (Button) findViewById(R.id.swipedismissbehavior);
        mTextInputLayout = (Button) findViewById(R.id.textinputlayout);
        mSnackbar = (Button) findViewById(R.id.snackbar);
        mBehavior = (Button) findViewById(R.id.behavior);
        mFloatingActionButton = (Button) findViewById(R.id.floatingactionbutton);
        mCardView = (Button) findViewById(R.id.cardview);
        mTabLayout = (Button) findViewById(R.id.tablayout);

        mToolbar.setOnClickListener(this);
        mBottomSheetDialog.setOnClickListener(this);
        mCoordinatorLayout.setOnClickListener(this);
        mCollapsingToolbarLayout.setOnClickListener(this);
        mSwipeDismissBehavior.setOnClickListener(this);
        mTextInputLayout.setOnClickListener(this);
        mSnackbar.setOnClickListener(this);
        mBehavior.setOnClickListener(this);
        mFloatingActionButton.setOnClickListener(this);
        mCardView.setOnClickListener(this);
        mTabLayout.setOnClickListener(this);

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
            case R.id.swipedismissbehavior:
                goToOtherActivity(SwipeDismissBehaviorActivity.class);
                break ;
            case R.id.textinputlayout:
                goToOtherActivity(TextInputActivity.class);
                break;
            case R.id.snackbar:
                goToOtherActivity(SnackBarActivity.class);
                break;
            case R.id.behavior:
                goToOtherActivity(BehaviorActivity.class);
                break ;
            case R.id.floatingactionbutton:
                goToOtherActivity(FloatActionButtonActivity.class);
                break;
            case R.id.cardview:
                goToOtherActivity(CardViewActivity.class);
                break ;
            case R.id.tablayout:
                goToOtherActivity(TabLayoutActivity.class);
                break ;
        }
    }

    private void goToOtherActivity(Class clazz) {
        Intent intent = new Intent(this,clazz);
        startActivity(intent);
    }
}
