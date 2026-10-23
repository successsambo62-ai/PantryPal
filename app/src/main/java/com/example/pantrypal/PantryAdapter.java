package com.example.pantrypal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PantryAdapter extends RecyclerView.Adapter<PantryAdapter.ViewHolder> {

    private final List<PantryItem> pantryItems;

    public PantryAdapter(Context context, List<PantryItem> pantryItems) {
        this.pantryItems = pantryItems;
    }

    public PantryAdapter(List<PantryItem> pantryItems) {
        this.pantryItems = pantryItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pantry, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PantryItem item = pantryItems.get(position);
        holder.tvName.setText(item.getName());
        String qtyUnit = item.getQuantity() + " " + item.getUnit();
        holder.tvQuantity.setText(qtyUnit);
        if (item.getExpiryDate() != null && !item.getExpiryDate().isEmpty()) {
            holder.tvExpiry.setText("Expires: " + item.getExpiryDate());
        } else {
            holder.tvExpiry.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return pantryItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvName;
        public final TextView tvQuantity;
        public final TextView tvExpiry;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
            tvExpiry = itemView.findViewById(R.id.tvExpiry);
        }
    }
}
