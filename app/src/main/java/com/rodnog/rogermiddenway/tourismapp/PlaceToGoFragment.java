package com.rodnog.rogermiddenway.tourismapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class PlaceToGoFragment extends Fragment {

    ImageView imageView;
    TextView titleTextView;
    TextView descriptionTextView;

    public PlaceToGoFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PlaceToGoFragment newInstance(int image, String title, String description) {
        PlaceToGoFragment fragment = new PlaceToGoFragment();
        Bundle args = new Bundle();
        args.putInt("image", image);
        args.putString("title", title);
        args.putString("description", description);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_place_to_go, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            imageView = getView().findViewById(R.id.activePtgImageView);
            titleTextView = getView().findViewById(R.id.activePtgTitleTextView);
            descriptionTextView = getView().findViewById(R.id.activePtgDescriptionTextView);
            imageView.setImageResource(getArguments().getInt("image"));
            titleTextView.setText( getArguments().getString("title"));
            descriptionTextView.setText(getArguments().getString("description"));

        }
    }
}