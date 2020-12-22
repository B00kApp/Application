package com.mahdirahmani8.myapplication.Adopter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeAdopter extends FragmentPagerAdapter {

    private List<String> lstTitele = new ArrayList<>();
    private List<Fragment> lstFragment = new ArrayList<>();
    public HomeAdopter (FragmentManager fm){
        super(fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return lstFragment.get(position);
    }

    @Override
    public int getCount() {
        return lstTitele.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lstTitele.get(position);
    }
    public void addFragment( Fragment fragment ,String title){
        lstFragment.add(fragment);
        lstTitele.add(title);

    }
}
