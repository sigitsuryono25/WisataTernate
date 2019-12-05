package com.surelabs.wisataternate.ui.galeri;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.surelabs.wisataternate.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterGaleri extends RecyclerView.Adapter<AdapterGaleri.ViewHolder> {

    private List<String> imageList;
    private Context _context;

    AdapterGaleri(ArrayList<String> imageList) {
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this._context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter_galeri, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("IMAGE", "onBindViewHolder: " + imageList.get(position));
        Glide.with(_context)
                .load(imageList.get(position))
                .into(holder.imageViewGaleri);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewGaleri;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewGaleri = itemView.findViewById(R.id.imageViewGaleri);
        }
    }
}