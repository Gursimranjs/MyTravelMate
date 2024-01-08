package com.example.mytravelmate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayDetails extends AppCompatActivity {

    TextView placename, description, fooditems, stayoptions, price;
    ImageView placeimage;
    Button booknow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);

        placename=findViewById(R.id.detailsname);
        description=findViewById(R.id.description);
        fooditems=findViewById(R.id.fooditems);
        stayoptions=findViewById(R.id.placestostay);
        price=findViewById(R.id.pricestay);
        placeimage=findViewById(R.id.detailsimage);
        booknow=findViewById(R.id.booknow);

        String placeName = getIntent().getStringExtra("place_name");
        int placeImageResourceId = getIntent().getIntExtra("place_image", 0);
        String placeDescription = getIntent().getStringExtra("place_description");
        String placefood= getIntent().getStringExtra("food_Items");
        String placestostay= getIntent().getStringExtra("Stay_options");
        String priceperson= getIntent().getStringExtra("Pricing_range");

        placename.setText(placeName);
        placeimage.setImageResource(placeImageResourceId);
        description.setText(placeDescription);
        fooditems.setText(placefood);
        stayoptions.setText(placestostay);
        price.setText(priceperson);


    }
}