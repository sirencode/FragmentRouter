package com.example.shenyonghe.fragmentrouter.trade;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shenyonghe.fragmentrouter.main.BaseFragment;
import com.example.shenyonghe.fragmentrouter.R;

/**
 * Created by shenyonghe on 2017/12/28.
 */

public class QueryFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live, container, false);
        TextView title = view.findViewById(R.id.title);
        title.setText("QueryFragment");
        return view;
    }
}
