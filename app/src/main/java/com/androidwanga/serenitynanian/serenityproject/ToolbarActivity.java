package com.androidwanga.serenitynanian.serenityproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ToolbarActivity extends AppCompatActivity {
    private Toolbar mToolbar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("woca");
        setSupportActionBar(mToolbar);
        //设置NavigationIcon的点击事件
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
//                Toast.makeText(ToolbarActivity.this, "1", Toast.LENGTH_SHORT).show();
            }
        });
        mToolbar.setLogo(R.mipmap.ic_launcher_round);
        mToolbar.inflateMenu(R.menu.item_menu);
        //设置logo距离NavigationIcon的距离的
//        mToolbar.setContentInsetStartWithNavigation(0);
        //设置overflow menu中的item监听
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_one:
                        Toast.makeText(ToolbarActivity.this, "one", Toast.LENGTH_SHORT).show();
                        break;
//                    case R.id.menu_tow:
//                        Toast.makeText(MainActivity.this, "two", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.menu_three:
//                        Toast.makeText(MainActivity.this, "three", Toast.LENGTH_SHORT).show();
//                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu,menu);
        return true;
    }
}
