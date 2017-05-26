package com.androidwanga.serenitynanian.serenityproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetDialogActivity extends AppCompatActivity {

    private Button mBotton ;
    private Button  mShareDialog ;
    private BottomSheetDialog bottomSheetDialog;
    private Button mBottomDialog ;
    private Button mBottomDialogFragment ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_dialog);
        //bottomDialog
        mBottomDialog = (Button) findViewById(R.id.button3);
        mBottomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialog();
            }
        });

        //bottomDialogFragment
        mBottomDialogFragment = (Button) findViewById(R.id.button4);
        mBottomDialogFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomDialogFragment();
            }
        });

        //bottomSheetDialg动态布局
        mBotton = (Button) findViewById(R.id.button);
        mBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomDialog();
            }
        });

        //bottomSheetDialg固定布局
        mShareDialog = (Button) findViewById(R.id.button2);
        mShareDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSharedDialog();
            }
        });

    }

    /**
     * bottomDialogFragment的使用
     */
    private void bottomDialogFragment() {
        Intent intent = new Intent(this, BottomDialogFragmentActivity.class);
        startActivity(intent);
    }

    /**
     * bottomDialog
     *bottomDialog依赖于CoordinatorLayout布局和behavior
     * 底部菜单必须作为CoordinatorLayout的子View，并且需要设置
     * app:layout_behavior = "@string/bottom_sheet_behavior"
     */
    private void bottomDialog() {
        Intent intent = new Intent(this, BottomDialogActivity.class);
        startActivity(intent);
    }

    /**
     * bottomSheetDialg固定布局
     */
    private void showSharedDialog() {

        if (bottomSheetDialog == null) {
            bottomSheetDialog = new BottomSheetDialog(this);
            bottomSheetDialog.setCancelable(true);
            bottomSheetDialog.setCanceledOnTouchOutside(true);
            //这里的layout是要显示的布局内容，里面可以放RecyclerView等
            View view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_share_dialog, null);
            bottomSheetDialog.setContentView(view);
            bottomSheetDialog.show();

            //以下设置是为了解决：下滑隐藏dialog后，下次再次调用show方法显示时（没有重新new的情况下），不能弹出Dialog
            // 原因是因为在BottomSheetDialog源码中，关闭dialog是依赖BottomSheetBehavior的，
            // 当下滑隐藏时，BottomSheet的z状态为STATE_HIDDEN,并同时调用dialog的dismiss,下此再调用show方法时，
            // 是无法将一个状态为HIDDEN的布局显示的----在真机测试时不写下面的方法也未发现问题
            View delegateView = bottomSheetDialog.getDelegate().findViewById(android.support.design.R.id.design_bottom_sheet);
            //获得与之关联的BottomSheetBehavior,重新设置监听，在dimiss的时候，重新设置Behavior的状态；
            final BottomSheetBehavior<View> sheetBehavior = BottomSheetBehavior.from(delegateView);
            sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                //在下滑隐藏结束时才会触发
                @Override
                public void onStateChanged(@NonNull View bottomSheet, int newState) {
                    if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                        bottomSheetDialog.dismiss();
                        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    }
                }
                //每次滑动都会触发
                @Override
                public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                    System.out.println("onSlide = [" + bottomSheet + "], slideOffset = [" + slideOffset + "]");
                }
            });
        } else {
            bottomSheetDialog.show();
        }
    }

    /**
     * bottomSheetDialog动态布局
     */
    private void showBottomDialog() {

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_layout, null);

        handleList(view);

        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.show();
    }


    private void handleList(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        MyRecyclerAdapter adapter = new MyRecyclerAdapter();
        recyclerView.setAdapter(adapter);

        adapter.setData(getDatas());
        adapter.notifyDataSetChanged();
    }

    private List<String> getDatas() {
        List<String> list = new ArrayList<>();
        for (int i = 0 ;i<30 ;i++) {
            list.add("android："+i);
        }
        return list;
    }


    public static class MyRecyclerAdapter extends RecyclerView.Adapter{

        private List<String> mData ;

        public void setData(List<String> list) {
            mData = list ;
        }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bottom_sheet_item,null));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            myViewHolder.index.setText(mData.get(position)+"");
            myViewHolder.name.setText(mData.get(position)+"");
        }

        @Override
        public int getItemCount() {
            return mData == null ? 0 :mData.size();
        }



        public static class MyViewHolder extends RecyclerView.ViewHolder{

            private TextView name ;
            private TextView index ;
            public MyViewHolder(View itemView) {
                super(itemView);
                name = (TextView) itemView.findViewById(R.id.bottom_sheet_dialog_item_name);
                index = (TextView) itemView.findViewById(R.id.bottom_sheet_dialog_item_index);
            }
        }
    }

}
