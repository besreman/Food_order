package com.minun.food_order.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.minun.food_order.R;
import com.minun.food_order.domain.CategoryDomain;
import com.minun.food_order.domain.FoodDomain;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PopularsAdapter extends RecyclerView.Adapter<PopularsAdapter.ViewHolder> {
    ArrayList<FoodDomain> foodsList;

    public PopularsAdapter(ArrayList<FoodDomain> foodsList) {
        this.foodsList = foodsList;
    }

    @NonNull
    @NotNull
    @Override
    public PopularsAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_popular,parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PopularsAdapter.ViewHolder holder, int position) {
        holder.title.setText(foodsList.get(position).getTitle());
        holder.fee.setText(String.valueOf(foodsList.get(position).getFee()));

        String picUrl = "";

        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(foodsList.get(position).getPic(),"drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.foodPic);
    }

    @Override
    public int getItemCount() {
        return foodsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, fee, addButton;
        ImageView foodPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtTitle);
            fee = itemView.findViewById(R.id.txtFee);
            foodPic = itemView.findViewById(R.id.imgFoodPic);
            addButton = itemView.findViewById(R.id.txtAddButton);
        }
    }
}
