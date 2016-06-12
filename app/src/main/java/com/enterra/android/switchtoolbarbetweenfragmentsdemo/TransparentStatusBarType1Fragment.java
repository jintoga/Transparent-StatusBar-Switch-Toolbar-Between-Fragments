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
public class TransparentStatusBarType1Fragment extends BaseFragment {

    @Bind(R.id.toolbar)
    protected Toolbar toolbar;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.transparent_statusbar_type1_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
