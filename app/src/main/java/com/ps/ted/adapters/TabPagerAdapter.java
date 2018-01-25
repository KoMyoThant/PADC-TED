package com.ps.ted.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ps.ted.fragments.PlaylistFragment;
import com.ps.ted.fragments.PodcastFragment;
import com.ps.ted.fragments.TalkFragment;

/**
 * Created by pyaesone on 1/24/18.
 */

public class TabPagerAdapter extends FragmentPagerAdapter {

    private final int TAB_NUMBER = 3;
    private final String[] tabTitle = new String[]{"Talks", "Playlists", "Podcasts"};

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TalkFragment();
            case 1:
                return new PlaylistFragment();
            case 2:
                return new PodcastFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_NUMBER;
    }
}
