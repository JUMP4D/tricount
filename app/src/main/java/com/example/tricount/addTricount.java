package com.example.tricount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tricount.databinding.ActivityAddtricountBinding;
import com.example.tricount.databinding.ActivityMainBinding;

public class addTricount extends AppCompatActivity {

    private ActivityAddtricountBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddtricountBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = binding.editNom.getText().toString();
                String description = binding.editDesc.getText().toString();
                String date = binding.editDate.getText().toString();
                Tricount tricount = new Tricount(nom, description, date);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("tricount", tricount);
                setResult(1, resultIntent);
                finish();

            }
        });


        }
    }