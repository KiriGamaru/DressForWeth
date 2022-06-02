package com.example.dressforweth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Clothes> {
    private Context mContext;
    private int mResource;


    public MyAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Clothes> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);

        ImageView imageView = convertView.findViewById(R.id.imgClothes);

        TextView tvName = convertView.findViewById(R.id.tvName);

        TextView tvDesc = convertView.findViewById(R.id.tvDesc);

        imageView.setImageResource(getItem(position).getImage());

        tvName.setText(getItem(position).getName());

        tvDesc.setText(getItem(position).getDescription());

        return convertView;
    }
}

