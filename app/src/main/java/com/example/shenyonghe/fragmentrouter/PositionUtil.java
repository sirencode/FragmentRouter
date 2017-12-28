package com.example.shenyonghe.fragmentrouter;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.shenyonghe.fragmentrouter.main.JumpNavigation;

import java.util.List;

/**
 * Created by shenyonghe on 2017/12/28.
 */

public class PositionUtil {

    private static int getCurrentPosition(int position) {
        int len = String.valueOf(position).length();
        return (int) (position / Math.pow(10, len - 1)) - 1;
    }

    private static int getNextValue(int position) {
        int len = String.valueOf(position).length();
        return (int) (position % Math.pow(10, len - 1));
    }

    public static String setData(JumpNavigation jumpNavigation, ViewPager viewPager, List<Fragment> listfragment) {
        int position = jumpNavigation.getPageNum();
        if (position < 0 && jumpNavigation.getData() != null) {
            return jumpNavigation.getData();
        }
        int current;
        if (position - 1 <= listfragment.size()) {
            current = position - 1;
            jumpNavigation.setPageNum(-1);
        } else {
            current = PositionUtil.getCurrentPosition(position);
            jumpNavigation.setPageNum(PositionUtil.getNextValue(position));
        }
        viewPager.setCurrentItem(current);
        ((UpdatePosition) listfragment.get(current)).updatePosition(jumpNavigation);
        return null;
    }
}
