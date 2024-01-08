package com.example.mytravelmate;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class viewpageradapter1 extends FragmentPagerAdapter {

    public viewpageradapter1(@NonNull FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PopularFragment();
            case 1:
                return new FeaturedFragment();
            case 2:
                return new MostVisitedFragment();
            case 3:
                return new EuropeFragment();
            case 4:
                return new AsiaFragment();
            case 5:
                return new AntarticaFragment();
            case 6:
                return new AfricaFragment();
            case 7:
                return new AustraliaFragment();
            case 8:
                return new AmericaFragment();

            default:
                throw new IllegalArgumentException("Invalid position: " + position);
        }
    }

    @Override
    public int getCount() {
        return 9;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Popular";
            case 1:
                return "Featured";
            case 2:
                return "Most Visited";
            case 3:
                return "Europe";
            case 4:
                return "Asia";
            case 5:
                return "Antartica";
            case 6:
                return "Africa";
            case 7:
                return "Australia";
            case 8:
                return "America";
            default:
                throw new IllegalArgumentException("Invalid position: " + position);
        }
    }
}
