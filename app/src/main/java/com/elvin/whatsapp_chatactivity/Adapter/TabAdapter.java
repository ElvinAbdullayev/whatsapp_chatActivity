package com.elvin.whatsapp_chatactivity.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.elvin.whatsapp_chatactivity.Fragment.CallsFragment;
import com.elvin.whatsapp_chatactivity.Fragment.CameraFragment;
import com.elvin.whatsapp_chatactivity.Fragment.ChatFragment;
import com.elvin.whatsapp_chatactivity.Fragment.StatusFragment;

public class TabAdapter extends FragmentPagerAdapter {
    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new CameraFragment();
            case 1:
                return new ChatFragment();
            case 2:
                return new StatusFragment();
            case 3:
                return new CallsFragment();

        }

        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }


}
