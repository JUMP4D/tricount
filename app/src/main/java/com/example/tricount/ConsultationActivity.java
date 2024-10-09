package com.example.tricount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.tricount.databinding.ActivityConsultationBinding;

import java.io.Serializable;
import java.util.List;

public class ConsultationActivity extends AppCompatActivity implements Serializable {

    private Depense lesDepenses;
    private List<Tricount> tricountList;
    private ActivityConsultationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConsultationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Depense depense1 = new Depense("Restaurant", "Dinner", 100, "03/10/2024");
        Depense depense2 = new Depense("Restaurant", "Lunch", 50, "03/10/2024");
        Depense depense3 = new Depense("Restaurant", "Breakfast", 30, "03/10/2024");
        Depense.add(depense1);
        Depense.add(depense2);


    }
}