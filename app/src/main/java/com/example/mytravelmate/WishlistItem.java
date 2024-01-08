package com.example.mytravelmate;

import android.os.Parcel;
import android.os.Parcelable;

public class WishlistItem implements Parcelable {
    private String mTitle;
    private int mImageResource;

    public WishlistItem(String name, int image) {
        this.mTitle = name;
        this.mImageResource = image;
    }

    protected WishlistItem(Parcel in) {
        mTitle = in.readString();
        mImageResource = in.readInt();
    }

    public static final Creator<WishlistItem> CREATOR = new Creator<WishlistItem>() {
        @Override
        public WishlistItem createFromParcel(Parcel in) {
            return new WishlistItem(in);
        }

        @Override
        public WishlistItem[] newArray(int size) {
            return new WishlistItem[size];
        }
    };

    public String getmTitle() {
        return mTitle;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeInt(mImageResource);
    }
}
