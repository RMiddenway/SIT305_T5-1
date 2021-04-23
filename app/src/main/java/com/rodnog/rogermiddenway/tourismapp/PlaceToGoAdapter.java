package com.rodnog.rogermiddenway.tourismapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlaceToGoAdapter extends RecyclerView.Adapter<PlaceToGoAdapter.PlaceToGoViewHolder>{
    private List<PlaceToGo> placeToGoList;
    private Context context;
    private OnRowClickListener listener;

    public PlaceToGoAdapter(List<PlaceToGo> placeToGoList, Context context, OnRowClickListener listener ) {
        this.placeToGoList = placeToGoList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PlaceToGoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View placeToGoView = LayoutInflater.from(context).inflate(R.layout.place_to_go, parent, false);
        return new PlaceToGoViewHolder(placeToGoView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceToGoAdapter.PlaceToGoViewHolder holder, int position) {
        holder.placeToGoImageView.setImageResource((placeToGoList.get(position).getImage()));
        holder.placeToGoTitleTextView.setText(placeToGoList.get(position).getTitle());
        holder.placeToGoDescriptionTextView.setText(placeToGoList.get(position).getShortDescription());
    }


    @Override
    public int getItemCount() {
        return placeToGoList.size();
    }

    public class PlaceToGoViewHolder extends RecyclerView.ViewHolder{
        public ImageView placeToGoImageView;
        public TextView placeToGoTitleTextView;
        public TextView placeToGoDescriptionTextView;
        public OnRowClickListener onRowClickListener;

        public PlaceToGoViewHolder(@NonNull View destinationView, OnRowClickListener onRowClickListener) {
            super(destinationView);
            placeToGoImageView = destinationView.findViewById(R.id.ptgImageView);
            placeToGoTitleTextView = destinationView.findViewById(R.id.ptgTitleTextView);
            placeToGoDescriptionTextView = destinationView.findViewById(R.id.ptgDescriptionTextView);

            destinationView.setOnClickListener(v -> onRowClickListener.onItemClick(this.getAdapterPosition()));
        }


    }
    public interface OnRowClickListener {
        void onItemClick(int position);
    }
}
