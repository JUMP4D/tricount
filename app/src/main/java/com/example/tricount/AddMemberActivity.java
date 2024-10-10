package com.example.tricount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.tricount.databinding.ActivityAddMemberBinding;

public class AddMemberActivity extends AppCompatActivity {
private ActivityAddMemberBinding binding;
private User membre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddMemberBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent AddMemberintent = getIntent();
        Tricount tricount = (Tricount) AddMemberintent.getSerializableExtra("tricount");

        binding.buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = binding.editNom.getText().toString();
                String prenom = binding.editPrenom.getText().toString();
                membre = new User(nom, prenom);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("membre", membre);
                setResult(1, resultIntent);
                finish();

            }
        });

    }
}