package com.PPCtrl.malain.adapter;

import android.app.FragmentManager;
import android.app.Fragment;
import android.support.v13.app.FragmentPagerAdapter;

import com.PPCtrl.malain.powerpointcontrol.ActualFragment;
import com.PPCtrl.malain.powerpointcontrol.DiapositivasFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                //Actual
                return new ActualFragment();
            case 1:
                //Diapositivas
                return new DiapositivasFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
