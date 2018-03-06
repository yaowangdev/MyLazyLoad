package com.ehighsun.mylazyload;

import android.os.Bundle;

/**
 * Created by Administrator on 2018/3/5 0005.
 */

public class MainFragment extends BaseFragment {
    @Override
    protected int getContentView() {
        return 0;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected void lazyLoad() {

    }

//    private NoScrollViewLPager mViewPager;
//    private TabLayout mTabLayout;
//    private LazyLoadAdapter mAdapter;
//
//    private int mSelectedPosition = 0;
//
//    public static MainFragment newInstance() {
//        Bundle args = new Bundle();
//        MainFragment fragment = new MainFragment();
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//
//    @Override
//    protected void init(Bundle savedInstanceState) {
//        initView();
//        if(savedInstanceState!=null){
//            mSelectedPosition = savedInstanceState.getInt(KEY_BUNDLE);
//        }
//        mAdapter = new LazyLoadAdapter(mContext, getChildFragmentManager());
//        mViewPager.setAdapter(mAdapter);
//        mTabLayout.setupWithViewPager(mViewPager,true);
//        mViewPager.setOffscreenPageLimit(4);
//        mViewPager.setScanScroll(false);
//        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
//            TabLayout.Tab tab = mTabLayout.getTabAt(i);
//            if (tab == null) continue;
//            tab.setCustomView(mAdapter.getTabView(i));
//        }
//        mAdapter.selectedTab(mSelectedPosition);
//        initListener();
//    }
//
//    private void initView(){
//        mViewPager = (NoScrollViewLPager) findViewById(R.id.viewPager);
//        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
//    }
//
//    private void initListener() {
//        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                mSelectedPosition = mTabLayout.getSelectedTabPosition();
//                mAdapter.selectedTab(mSelectedPosition);
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//            }
//        });
//    }
//
//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt(KEY_BUNDLE,mSelectedPosition);
//    }
//
//    @Override
//    protected int getContentView() {
//        return R.layout.activity_main;
//    }
//
//    public void onFragmentResult(int requestCode, int resultCode, Bundle args) {
//        Logger.i(this, "requestCode=" + requestCode);
//        Logger.i(this, "resultCode=" + resultCode);
//        if (resultCode != Rigger.RESULT_OK) return;
//        String string = args.getString(KEY_BUNDLE);
//        Logger.i(this, string);
//    }
}
