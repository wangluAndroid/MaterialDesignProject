package com.androidwanga.serenitynanian.serenityproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BottomDialogFragmentActivity extends AppCompatActivity {

    private DemoBottomSheetDialogFragment demoBottomSheetDialogFragment ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_dialog_fragment);

        demoBottomSheetDialogFragment = DemoBottomSheetDialogFragment.newInstance();
        //显示dialogFragment
        showBottomSheetDialogFragment();


    }

    public void showdialog(View view) {
        showBottomSheetDialogFragment();
    }
    public void hidedialog(View view) {
        //隐藏dialogFragment
        hideBottomSheetDialogFragment();
    }

    /**
     * 显示BottomSheetDialogFragment
     */
    private void hideBottomSheetDialogFragment() {
        if (demoBottomSheetDialogFragment == null) {
            demoBottomSheetDialogFragment.dismiss();
        }
    }

    /**
     * 显示BottomSheetDialogFragment
     */
    private void showBottomSheetDialogFragment() {
        demoBottomSheetDialogFragment.show(getSupportFragmentManager(),"bottomSheetDialogFragment");
    }



}
