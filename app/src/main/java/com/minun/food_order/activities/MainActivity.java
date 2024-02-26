package com.minun.food_order.activities;

import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.minun.food_order.R;
import com.minun.food_order.adapters.CategoriesAdapter;
import com.minun.food_order.adapters.PopularsAdapter;
import com.minun.food_order.domain.CategoryDomain;
import com.minun.food_order.domain.FoodDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView.Adapter adapterCategory, adapterPopular;
    RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerViewCategory);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categories = new ArrayList<>();
        categories.add(new CategoryDomain("Pizza", "pizza_icon"));
        categories.add(new CategoryDomain("Burger", "logo_icon"));
        categories.add(new CategoryDomain("Hotdog", "hotdog_icon"));
        categories.add(new CategoryDomain("Drink", "drink_icon"));
        categories.add(new CategoryDomain("Donut", "donut_icon"));

        adapterCategory = new CategoriesAdapter(categories);
        recyclerViewCategoryList.setAdapter(adapterCategory);

    }

    private void recyclerViewPopular() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerViewPopular);
        recyclerViewPopularList.setLayoutManager(layoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("pepperoni Pizza","pizza1","slices pepperoni, mozzerella, cheese, fresh oregano, ground black pepper, pizza sauce", 9.76));
        foodList.add(new FoodDomain("Cheese Burger","burger","beef,gouda cheese, special sauce, lettuce, tomato", 8.79));
        foodList.add(new FoodDomain("vegetable pizza","pizza2","olive oil, vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil", 8.5));


        adapterPopular = new PopularsAdapter(foodList);
        recyclerViewPopularList.setAdapter(adapterPopular);
    }
}