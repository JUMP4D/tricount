package com.example.tricount;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tricount.databinding.ActivityMainBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private List<Tricount> tricountList;
    private TricountAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        tricountList = new ArrayList<>();
        Tricount tricount1 = new Tricount("Vacances", "Vacance", "03/10/2024");
        Tricount tricount2 = new Tricount("Vacances", "Vacance", "03/10/2024");
        tricountList.add(tricount1);
        tricountList.add(tricount2);

        // Initialiser et configurer le RecyclerView
        adapter = new TricountAdapter(tricountList);
        binding.recyclerTricount.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerTricount.setAdapter(adapter);

        binding.floatingadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), addTricount.class);
                startActivity(myIntent);
            }
        });

        binding.recyclerTricount.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), binding.recyclerTricount, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent myIntent = new Intent(getApplicationContext(), ConsultationActivity.class);
                myIntent.putExtra("tricount", (Serializable) tricountList.get(position));
                startActivity(myIntent);
            }



        }));
    }

}