package com.example.shenyonghe.fragmentrouter.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by shenyonghe on 2017/12/28.
 */

public class MainAdapter extends FragmentPagerAdapter {

    private FragmentManager fragmetnmanager;  //创建FragmentManager
    private List<Fragment> listfragment; //创建一个List<Fragment>

    public MainAdapter(FragmentManager fm, List<Fragment> listfragment) {
        super(fm);
        this.fragmetnmanager = fm;
        this.listfragment = listfragment;
    }

    @Override
    public Fragment getItem(int position) {
        return listfragment.get(position);
    }

    @Override
    public int getCount() {
        return listfragment == null ? 0 : listfragment.size();
    }
}
