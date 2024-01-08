package com.example.mytravelmate;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class FeaturedFragment extends Fragment {
RecyclerView rv3;


ArrayList<featuredplaces> FeaturedPlaces=new ArrayList<>();

    public FeaturedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView2 = inflater.inflate(R.layout.fragment_featured, container, false);

        rv3 = rootView2.findViewById(R.id.featuredrv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rv3.setLayoutManager(layoutManager);



        FeaturedPlaces.add(new featuredplaces("Ginderwals", R.drawable.ginderwald));
        FeaturedPlaces.add(new featuredplaces("Genoa", R.drawable.genoa));
        FeaturedPlaces.add(new featuredplaces("Caucasus Mountains", R.drawable.caucasusmountains));
        FeaturedPlaces.add(new featuredplaces("Bern", R.drawable.bern));
        FeaturedPlaces.add(new featuredplaces("Capri", R.drawable.capri));
        FeaturedPlaces.add(new featuredplaces("Meteora", R.drawable.meteora));

        featuredfragmentAdapter featuredadapter = new featuredfragmentAdapter(getContext(), FeaturedPlaces, rootView2);
        rv3.setAdapter(featuredadapter);



        return rootView2;

    }

}