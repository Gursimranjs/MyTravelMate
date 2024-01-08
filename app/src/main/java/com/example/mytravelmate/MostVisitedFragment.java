package com.example.mytravelmate;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MostVisitedFragment extends Fragment {
    RecyclerView rv4;
    ArrayList<mostvisited_Places> mostvisitedPlaces=new ArrayList<>();

    public MostVisitedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView2 = inflater.inflate(R.layout.fragment_most_visited, container, false);

        rv4 = rootView2.findViewById(R.id.most_visitedrv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rv4.setLayoutManager(layoutManager);



        mostvisitedPlaces.add(new mostvisited_Places("India", R.color.babypink));
        mostvisitedPlaces.add(new mostvisited_Places("India", R.color.babypink));
        mostvisitedPlaces.add(new mostvisited_Places("India", R.color.babypink));
        mostvisitedPlaces.add(new mostvisited_Places("India", R.color.babypink));
        mostvisitedPlaces.add(new mostvisited_Places("India", R.color.babypink));
        mostvisitedPlaces.add(new mostvisited_Places("India", R.color.babypink));


        most_visitedadapter mvadapter = new most_visitedadapter(getContext(), mostvisitedPlaces);
        rv4.setAdapter(mvadapter);

        return rootView2;

    }


}