package com.zimincom.battlegroundstats;

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
                return "overview";
            case 1:
                return "Solo";
            case 2:
                return "Duo";
            case 3:
                return "Squad";
        }
        return "";
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new OverviewFragment();
//        Bundle args = new Bundle();
//        // Our object is just an integer :-P
//        args.putInt(DemoObjectFragment.ARG_OBJECT, i + 1);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
