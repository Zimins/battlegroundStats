package com.zimincom.battlegroundstats;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Zimincom on 2017. 8. 13..
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter{


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return StatMode.overview.name();
            case 1:
                return StatMode.solo.name();
            case 2:
                return StatMode.duo.name();
            case 3:
                return StatMode.squad.name();
        }
        return "";
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        if (position == 0) {
            fragment = new OverviewFragment();
        } else {
            fragment = new StatFragment();
        }

        // TODO: 2017. 8. 13. statfragment 에 게임 모드 정보 보내기  
        Bundle args = new Bundle();
        args.putString("key_statmode", getPageTitle(position).toString());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
