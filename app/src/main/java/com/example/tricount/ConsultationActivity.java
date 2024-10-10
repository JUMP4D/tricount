package com.example.tricount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tricount.databinding.ActivityConsultationBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ConsultationActivity extends AppCompatActivity implements Serializable {

    private Depense lesDepenses;
    private List<Depense> depensesList;
    private List<Tricount> tricountList;
    private ActivityConsultationBinding binding;
    private DepenseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConsultationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        Tricount tricount = (Tricount) intent.getSerializableExtra("tricount");
        TextView depensesTextView = findViewById(R.id.depensesTextView);
        depensesTextView.setText(tricount.toString());



        depensesList = new ArrayList<>();
        lesDepenses = new Depense("Restaurant", "Dinner", 100, "03/10/2024");
        Depense depense1 = new Depense("Restaurant", "Dinner", 100, "03/10/2024");
        Depense depense2 = new Depense("Restaurant", "Lunch", 50, "03/10/2024");
        Depense depense3 = new Depense("Restaurant", "Breakfast", 30, "03/10/2024");
        depensesList.add(lesDepenses);
        depensesList.add(depense2);



        // Initialiser et configurer le RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerTricount);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DepenseAdapter adapter = new DepenseAdapter(depensesList);
        recyclerView.setAdapter(adapter);








    }
}