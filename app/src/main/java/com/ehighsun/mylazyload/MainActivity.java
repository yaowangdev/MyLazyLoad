package com.ehighsun.mylazyload;

import android.os.Bundle;
import android.support.design.widget.TabLayout;

public class MainActivity extends BaseActivity {

    private NoScrollViewLPager mViewPager;
    private TabLayout mTabLayout;
    private LazyLoadAdapter mAdapter;

    private int mSelectedPosition = 0;


    @Override
    protected void init(Bundle savedInstanceState) {
        initView();
        if(savedInstanceState!=null){
            mSelectedPosition = savedInstanceState.getInt(KEY_BUNDLE);
        }
        mAdapter = new LazyLoadAdapter(this, getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager,true);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setScanScroll(true);
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            if (tab == null) continue;
            tab.setCustomView(mAdapter.getTabView(i));
        }
        mAdapter.selectedTab(mSelectedPosition);
        initListener();
    }

    private void initView(){
        mViewPager = (NoScrollViewLPager) findViewById(R.id.viewPager);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
    }

    private void initListener() {
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mSelectedPosition = mTabLayout.getSelectedTabPosition();
                mAdapter.selectedTab(mSelectedPosition);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }


    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_BUNDLE,mSelectedPosition);
    }
}
