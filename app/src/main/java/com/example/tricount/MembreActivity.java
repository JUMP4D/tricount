package com.example.tricount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.tricount.databinding.ActivityMembreBinding;

import java.util.ArrayList;
import java.util.List;

public class MembreActivity extends AppCompatActivity {

    private List<User> membreList;
    private MembreAdapter adapter;

    private ActivityMembreBinding binding;
    private ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new
            ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == 1){
                        Intent resultIntent = result.getData();
                        User membre = (User)resultIntent.getSerializableExtra("membre");
                        membreList.add(membre);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMembreBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        membreList = new ArrayList<>();
        adapter = new MembreAdapter(membreList, this);
        binding.recyclerMembre.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerMembre.setAdapter(adapter);

        Intent Membreintent = getIntent();
        Tricount tricount = (Tricount) Membreintent.getSerializableExtra("tricount");

        binding.buttonAddMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AddMemberintent = new Intent(getApplicationContext(), AddMemberActivity.class);
                activityResultLauncher.launch(AddMemberintent);
            }
        });
    }
}