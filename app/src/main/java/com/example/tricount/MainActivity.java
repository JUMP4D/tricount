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
import com.example.tricount.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private List<Tricount> tricountList;
    private TricountAdapter adapter;
    private ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new
            ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == 1){
                        Intent resultIntent = result.getData();
                        Tricount tricount = (Tricount)resultIntent.getSerializableExtra("tricount");
                        tricountList.add(tricount);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        tricountList = new ArrayList<>();
        adapter = new TricountAdapter(tricountList, this);
        binding.recyclerTricount.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerTricount.setAdapter(adapter);

        binding.floatingadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getApplicationContext(), addTricount.class);
                activityResultLauncher.launch(myIntent);
            }
        });

        binding.recyclerTricount.addOnItemTouchListener(new RecyclerTouchListener(this, binding.recyclerTricount, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Tricount tricount = tricountList.get(position);
                Intent detailintent = new Intent(MainActivity.this, TricountDetailsActivity.class);
                detailintent.putExtra("tricount", tricount);
                startActivity(detailintent);
            }
        }));
    }
}