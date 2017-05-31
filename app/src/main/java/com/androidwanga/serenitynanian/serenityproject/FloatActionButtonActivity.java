package com.androidwanga.serenitynanian.serenityproject;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FloatActionButtonActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView ;
    private FAB_Adapter adapter;

    private FloatingActionButton mFab ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float_action_button);

        mFab = (FloatingActionButton) findViewById(R.id.activity_float_action_button_fab);

        initRecyclerView();

        /**
         * 在代码中动态设置Fab的隐藏和显示，并且能够
         * 监听Fab的隐藏和显示的状态变化；
         */
//        mFab.show(new FloatingActionButton.OnVisibilityChangedListener() {
//            @Override
//            public void onShown(FloatingActionButton fab) {
//                super.onShown(fab);
//                Toast.makeText(FloatActionButtonActivity.this, "show", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        mFab.hide(new FloatingActionButton.OnVisibilityChangedListener() {
//            @Override
//            public void onHidden(FloatingActionButton fab) {
//                super.onHidden(fab);
//                Toast.makeText(FloatActionButtonActivity.this, "hidden", Toast.LENGTH_SHORT).show();
//            }
//        });

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FloatActionButtonActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.fab_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        adapter = new FAB_Adapter();
        handlerData();
        mRecyclerView.setAdapter(adapter);
    }

    private void handlerData() {
        List<String> list = new ArrayList<>();
        for (int i = 0 ;i<30;i++) {
            list.add(i + "");
        }
        adapter.setData(list);
    }

    public static class FAB_Adapter extends RecyclerView.Adapter<FAB_ViewHolder>{

        private List<String> data ;

        public void setData(List<String> list) {
            this.data = list ;
        }

        @Override
        public FAB_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bottom_sheet_item, null, false);
            return new FAB_ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(FAB_ViewHolder holder, int position) {
            holder.name.setText("position:"+data.get(position));
            holder.index.setText(position+"");
        }

        @Override
        public int getItemCount() {
            return data == null ? 0 : data.size();
        }
    }
    public static class FAB_ViewHolder extends RecyclerView.ViewHolder{
        private TextView name ;
        private TextView index ;

        public FAB_ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.bottom_sheet_dialog_item_name);
            index = (TextView) itemView.findViewById(R.id.bottom_sheet_dialog_item_index);
        }
    }
}
