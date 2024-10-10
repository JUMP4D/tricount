package com.example.tricount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tricount.User;

import java.util.List;

public class MembreAdapter extends RecyclerView.Adapter<MembreAdapter.ViewHolder> {

    private List<User> membreList;
    private Context context;

    public MembreAdapter(List<User> membreList, Context context) {
        this.membreList = membreList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_membre, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = membreList.get(position);
        holder.nom.setText(user.getNom());
        holder.prenom.setText(user.getPrenom());
    }

    @Override
    public int getItemCount() {
        return membreList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nom;
        public TextView prenom;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nom = itemView.findViewById(R.id.Nom);
            prenom = itemView.findViewById(R.id.Prénom);
        }
    }
}