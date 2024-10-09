package com.example.tricount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TricountAdapter extends RecyclerView.Adapter<TricountAdapter.TricountViewHolder> {

    private List<Tricount> tricountList;
    private Context context;

    public TricountAdapter(List<Tricount> tricountList, Context context) {
        this.tricountList = tricountList;
        this.context = context;
    }

    @NonNull
    @Override
    public TricountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tricount_item, parent, false);
        return new TricountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TricountViewHolder holder, int position) {
        Tricount tricount = tricountList.get(position);
        holder.titre.setText(tricount.getTitre());
        holder.description.setText(tricount.getDescription());
        holder.date.setText(tricount.getDate());
    }

    @Override
    public int getItemCount() {
        return tricountList.size();
    }

    public static class TricountViewHolder extends RecyclerView.ViewHolder {
        TextView titre, description, date;

        public TricountViewHolder(@NonNull View itemView) {
            super(itemView);
            titre = itemView.findViewById(R.id.titre);
            description = itemView.findViewById(R.id.description);
            date = itemView.findViewById(R.id.date);
        }
    }
}