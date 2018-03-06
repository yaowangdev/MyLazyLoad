package com.ehighsun.mylazyload;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.ehighsun.fragment_rigger.annotation.LazyLoad;

/**
 * Created by Administrator on 2018/3/2 0002.
 */
@LazyLoad
public class FirstFragment extends BaseFragment {

    private boolean isPrepared;
    private boolean mHasLoadedOnce;
    private String mValue;

    public static FirstFragment newInstance(String value) {
        Bundle args = new Bundle();
        args.putString(KEY_ARGS,value);
        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_one;
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            findViewById(R.id.flc_load).setVisibility(View.GONE);
            findViewById(R.id.flc_tv).setVisibility(View.VISIBLE);
            mHasLoadedOnce = true;
        }
    };

    @Override
    protected void init(Bundle savedInstanceState) {
        Bundle args = savedInstanceState == null ? getArguments() : savedInstanceState;
        mValue = args.getString(KEY_ARGS);

        isPrepared = true;
        lazyLoad();
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible || mHasLoadedOnce) {
            return;
        }
        ((TextView) findViewById(R.id.flc_tv)).setText(mValue);
        mHandler.sendEmptyMessageDelayed(1001, 1000);
    }
}
