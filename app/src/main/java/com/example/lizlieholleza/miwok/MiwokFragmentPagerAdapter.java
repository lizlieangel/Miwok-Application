package com.example.lizlieholleza.miwok;

import android.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

public class MiwokFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    private String tabTiles[] = new String[] {"Number", "Color","Family","Phrases"};
    private Context context;

    public MiwokFragmentPagerAdapter(android.support.v4.app.FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public PageFragment getItem(int position) {
        return PageFragment.newInstance(position  + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTiles[position];
    }

//    @Override
//    public Fragment getItem(int position) {
//        switch (position) {
//            case 0:
//                return new NumbersFragment();
//            case 1:
//                return new ColorsFragment();
//            case 2:
//                return new FamilyFragment();
//            case 3:
//                return new PhrasesFragment();
//            default:
//                return null;
//        }
//    }

}

