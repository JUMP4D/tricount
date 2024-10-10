package com.example.tricount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.tricount.databinding.ActivityTricountDetailBinding;

import java.util.ArrayList;
import java.util.List;

public class TricountDetailsActivity extends AppCompatActivity {

    private Tricount tricount;
    private ActivityTricountDetailBinding binding;
    private List<Depense> depenseList;
    private DepenseAdapter adapter;
    private ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new
            ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == 1){
                        Intent resultIntent = result.getData();
                        Depense depense = (Depense)resultIntent.getSerializableExtra("depense");
                        depenseList.add(depense);
                        updateTotalDepense();
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTricountDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent tricountIntent = getIntent();
        Tricount tricount = (Tricount) tricountIntent.getSerializableExtra("tricount");

        binding.titre.setText(tricount.getTitre());
        binding.total.setText(tricount.getTotal_depense());

        depenseList = new ArrayList<>();
        adapter = new DepenseAdapter(depenseList, this);
        binding.recyclerDepense.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerDepense.setAdapter(adapter);

        binding.buttonAddDepense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Depenseintent = new Intent(getApplicationContext(), addDepense.class);
                Depenseintent.putExtra("tricount", tricount);
                activityResultLauncher.launch(Depenseintent);
            }
        });

        binding.buttonMembre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Membreintent = new Intent(getApplicationContext(), MembreActivity.class);
                Membreintent.putExtra("tricount", tricount);
                startActivity(Membreintent);
            }
        });
    }
    private void updateTotalDepense() {
        double total = 0;
        for (Depense depense : depenseList) {
            total += depense.getMontant();
        }
        binding.total.setText(String.valueOf(total+ "€"));
    }
}
