package com.example.tricount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DepenseAdapter extends RecyclerView.Adapter<DepenseAdapter.DepenseViewHolder> {

    private List<Depense> depenseList;
    private Context context;

    public DepenseAdapter(List<Depense> depenseList, Context context) {
        this.depenseList = depenseList;
        this.context = context;
    }

    @NonNull
    @Override
    public DepenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.depense_item, parent, false);
        return new DepenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DepenseViewHolder holder, int position) {
        Depense depense = depenseList.get(position);
        holder.titre.setText(depense.getTitre());
        holder.description.setText(depense.getDescription());
        holder.montant.setText(String.valueOf(depense.StringMonant()));
        holder.date.setText(depense.getDate());
    }

    @Override
    public int getItemCount() {
        return depenseList.size();
    }

    public static class DepenseViewHolder extends RecyclerView.ViewHolder {
        TextView titre, description, date, montant;

        public DepenseViewHolder(@NonNull View itemView) {
            super(itemView);
            titre = itemView.findViewById(R.id.titre);
            description = itemView.findViewById(R.id.description);
            montant = itemView.findViewById(R.id.montant);
            date = itemView.findViewById(R.id.date);
        }
    }
}