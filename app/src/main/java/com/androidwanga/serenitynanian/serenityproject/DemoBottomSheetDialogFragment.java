package com.androidwanga.serenitynanian.serenityproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by serenitynanian on 2017/5/26.
 */

public class DemoBottomSheetDialogFragment extends BottomSheetDialogFragment {

    public static DemoBottomSheetDialogFragment newInstance() {

        Bundle args = new Bundle();

        DemoBottomSheetDialogFragment fragment = new DemoBottomSheetDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //填充自己的想要的布局
        View view = inflater.inflate(R.layout.layout_bottom_sheet_linear, container, false);
        return view;
    }
}
