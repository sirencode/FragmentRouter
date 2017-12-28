package com.example.shenyonghe.fragmentrouter.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shenyonghe.fragmentrouter.PositionUtil;
import com.example.shenyonghe.fragmentrouter.R;
import com.example.shenyonghe.fragmentrouter.UpdatePosition;
import com.example.shenyonghe.fragmentrouter.trade.AccountFragment;
import com.example.shenyonghe.fragmentrouter.trade.CreateOrderFragment;
import com.example.shenyonghe.fragmentrouter.trade.EntrustFragment;
import com.example.shenyonghe.fragmentrouter.trade.HoldingFragment;
import com.example.shenyonghe.fragmentrouter.trade.QueryFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shenyonghe on 2017/12/28.
 */

public class TradeFragment extends BaseFragment implements View.OnClickListener {

    private ViewPager viewPager;
    private List<Fragment> listfragment;
    private MainAdapter mainAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trade, container, false);
        initViews(view);
        return view;
    }

    @Override
    public void updatePosition(Object data) {
        if (data != null) {
            JumpNavigation jumpNavigation = (JumpNavigation) data;
            PositionUtil.setData(jumpNavigation,viewPager,listfragment);
        }
    }

    private void initViews(View view) {
        viewPager = view.findViewById(R.id.viewPager);
        view.findViewById(R.id.iv_createOrder).setOnClickListener(this);
        view.findViewById(R.id.iv_holding).setOnClickListener(this);
        view.findViewById(R.id.iv_entrust).setOnClickListener(this);
        view.findViewById(R.id.iv_quire).setOnClickListener(this);
        view.findViewById(R.id.iv_account).setOnClickListener(this);
        listfragment = new ArrayList<>();
        listfragment.add(new CreateOrderFragment());
        listfragment.add(new HoldingFragment());
        listfragment.add(new EntrustFragment());
        listfragment.add(new QueryFragment());
        listfragment.add(new AccountFragment());
        mainAdapter = new MainAdapter(getChildFragmentManager(), listfragment);
        viewPager.setAdapter(mainAdapter);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setCurrentItem(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_createOrder:
                viewPager.setCurrentItem(0);
                break;
            case R.id.iv_holding:
                viewPager.setCurrentItem(1);
                break;
            case R.id.iv_entrust:
                viewPager.setCurrentItem(2);
                break;
            case R.id.iv_quire:
                viewPager.setCurrentItem(3);
                break;
            case R.id.iv_account:
                viewPager.setCurrentItem(4);
                break;
            default:
                break;
        }
    }
}
