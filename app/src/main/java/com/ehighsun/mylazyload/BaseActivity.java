package com.ehighsun.mylazyload;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ehighsun.fragment_rigger.annotation.Puppet;

/**
 * Created by Administrator on 2018/3/2 0002.
 */

@Puppet(containerViewId = R.id.atyContent, bondContainerView = true)
public abstract class BaseActivity extends AppCompatActivity {
    protected static final String KEY_BUNDLE = "/key/bundle";




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        init(savedInstanceState);
    }

    @LayoutRes
    protected int getContentView() {
        return R.layout.activity_content;
    }

    protected abstract void init(Bundle savedInstanceState);

}
