
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

public class most_visitedadapter extends RecyclerView.Adapter<most_visitedadapter.viewholder5>{

    ArrayList<mostvisited_Places> places;

    Context context;

    public most_visitedadapter(Context context, ArrayList<mostvisited_Places> places) {
        this.context = context;
        this.places=places;
    }

    @NonNull
    @Override
    public viewholder5 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.most_visited_rv, parent, false);
        viewholder5 viewholder=new viewholder5(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder5 holder, int position) {
        holder.MainImage3.setImageResource(places.get(position).mvimg);
        holder.Name3.setText(places.get(position).mvName);
        int Position=position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DisplayDetails.class);
                intent.putExtra("place_name", places.get(Position).mvName);
                intent.putExtra("place_image", places.get(Position).mvimg);

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

                String description=placedescription.get(places.get(Position).mvName);
                String food=famousfood.get(places.get(Position).mvName);;
                String placetostay=stay.get(places.get(Position).mvName);;
                String placeprice=pricing.get(places.get(Position).mvName);;

                if (description == null || food==null || placetostay==null) {
                    description = "Description for " + places.get(Position).mvName;
                    food = "Food items for " + places.get(Position).mvName;
                    placetostay="Best places for " + places.get(Position).mvName;
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


    public class viewholder5 extends RecyclerView.ViewHolder{

        TextView Name3;
        ImageView MainImage3;
        public viewholder5(@NonNull View itemView) {
            super(itemView);

            Name3= itemView.findViewById(R.id.mvName);
            MainImage3=itemView.findViewById(R.id.mvImage);
        }
    }
}
