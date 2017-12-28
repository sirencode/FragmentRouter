package com.example.shenyonghe.fragmentrouter.main;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import com.example.shenyonghe.fragmentrouter.PositionUtil;
import com.example.shenyonghe.fragmentrouter.R;
import com.example.shenyonghe.fragmentrouter.UpdatePosition;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private List<Fragment> listfragment;
    private MainAdapter mainAdapter;
    public static final String POSITION_DATA = "position_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null && intent.hasExtra(POSITION_DATA)) {
            setPosition(intent);
        }
    }

    private void setPosition(Intent intent) {
        JumpNavigation jumpNavigation = intent.getParcelableExtra(POSITION_DATA);
        if (jumpNavigation != null) {
            PositionUtil.setData(jumpNavigation,viewPager,listfragment);
        }
    }

    private void initViews() {
        viewPager = findViewById(R.id.viewPager);
        findViewById(R.id.iv_home).setOnClickListener(this);
        findViewById(R.id.iv_live).setOnClickListener(this);
        findViewById(R.id.iv_quote).setOnClickListener(this);
        findViewById(R.id.iv_trade).setOnClickListener(this);
        findViewById(R.id.iv_me).setOnClickListener(this);
        listfragment = new ArrayList<>();
        listfragment.add(new HomeFragment());
        listfragment.add(new LiveFragment());
        listfragment.add(new QuoteFragment());
        listfragment.add(new TradeFragment());
        listfragment.add(new MeFragment());
        mainAdapter = new MainAdapter(getSupportFragmentManager(), listfragment);
        viewPager.setAdapter(mainAdapter);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setCurrentItem(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_home:
                viewPager.setCurrentItem(0);
                break;
            case R.id.iv_live:
                viewPager.setCurrentItem(1);
                break;
            case R.id.iv_quote:
                viewPager.setCurrentItem(2);
                break;
            case R.id.iv_trade:
                viewPager.setCurrentItem(3);
                break;
            case R.id.iv_me:
                viewPager.setCurrentItem(4);
                break;
            default:
                break;
        }
    }
}
