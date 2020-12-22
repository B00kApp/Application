package com.mahdirahmani8.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.duolingo.open.rtlviewpager.RtlViewPager;
import com.google.android.material.tabs.TabLayout;
import com.mahdirahmani8.myapplication.Adopter.HomeAdopter;
import com.mahdirahmani8.myapplication.DataBase.DataBase;

public class HomeFragment extends Fragment {

    View  view ;
    TabLayout tabLayout;
    RtlViewPager viewpager;
    HomeAdopter adopter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.home_fragment,container,false);
        setupViews();
        return view;
    }

    //=======================================================================

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private void setupViews(){
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout_id);
        viewpager = (RtlViewPager) view.findViewById(R.id.view_pager_id);

        getLan();


    }

    private void getLan() {
        DataBase db = new DataBase(getContext());
        String str =  db.lanValue();


        if ( str != null  && str.hashCode() == 3259) {              // fa
            adopter = new HomeAdopter(getChildFragmentManager());
            adopter.addFragment(new IranFragment(),"کتاب");
            adopter.addFragment(new ForiegnFragment(),"کتاب صوتی");
            viewpager.setAdapter(adopter);
            tabLayout.setupWithViewPager(viewpager);

        } else if (str != null  && str.hashCode() == 3246) {        // sp
            adopter = new HomeAdopter(getChildFragmentManager());
            adopter.addFragment(new IranFragment(),"Libro");
            adopter.addFragment(new ForiegnFragment(),"Audio libro");
            viewpager.setAdapter(adopter);
            tabLayout.setupWithViewPager(viewpager);

        } else if (str != null  && str.hashCode() == 3307) {        // gr
            adopter = new HomeAdopter(getChildFragmentManager());
            adopter.addFragment(new IranFragment(),"Buch");
            adopter.addFragment(new ForiegnFragment(),"Hörbuch");
            viewpager.setAdapter(adopter);
            tabLayout.setupWithViewPager(viewpager);

        } else if (str != null  && str.hashCode() == 3121) {        // ar
            adopter = new HomeAdopter(getChildFragmentManager());
            adopter.addFragment(new IranFragment(),"کتاب");
            adopter.addFragment(new ForiegnFragment(),"کتاب صوتی");
            viewpager.setAdapter(adopter);
            tabLayout.setupWithViewPager(viewpager);

        } else {                                                    // en
            adopter = new HomeAdopter(getChildFragmentManager());
            adopter.addFragment(new IranFragment(),"Books");
            adopter.addFragment(new ForiegnFragment(),"Audio Books");
            viewpager.setAdapter(adopter);
            tabLayout.setupWithViewPager(viewpager);
        }

    }
}

