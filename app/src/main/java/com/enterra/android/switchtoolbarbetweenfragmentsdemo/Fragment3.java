package com.enterra.android.switchtoolbarbetweenfragmentsdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Nguyen on 6/9/2016.
 */
public class Fragment3 extends BaseFragment {

    @Bind(R.id.toolbar)
    protected Toolbar toolbar;
    @Bind(R.id.systemBar)
    protected View systemBar;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment3, container, false);
        ButterKnife.bind(this, view);
        if (systemBar != null) {
            systemBar.getLayoutParams().height = getStatusBarHeight();
            systemBar.requestLayout();
        }
        return view;
    }
}
