//package com.example.mytravelmate;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//
//public class SharedPref {
//
//    private static final String SHARED_PREF_NAME = "my_shared_pref";
//    private static final String KEY_WISHLIST_ITEMS = "wishlist_items";
//
//    private static SharedPreferences getSharedPreferences(Context context) {
//        return context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
//    }
//
//    public static ArrayList<WishlistItem> getWishlistItems(Context context) {
//        SharedPreferences sharedPreferences = getSharedPreferences(context);
//        String json = sharedPreferences.getString(KEY_WISHLIST_ITEMS, "");
//        Type type = new TypeToken<ArrayList<WishlistItem>>() {
//        }.getType();
//        return new Gson().fromJson(json, type);
//    }
//
//    public static void addWishlistItem(Context context, WishlistItem item) {
//        ArrayList<WishlistItem> wishlistItems = getWishlistItems(context);
//        wishlistItems.add(item);
//        saveWishlistItems(context, wishlistItems);
//    }
//
//    public static void removeWishlistItem(Context context, int position) {
//        ArrayList<WishlistItem> wishlistItems = getWishlistItems(context);
//        wishlistItems.remove(position);
//        saveWishlistItems(context, wishlistItems);
//    }
//
//    private static void saveWishlistItems(Context context, ArrayList<WishlistItem> wishlistItems) {
//        String json = new Gson().toJson(wishlistItems);
//        SharedPreferences sharedPreferences = getSharedPreferences(context);
//        sharedPreferences.edit().putString(KEY_WISHLIST_ITEMS, json).apply();
//    }
//
//}
