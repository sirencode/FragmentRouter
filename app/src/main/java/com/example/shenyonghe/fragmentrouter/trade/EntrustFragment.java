package com.example.shenyonghe.fragmentrouter.trade;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shenyonghe.fragmentrouter.PositionUtil;
import com.example.shenyonghe.fragmentrouter.main.BaseFragment;
import com.example.shenyonghe.fragmentrouter.R;
import com.example.shenyonghe.fragmentrouter.main.JumpNavigation;
import com.example.shenyonghe.fragmentrouter.main.MainAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shenyonghe on 2017/12/28.
 */

public class EntrustFragment extends BaseFragment implements View.OnClickListener {

    private ViewPager viewPager;
    private List<Fragment> listfragment;
    private MainAdapter mainAdapter;

    private JumpNavigation jumpNavigation;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_entrust, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        viewPager = view.findViewById(R.id.viewPager);
        view.findViewById(R.id.iv_to_entrust).setOnClickListener(this);
        view.findViewById(R.id.iv_entrusting).setOnClickListener(this);
        listfragment = new ArrayList<>();
        listfragment.add(new ToEntrustFragment());
        listfragment.add(new EntrustingFragment());
        mainAdapter = new MainAdapter(getChildFragmentManager(), listfragment);
        viewPager.setAdapter(mainAdapter);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setCurrentItem(0);
        PositionUtil.setData(jumpNavigation, viewPager, listfragment);
    }

    @Override
    public void updatePosition(Object data) {
        if (data != null) {
            jumpNavigation = (JumpNavigation) data;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_to_entrust:
                viewPager.setCurrentItem(0);
                break;
            case R.id.iv_entrusting:
                viewPager.setCurrentItem(1);
                break;
        }
    }
}
