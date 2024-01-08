package com.example.mytravelmate;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class placesadapter2 extends RecyclerView.Adapter<placesadapter2.ViewHolder2> {

    List<Place2> places2;
    Context context;

    public placesadapter2(Context context, List<Place2> places2) {
        this.context = context;
        this.places2 = places2;
    }

    @NonNull
    @Override
    public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_rv_2, parent, false);
        ViewHolder2 viewHolder2 = new ViewHolder2(view);
        return viewHolder2;

    }

    @Override
    public void onBindViewHolder(@NonNull placesadapter2.ViewHolder2 holder, int position) {

        holder.name2.setText(places2.get(position).name2);
        holder.mainImage2.setImageResource(places2.get(position).img2);
        holder.name3.setText(places2.get(position).name3);
        holder.mainImage3.setImageResource(places2.get(position).img3);

        int Position=position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DisplayDetails.class);
                intent.putExtra("place_name", places2.get(Position).name2);
                intent.putExtra("place_image", places2.get(Position).img2);

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

                String description=placedescription.get(places2.get(Position).name2);
                String food=famousfood.get(places2.get(Position).name2);;
                String placetostay=stay.get(places2.get(Position).name2);;
                String placeprice=pricing.get(places2.get(Position).name2);;

                if (description == null || food==null || placetostay==null) {
                    description = "Description for " + places2.get(Position).name2;
                    food = "Food items for " + places2.get(Position).name2;
                    placetostay="Best places for " + places2.get(Position).name2;
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
        return places2.size();
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView name2,name3;
        ImageView mainImage2, mainImage3;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            name2 = itemView.findViewById(R.id.placeName2);
            name3 = itemView.findViewById(R.id.placeName3);
            mainImage2 = itemView.findViewById(R.id.mainImage2);
            mainImage3 = itemView.findViewById(R.id.mainImage3);
        }
    }
}
