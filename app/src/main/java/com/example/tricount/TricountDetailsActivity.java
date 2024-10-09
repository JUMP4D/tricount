package com.example.tricount;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.tricount.databinding.ActivityTricountDetailBinding;

public class TricountDetailsActivity extends AppCompatActivity {

    private ActivityTricountDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTricountDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Tricount tricount = (Tricount) getIntent().getSerializableExtra("tricount");

        if (tricount != null) {
            binding.titre.setText(tricount.getTitre());
            binding.description.setText(tricount.getDescription());
            binding.date.setText(tricount.getDate());
            // Retirer l'affichage de total_depense
        } else {
            Toast.makeText(this, "Erreur : Tricount non trouvé", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
