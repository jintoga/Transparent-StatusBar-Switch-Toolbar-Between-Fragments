package com.enterra.android.switchtoolbarbetweenfragmentsdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.enterra.android.switchtoolbarbetweenfragmentsdemo.CoverFlow.CoverFlowAdapter;
import com.enterra.android.switchtoolbarbetweenfragmentsdemo.CoverFlow.GameEntity;
import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;
import java.util.ArrayList;

/**
 * Created by Nguyen on 6/9/2016.
 */
public class TransparentStatusBarType1Fragment extends BaseFragment {
    @Bind(R.id.coverflow)
    protected FeatureCoverFlow mCoverFlow;
    private CoverFlowAdapter mAdapter;
    private ArrayList<GameEntity> mData = new ArrayList<>(0);
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.transparent_statusbar_type1_fragment, container, false);
        ButterKnife.bind(this, view);

        mData.add(new GameEntity(R.drawable.image_1, R.string.title1));
        mData.add(new GameEntity(R.drawable.image_2, R.string.title2));
        mData.add(new GameEntity(R.drawable.image_3, R.string.title3));
        mData.add(new GameEntity(R.drawable.image_4, R.string.title4));

        initCoverFlow();
        return view;
    }

    private void initCoverFlow() {
        mAdapter = new CoverFlowAdapter(getContext());
        mAdapter.setData(mData);
        mCoverFlow.setAdapter(mAdapter);

        mCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),
                    getResources().getString(mData.get(position).titleResId), Toast.LENGTH_SHORT)
                    .show();
            }
        });
    }
}
