package com.example.tricount;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TricountAdapter extends RecyclerView.Adapter<TricountAdapter.TricountViewHolder> {

    private List<Tricount> tricountList;

    // Constructeur de l'adaptateur
    public TricountAdapter(List<Tricount> tricountList) {
        this.tricountList = tricountList;
    }

    // Crée et retourne un ViewHolder pour un élément de la liste
    @NonNull
    @Override
    public TricountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tricount_item, parent, false);
        return new TricountViewHolder(view);
    }

    // Lie les données d'un élément de la liste à un ViewHolder
    @Override
    public void onBindViewHolder(@NonNull TricountViewHolder holder, int position) {
        Tricount tricount = tricountList.get(position);
        holder.titre.setText(tricount.getTitre());
        holder.description.setText(tricount.getDescription());
        holder.date.setText(tricount.getDate());
    }

    // Retourne le nombre d'éléments dans la liste
    @Override
    public int getItemCount() {
        return tricountList.size();
    }

    // Classe interne pour le ViewHolder du RecyclerView
    public static class TricountViewHolder extends RecyclerView.ViewHolder {
        TextView titre, description, date;

        // Constructeur du ViewHolder
        public TricountViewHolder(@NonNull View itemView) {
            super(itemView);
            titre = itemView.findViewById(R.id.titre);
            description = itemView.findViewById(R.id.description);
            date = itemView.findViewById(R.id.date);
        }
    }
}