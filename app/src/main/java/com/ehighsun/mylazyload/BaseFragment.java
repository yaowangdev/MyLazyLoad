package com.ehighsun.mylazyload;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ehighsun.fragment_rigger.annotation.Puppet;

/**
 * Created by Administrator on 2018/3/2 0002.
 */
@Puppet
public abstract class BaseFragment extends Fragment{

    protected Context mContext;
    protected View mContentView;
    protected static final String KEY_ARGS = "/key/args/";
    protected boolean isVisible;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mContentView = inflater.inflate(getContentView(),container,false);
        return mContentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        init(savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()){
            isVisible=true;
            onVisible();
        } else {
            isVisible=false;
            onInvisible();
        }
    }

    @LayoutRes
    protected abstract int getContentView();

    protected abstract void init(Bundle savedInstanceState);

    protected View findViewById(@IdRes int id) {
        return mContentView.findViewById(id);
    }

    /**
     * 可见
     */
    protected void onVisible() {
        lazyLoad();
    }

    /**
     * 不可见
     */
    protected void onInvisible() {
    }


    /**
     * 延迟加载
     * 子类必须重写此方法
     */
    protected abstract void lazyLoad();
}
