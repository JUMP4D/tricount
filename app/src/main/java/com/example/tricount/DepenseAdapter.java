package com.example.tricount;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DepenseAdapter extends RecyclerView.Adapter<DepenseAdapter.ExpenseViewHolder> {

    private List<Depense> expenseList;

    public DepenseAdapter(List<Depense> expenseList) {
        this.expenseList = expenseList;
    }

    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tricount_user, parent, false);
        return new ExpenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {
        Depense expense = expenseList.get(position);
        holder.Titre.setText(expense.getTitre());
        holder.Description.setText(expense.getDescription());
        holder.Montant.setText(String.valueOf(expense.getMontant()));
        holder.Date.setText(expense.getDate());
    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public static class ExpenseViewHolder extends RecyclerView.ViewHolder {
        TextView Titre, Description, Montant, Date;

        public ExpenseViewHolder(@NonNull View itemView) {
            super(itemView);
            Titre = itemView.findViewById(R.id.expenseTitle);
            Description = itemView.findViewById(R.id.expenseDescription);
            Montant = itemView.findViewById(R.id.expenseMontant);
            Date = itemView.findViewById(R.id.expenseDate);
        }
    }
}