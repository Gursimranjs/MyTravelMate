package com.example.mytravelmate;

import android.graphics.PointF;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class PopularFragment extends Fragment {

    ArrayList<Place> places=new ArrayList<>();
    List<Place2> places2 = new ArrayList<>();

    public PopularFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_popular, container, false);

        RecyclerView rv1 = rootView.findViewById(R.id.listexplore1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rv1.setLayoutManager(layoutManager);


        places.add(new Place("Oia, Santorini", R.drawable.oiasantorini));
        places.add(new Place("Amalfi Coast", R.drawable.amalficoast));
        places.add(new Place("Yosemite", R.drawable.yosemite));
        places.add(new Place("Mount Snowdon", R.drawable.mountsnowdon));
        places.add(new Place("Marble Caves", R.drawable.marblecaves));
        places.add(new Place("Meeru Island", R.drawable.mmeeruisland));



        placesadapter1 adapter = new placesadapter1(getContext(), places);
        rv1.setAdapter(adapter);



        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(rv1);



        RecyclerView rv2= rootView.findViewById(R.id.list2);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rv2.setLayoutManager(layoutManager2);
        rv2.setHasFixedSize(false);
        rv2.setNestedScrollingEnabled(false);




        places2.add(new Place2("Kerala", R.drawable.kerala,"Peyto Lake", R.drawable.peytolake));
        places2.add(new Place2("Iguazu Falls", R.drawable.iguazufalls,"Niagara Falls", R.drawable.niagarafalls));
        places2.add(new Place2("Grand Canyon", R.drawable.grandcanyon,"Cinque Terre", R.drawable.cinqueterre));
        places2.add(new Place2("Mount Fuji", R.drawable.mountfuji,"Aurora Borealis", R.drawable.auroraborealis));


        placesadapter2 adapter2 =new placesadapter2(getContext(),places2);
        rv2.setAdapter(adapter2);

        return rootView;



    }


}

