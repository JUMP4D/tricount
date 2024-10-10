package com.example.tricount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.tricount.databinding.ActivityAddDepenseBinding;


public class addDepense extends AppCompatActivity {

    private ActivityAddDepenseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddDepenseBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent Depenseintent = getIntent();
        Tricount tricount = (Tricount) Depenseintent.getSerializableExtra("tricount");

        binding.buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = binding.editNom.getText().toString();
                String description = binding.editDesc.getText().toString();
                String date = binding.editDate.getText().toString();
                double montant = Double.parseDouble(binding.editMontant.getText().toString());
                Depense depense = new Depense(nom, description, montant, date);
                Toast.makeText(addDepense.this, tricount.toString(), Toast.LENGTH_SHORT).show();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("depense", depense);
                setResult(1, resultIntent);
                finish();
            }
        });
    }

}