package com.example.shenyonghe.fragmentrouter.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shenyonghe.fragmentrouter.PosotionType;
import com.example.shenyonghe.fragmentrouter.R;

/**
 * Created by shenyonghe on 2017/12/28.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        view.findViewById(R.id.btn_goTrade).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        JumpNavigation jumpNavigation = new JumpNavigation(PosotionType.Trade_Entrusting.getValue());
        jumpNavigation.setData("Hello SB");
        intent.putExtra(MainActivity.POSITION_DATA, jumpNavigation);
        getActivity().startActivity(intent);
    }
}
