package com.example.mytravelmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;




public class WishlistActivity extends AppCompatActivity {
    private ArrayList<WishlistItem> wishlistItems;
    private RecyclerView mRecyclerView;

    public static Bundle data;
    private WishlistAdapter mAdapter;
    private SharedPreferences mPrefs;

    ImageView home;
    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_WISHLIST_ITEMS = "wishlistItems";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        home=findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(WishlistActivity.this,Discover.class);
                startActivity(intent);
                finish();
            }
        });

        mPrefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        wishlistItems = getWishlistItemsFromPrefs();

        // Retrieve values from intent
        String name = data.getString("name");
        int image = data.getInt("image", 0);

        // Add new item to wishlist
        wishlistItems.add(new WishlistItem(name, image));
        saveWishlistItemsToPrefs(wishlistItems);

        // Set up RecyclerView and adapter
        if (wishlistItems!=null){
            setupRecyclerView();
        }

    }

    private void setupRecyclerView() {
        mRecyclerView = findViewById(R.id.wishlistRecyclerview);
        mAdapter = new WishlistAdapter(this, wishlistItems);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void saveWishlistItemsToPrefs(ArrayList<WishlistItem> items) {
        SharedPreferences.Editor editor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(items);
        editor.putString(KEY_WISHLIST_ITEMS, json);
        editor.apply();
    }

    private ArrayList<WishlistItem> getWishlistItemsFromPrefs() {
        Gson gson = new Gson();
        String json = mPrefs.getString(KEY_WISHLIST_ITEMS, "");
        Type type = new TypeToken<ArrayList<WishlistItem>>() {}.getType();
        ArrayList<WishlistItem> items = gson.fromJson(json, type);
        if (items == null) {
            items = new ArrayList<>();
        }
        return items;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveWishlistItemsToPrefs(wishlistItems);
    }
    public static void setData(Bundle extras) {
        data = extras;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}






