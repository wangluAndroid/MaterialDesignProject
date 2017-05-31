package com.androidwanga.serenitynanian.serenityproject;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidwanga.serenitynanian.serenityproject.fragment.DemoFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {
    private TabLayout mTabLayout ;

    private ViewPager mViewPager ;

    public static int[] images = {R.mipmap.ic_launcher_round};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        mTabLayout = (TabLayout) findViewById(R.id.ac_tablayout);
        mViewPager = (ViewPager) findViewById(R.id.tablayout_viewpager);


        //最基本的使用
//        TabLayout.Tab tab = mTabLayout.newTab();
//        tab.setText("您好");
//        mTabLayout.addTab(tab);
//        mTabLayout.addTab(tab); //tab不能复用 否则会crash
//        mTabLayout.addTab(mTabLayout.newTab().setText("tab2"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("tab3"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("tab4"));

//        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//        mTabLayout.removeOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//        mTabLayout.clearOnTabSelectedListeners();
//
//        mTabLayout.getTabAt(0);
//
//        mTabLayout.setupWithViewPager(ViewPager viewPaager);
        List<String> titles = new ArrayList<>();
        for (int i = 'A';i<'z';i++) {
            titles.add("" + (char) i);
        }
        List<Fragment> fragments = new ArrayList<>();
        for (String title : titles) {
            DemoFragment fragment = new DemoFragment().newInstance(title);
            fragments.add(fragment);
        }

        DemoFragmentAdapter adapter = new DemoFragmentAdapter(this,getSupportFragmentManager(),titles,fragments);

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

        /**
         * 给每一个Tab设置自定义布局
         */
        for (int i = 0;i<mTabLayout.getTabCount();i++) {
            TabLayout.Tab tab_item = mTabLayout.getTabAt(i);
            tab_item.setCustomView(adapter.getCustomTabView(i));
        }


    }

    public static class DemoFragmentAdapter extends FragmentPagerAdapter{

        private List<String> titles ;
        private List<Fragment> fragments ;
        private Context mContext ;

        public DemoFragmentAdapter(Context context , FragmentManager fm , List<String> titles , List<Fragment> fragments) {
            super(fm);
            this.titles = titles;
            this.fragments = fragments ;
            this.mContext = context ;
        }


        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return titles == null ? 0 : titles.size();
        }

        /**
         * 重写此方法，返回TabLayout中Tab的文本内容并设置给其内部类Tab
         * @param position
         * @return
         */
//        @Override
//        public CharSequence getPageTitle(int position) {
////            return super.getPageTitle(position);
//            return titles.get(position);
//        }


        /**
         * 设置带图片的Tab项，只这样设置会看不到文本内容，因为TabLayout创建的tab默认样式的textAllCaps属性为true，
         * 这阻止了ImageSpan被渲染出来，可以通过设置TabLayout的样式来改变，具体的看styles.xml----在实际的测试中，
         * 不设置此style也能显示出来；
         *  <style name="CustomTabLayoutStyle" parent="AppTheme" >
         *     <item name="android:textAllCaps">false</item>
         *     <item name="android:textSize">20sp</item>
         </style>
         * @param position
         * @return
         */
//        @Override
//        public CharSequence getPageTitle(int position) {
//            SpannableString sb = new SpannableString("       " + titles.get(position));
//            Drawable drawable = mContext.getResources().getDrawable(images[0]);
//            drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
//            ImageSpan imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);
//            sb.setSpan(imageSpan,0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            return sb;
//        }


        /**
         * 使用我们自定义的布局时，这里返回null
         * @param position
         * @return
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return null ;
        }

        /**
         * 定义一个方法 返回tab中要显示的内容；
         * 注意：在我们使用自定义的tab时，将getPagerTitle返回null，不设置也一样的
         * @param position
         * @return
         */
        public View getCustomTabView(int position) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_tablayout, null);
            ImageView image = (ImageView) view.findViewById(R.id.item_imageview);
            TextView textView = (TextView) view.findViewById(R.id.item_textview);
            textView.setText(titles.get(position));
            image.setImageResource(images[0]);
            return view ;

        }
    }

}
