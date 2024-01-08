package com.example.mytravelmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class Discover extends AppCompatActivity {

    TabLayout tablayout;
    ViewPager mainpage;

    ImageView wishlist, home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);

        tablayout=findViewById(R.id.tablayout);
        mainpage= findViewById(R.id.viewpager);

        


        viewpageradapter1 adapter= new viewpageradapter1(getSupportFragmentManager());
        mainpage.setAdapter(adapter);

        tablayout.setupWithViewPager(mainpage);

        wishlist= findViewById(R.id.wishlist);

        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Discover.this,WishlistActivity.class);
                startActivity(intent);
            }
        });

        home=findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Discover.this,Discover.class);
                startActivity(intent);
            }
        });

    }
}
