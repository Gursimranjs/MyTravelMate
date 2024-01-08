package com.example.mytravelmate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.WishlistViewHolder> {

    private Context context;
    private ArrayList<WishlistItem> wishlistItems;

    public WishlistAdapter(Context context, ArrayList<WishlistItem> wishlistItems) {
        this.context = context;

        this.wishlistItems = wishlistItems;

    }


    @NonNull
    @Override
    public WishlistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.wishlist_rv, parent, false);
        return new WishlistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WishlistViewHolder holder, int position) {
        WishlistItem currentItem = wishlistItems.get(position);

        holder.itemName.setText(currentItem.getmTitle());
        holder.itemImage.setImageResource(currentItem.getmImageResource());

        int Position=position;
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wishlistItems.remove(Position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (wishlistItems==null){
            return 0;
        }
        else {
            return wishlistItems.size();
        }
    }


    public static class WishlistViewHolder extends RecyclerView.ViewHolder {
        public ImageView itemImage;
        public TextView itemName;
        public ImageButton deleteButton;

        public WishlistViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.wishlistedimage);
            itemName = itemView.findViewById(R.id.wishlistedname);
            deleteButton = itemView.findViewById(R.id.remove);
        }
    }
}
