package com.rodnog.rogermiddenway.tourismapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.DestinationViewHolder> {
    private List<Destination> destinationList;
    private Context context;

    public DestinationAdapter(List<Destination> destinationList, Context context) {
        this.destinationList = destinationList;
        this.context = context;
    }

    @NonNull
    @Override
    public DestinationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View destinationView = LayoutInflater.from(context).inflate(R.layout.destination, parent, false);
        return new DestinationViewHolder(destinationView);
    }

    @Override
    public void onBindViewHolder(@NonNull DestinationViewHolder holder, int position) {
        holder.destinationImageView.setImageResource((destinationList.get(position).getImage()));
    }

    @Override
    public int getItemCount() {
        return destinationList.size();
    }

    public class DestinationViewHolder extends RecyclerView.ViewHolder {
        public ImageView destinationImageView;
        public DestinationViewHolder(@NonNull View destinationView) {
                super(destinationView);
                destinationImageView = destinationView.findViewById(R.id.destinationImageView);
                }
    }
}
