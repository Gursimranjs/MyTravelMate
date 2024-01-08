package com.example.mytravelmate;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;


public class featuredfragmentAdapter extends RecyclerView.Adapter<featuredfragmentAdapter.viewholder3>{



    ArrayList<featuredplaces> places;
    ArrayList<WishlistItem> wishlistItems = new ArrayList<>();
    Context context;
    private WishlistActivity wishlistActivity;
    private ImageView wishlistimg;


    public featuredfragmentAdapter(Context context, ArrayList<featuredplaces> places) {
        this.context = context;
        this.places=places;
    }
    public featuredfragmentAdapter(Context context, ArrayList<featuredplaces> featuredPlaces, View rootView) {
        this.context = context;
        places = featuredPlaces;
    }

    @NonNull
    @Override
    public featuredfragmentAdapter.viewholder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.featured_rv, parent, false);
        featuredfragmentAdapter.viewholder3 viewholder=new featuredfragmentAdapter.viewholder3(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder3 holder, final int position) {
        holder.MainImage2.setImageResource(places.get(position).featuredimage);
        holder.Name2.setText(places.get(position).featuredname);
        int Position=position;
        if (holder.MainImage2 != null) {
            holder.wishlistimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String name = places.get(Position).featuredname;
                    int image = places.get(Position).featuredimage;



                    wishlistItems.add(new WishlistItem(name, image));

                    Intent intent=new Intent(view.getContext(), WishlistActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("image", image);
                    WishlistActivity.setData(intent.getExtras());

                    Toast.makeText(context, "Item added to wishlist", Toast.LENGTH_SHORT).show();
                }
            });
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DisplayDetails.class);
                intent.putExtra("place_name", places.get(Position).featuredname);
                intent.putExtra("place_image", places.get(Position).featuredimage);

                HashMap<String, String> placedescription=new HashMap<>();
                placedescription.put("Mount Fuji","One of the most beautiful places in the worls");
                placedescription.put("Italy","One of the most beautiful places in the worls");
                placedescription.put("Northern Mountains","One of the most beautiful places in the worls");

                HashMap<String, String> famousfood=new HashMap<>();
                famousfood.put("Mount Fuji"," soup, noodles");
                famousfood.put("Italy"," soup, noodles");
                famousfood.put("Northern Mountains"," soup, noodles");

                HashMap<String, String> stay=new HashMap<>();
                stay.put("Mount Fuji"," marriot");
                stay.put("Italy"," grand lv");
                stay.put("Northern Mountains"," marriot");

                HashMap<String, String> pricing=new HashMap<>();
                pricing.put("Mount Fuji","400$");
                pricing.put("Italy","1600$");
                pricing.put("Northern Mountains","1000$");

                String description=placedescription.get(places.get(Position).featuredname);
                String food=famousfood.get(places.get(Position).featuredname);;
                String placetostay=stay.get(places.get(Position).featuredname);;
                String placeprice=pricing.get(places.get(Position).featuredname);;

                if (description == null || food==null || placetostay==null) {
                    description = "Description for " + places.get(Position).featuredname;
                    food = "Food items for " + places.get(Position).featuredname;
                    placetostay="Best places for " + places.get(Position).featuredname;
                    placeprice="500$";
                }
                intent.putExtra("place_description", description);
                intent.putExtra("food_Items", food);
                intent.putExtra("Stay_options", placetostay);
                intent.putExtra("Pricing_range", placeprice);

                context.startActivity(intent);

            }
        });
    }





    @Override
    public int getItemCount() {
        return places.size();
    }



    public class viewholder3 extends RecyclerView.ViewHolder{

        TextView Name2;
        ImageView MainImage2,wishlistimg;

        View cardview;

        public viewholder3(@NonNull View itemView) {
            super(itemView);

            Name2= itemView.findViewById(R.id.featuredName);
            MainImage2=itemView.findViewById(R.id.featuredImage);
            wishlistimg=itemView.findViewById(R.id.wishlistlogofeatured);
            cardview=itemView.findViewById(R.id.featuredlayout);


        }


    }
}
