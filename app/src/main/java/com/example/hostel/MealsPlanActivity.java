package com.example.hostel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MealsPlanActivity extends AppCompatActivity {

    TextView tvPackageName,tvTotalCost;
    EditText edDetails;
    Button btnMPCart,btnMPBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_plan);

        tvPackageName = findViewById(R.id.textViewMealsPlan);
        tvTotalCost = findViewById(R.id.textViewMealsTotalCost);
        edDetails = findViewById(R.id.editTextRoomsTextMultiLine);
        btnMPCart = findViewById(R.id.buttonMPCart);
        btnMPBack = findViewById(R.id.buttonMPBack);

        edDetails.setKeyListener(null);

        Intent intent=getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText(" Meal Total Cost : "+intent.getStringExtra("text3")+"");

        btnMPBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(  MealsPlanActivity.this,MealsActivity.class));
            }
        });

    }
}