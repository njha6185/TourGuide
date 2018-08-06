package com.example.nitishkumar.tourguide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryFragmentAdapter extends FragmentPagerAdapter{

    private Context context;
/*************************************** Constructor of Fragment Pager Adapter *******************/
    public CategoryFragmentAdapter(FragmentManager fm, Context context1) {
        super(fm);
        context = context1;
    }
/*************************** It helps viewpager to move between fragments *****************/
    @Override
    public Fragment getItem(int position) {
        if (position == 0)
        {
            return new PlacesFragment();
        }
        else if (position == 1)
        {
            return new MallsFragment();
        }
        else if (position == 2)
        {
            return new HotelsFragment();
        }
        else
        {
            return new NightLifeFragment();
        }
    }
/******************************* it returns no of fragments in viewpager *********************/
    @Override
    public int getCount() {
        return 4;
    }
/*************************** it returns the name of fragment for tablayout ************************/
    @Override
    public CharSequence getPageTitle(int position) {
        String [] tabTitle = context.getResources().getStringArray(R.array.tabLayoutTitles);
        return tabTitle[position];
    }
}