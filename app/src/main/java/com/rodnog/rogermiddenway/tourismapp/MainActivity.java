package com.rodnog.rogermiddenway.tourismapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PlaceToGoAdapter.OnRowClickListener{

    RecyclerView destinationRecyclerView;
    DestinationAdapter destinationAdapter;
    List<Destination> destinationList = new ArrayList<>();

    Integer[] destinationImageList = {R.drawable.newyork, R.drawable.paris, R.drawable.sydney, R.drawable.hanoi};

    RecyclerView placeToGoRecyclerView;
    PlaceToGoAdapter placeToGoAdapter;
    List<PlaceToGo> placeToGoList = new ArrayList<>();

    Integer[] placeToGoImageList = {R.drawable.belleville, R.drawable.lemarais, R.drawable.lesinvalides, R.drawable.vanves, R.drawable.petiteceinture};
    String[] placeToGoTitleList = {"Belleville", "Le Marais", "Les Invalides", "Porte de Vanves", "La Petite Ceinture"};
    String[] placeToGoDescriptionList = {
            "Belleville is an edgy neighborhood hosting a monthly street food market that sprawls along Boulevard de Belleville with outdoor tables. Part of the area is a Chinese quarter, with grocery stores and no-frills restaurants, as well as a new wave of contemporary galleries and street art.",
            "The fashionable Marais district in the 4th arrondissement, also known as SoMa (South Marais), is filled with hip boutiques, galleries, and gay bars. Once the city's Jewish quarter, the area still hosts numerous kosher restaurants. The grassy Place des Vosges is home to elegant arcades and the Musée Victor Hugo, where the writer lived. Streets around Saint-Paul metro lead to the Maison Européenne de la Photographie.",
            "Les Invalides, formally the Hôtel national des Invalides, or also as Hôtel des Invalides, is a complex of buildings in the 7th arrondissement of Paris, France, containing museums and monuments, all relating to the military history of France, as well as a hospital and a retirement home for war veterans, the buildings original purpose.",
            "Porte de Vanves is located in the 14th arrondissement of Paris, on its southern outskirts, and is home to one of the largest flea markets in the Ile de France region.",
            "Paris' former Chemin de fer de Petite Ceinture, also colloquially known as La Petite Ceinture, was a circular railway built as a means to supply the city's fortification walls, and as a means of transporting merchandise and passengers between Paris' major rail-company stations."
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        destinationRecyclerView = findViewById(R.id.destinationsRecyclerView);
        destinationAdapter = new DestinationAdapter(destinationList, MainActivity.this);
        destinationRecyclerView.setAdapter(destinationAdapter);
        RecyclerView.LayoutManager destinationLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        destinationRecyclerView.setLayoutManager(destinationLayoutManager);

        placeToGoRecyclerView = findViewById(R.id.ptgRecyclerView);
        placeToGoAdapter = new PlaceToGoAdapter(placeToGoList, MainActivity.this, this);
        placeToGoRecyclerView.setAdapter(placeToGoAdapter);
        RecyclerView.LayoutManager placeToGoLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        placeToGoRecyclerView.setLayoutManager(placeToGoLayoutManager);

        for(int i = 0; i < destinationImageList.length; i++) {
            Destination destination = new Destination(i, destinationImageList[i]);
            destinationList.add(destination);
        }


        for(int i = 0; i < placeToGoImageList.length; i++) {
            PlaceToGo placeToGo = new PlaceToGo(i, placeToGoImageList[i], placeToGoTitleList[i], placeToGoDescriptionList[i]);
            placeToGoList.add(placeToGo);

        }
    }

    @Override
    public void onItemClick(int position) {
        Fragment fragment = PlaceToGoFragment.newInstance(placeToGoImageList[position], placeToGoTitleList[position], placeToGoDescriptionList[position]);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.blankFragment, fragment)
                .addToBackStack("0")
                .commit();
    }
}