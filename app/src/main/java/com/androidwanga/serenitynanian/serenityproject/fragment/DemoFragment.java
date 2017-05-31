package com.androidwanga.serenitynanian.serenityproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidwanga.serenitynanian.serenityproject.R;

/**
 * Created by serenitynanian on 2017/5/31.
 */

public class DemoFragment extends Fragment {

    public static DemoFragment newInstance(String desc) {

        Bundle args = new Bundle();
        args.putString("desc",desc);
        DemoFragment fragment = new DemoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        TextView textView = (TextView) view.findViewById(R.id.fragment_textview);
        textView.setText(getArguments().getString("desc"));
        return view;
    }
}
