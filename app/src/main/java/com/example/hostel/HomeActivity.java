package com.example.hostel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
       String username = sharedPreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(), "Welcome"+username, Toast.LENGTH_SHORT).show();

        CardView exit = findViewById(R.id.cardRoom6);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(  HomeActivity.this,LoginActivity.class));
            }
        });

        CardView fixmeeting = findViewById(R.id.cardRoom3);
        fixmeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(  HomeActivity.this,MeetingActivity.class));
            }
        });

        CardView rooms = findViewById(R.id.cardRoom1);
        rooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(  HomeActivity.this,RoomsActivity.class));
            }
        });

        CardView roomsview = findViewById(R.id.cardRoom4);
        roomsview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(  HomeActivity.this,RoomsViewActivity.class));
            }
        });

        CardView meals = findViewById(R.id.cardRoom2);
        meals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(  HomeActivity.this,MealsActivity.class));
            }
        });

        CardView cart = findViewById(R.id.cardRoom5);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(  HomeActivity.this,CartActivity.class));
            }
        });


    }
}