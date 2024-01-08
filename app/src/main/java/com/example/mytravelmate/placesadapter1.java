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

public class placesadapter1 extends RecyclerView.Adapter<placesadapter1.viewholder> {

    ArrayList<Place> places;

    Context context;

    public placesadapter1(Context context, ArrayList<Place> places) {
        this.context = context;
        this.places=places;
    }

    @NonNull
    @Override
    public placesadapter1.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.popular_rv_1, parent, false);
        viewholder viewholder=new viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull placesadapter1.viewholder holder, int position) {
        holder.MainImage.setImageResource(places.get(position).img);
        holder.Name.setText(places.get(position).name);

        int Position=position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DisplayDetails.class);
                intent.putExtra("place_name", places.get(Position).name);
                intent.putExtra("place_image", places.get(Position).img);

                HashMap<String, String> placedescription=new HashMap<>();
                placedescription.put("Oia, Santorini","Oia is a charming village located on the northwest coast of Santorini, Greece, most renowned for its stunning sunsets, white-washed buildings, and blue-domed churches. It's best to visit from May to September when the weather is warm and sunny. The village offers a variety of accommodations, from luxurious villas with stunning views of the Aegean Sea to more affordable hotels. The estimated cost per person for a week in Oia ranges from $800 to $1500, depending on your travel style and preferences.");
                placedescription.put("Meeru Island","Meeru Island is a breathtaking island in the Maldives, known for its pristine beaches, turquoise waters, and coral reefs. The best time to visit is from November to April, when the weather is dry and sunny. ");
                placedescription.put("Yosemite","Yosemite National Park is a natural wonder located in California, United States. The park is famous for its stunning granite cliffs, waterfalls, and scenic vistas. The best time to visit is from May to October, when the weather is pleasant and ideal for outdoor activities. The park has many must-visit attractions, including Half Dome, Yosemite Falls, El Capitan, and Mariposa Grove.");
                placedescription.put("Amalfi Coast","The Amalfi Coast is a beautiful stretch of coastline located in southern Italy. This region is famous for its scenic beauty, picturesque villages, and stunning beaches. The best time to visit is from April to June or September to October, when the weather is mild and the crowds are fewer. The must-visit attractions in the region include Positano, Amalfi, Ravello, and the nearby island of Capri.");
                placedescription.put("Mount Snowdon","Mount Snowdon is the highest mountain in Wales, located in Snowdonia National Park. This region is famous for its stunning mountain scenery, hiking trails, and outdoor activities. The best time to visit is from May to September, when the weather is mild and the days are longer. The must-visit attractions in the region include the Snowdon Mountain Railway, Llanberis Path, and Pyg Track.");
                placedescription.put("Marble Caves","The Marble Caves are located on the General Carrera Lake in Chile and are famous for their stunning marble formations and unique natural beauty. The best time to visit is from October to March, when the weather is pleasant and the lake is calm. The must-visit attractions in the region include the Marble Chapel, Marble Cathedral, and Marble Cave. ");

                HashMap<String, String> famousfood=new HashMap<>();
                famousfood.put("Oia, Santorini","Fava, Tomatokeftedes, Gyros");
                famousfood.put("Meeru Island","Maldivian fish curry, Masroshi, Garudhiya");
                famousfood.put("Yosemite","huckleberry pie, grilled cheese sandwich, Dutch oven cobbler");
                famousfood.put("Amalfi Coast","limoncello, seafood, Neapolitan pizza");
                famousfood.put("Mount Snowdon","Welsh rarebit, lamb cawl, bara brith");
                famousfood.put("Marble Caves","Chilean seafood, empanadas, pisco sour");

                HashMap<String, String> stay=new HashMap<>();
                stay.put("Oia, Santorini","luxurious villas and affordable hotels");
                stay.put("Meeru Island","water villas, beach villas, and suites");
                stay.put("Yosemite","lodges, cabins, camping grounds, and hotels");
                stay.put("Amalfi Coast","boutique hotels, villas, and apartments");
                stay.put("Mount Snowdon","hotels, hostels, and camping grounds");
                stay.put("Marble Caves","hotels, lodges, and camping grounds");


                HashMap<String, String> pricing=new HashMap<>();
                pricing.put("Oia, Santorini","1400$/");
                pricing.put("Meeru Island","1900$/");
                pricing.put("Yosemite","1000$/");
                pricing.put("Amalfi Coast","1200$/");
                pricing.put("Mount Snowdon","1600$/");
                pricing.put("Marble Caves","1300$/");


                String description=placedescription.get(places.get(Position).name);
                String food=famousfood.get(places.get(Position).name);;
                String placetostay=stay.get(places.get(Position).name);;
                String placeprice=pricing.get(places.get(Position).name);;

                if (description == null || food==null || placetostay==null) {
                    description = "Description for " + places.get(Position).name;
                    food = "Food items for " + places.get(Position).name;
                    placetostay="Best places for " + places.get(Position).name;
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


    public class viewholder extends RecyclerView.ViewHolder{

        TextView Name;
        ImageView MainImage;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            Name= itemView.findViewById(R.id.placeName);
            MainImage=itemView.findViewById(R.id.mainImage);
        }
    }
}
