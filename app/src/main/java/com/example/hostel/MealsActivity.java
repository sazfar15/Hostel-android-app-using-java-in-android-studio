package com.example.hostel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MealsActivity extends AppCompatActivity {

    private String[][] packages2 =
            {{"Package 1 : Breakfast ", "", "", "","Fees Monthly : 400 tk"},
                    {"Package 2 : Lunch", "", "", "","Fees Monthly : 500 tk"},
                    {"Package 3 : Evening", "", "", "","Fees Monthly : 200 tk"},
                    {"Package 4 : Dinner", "", "", "","Fees Monthly : 400 tk"},
                    {"Package 5 : Extra Snacks ", "", "", "","Fees Monthly :  tk"}
            };

    private String[] package_details2 = {
            "Vat\n" +
                    "Vegetable\n"+
                    "Egg\n"+
                    "Parata\n" +
                    "Daal\n"+
                    "Tea",

            "Vaat\n"+"Biriyani -friday only\n"+
                    "shak\n"+
                    "daal\n" +
                    "Meat or Fish",


            "Tea or Milk\n"+"Bread or toast\n"+
                    "Banana",

            "Vaat\n"+"Spacial Curry\n"+
                    "shak\n"+
                    "daal\n" +
                    "Meat or Fish",

            "Chips\n"+ "Coke\n"+"Medicine\n"+
                    "Fruits",

    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnMealsCart,btnMealsBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);

        btnMealsCart = findViewById(R.id.buttonMealsCart);
        btnMealsBack = findViewById(R.id.buttonMealsBack);
        listView = findViewById(R.id.editTextRoomsTextMultiLine);

        btnMealsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(  MealsActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i< packages2.length;i++){

            item = new HashMap<String,String>();
            item.put("line1",packages2[i][0]);
            item.put("line2",packages2[i][1]);
            item.put("line3",packages2[i][2]);
            item.put("line4",packages2[i][3]);
            item.put("line5","Total Cost:"+packages2[i][4]+"");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(MealsActivity.this,MealsPlanActivity.class);
                it.putExtra("text1",packages2[i][0]);
                it.putExtra("text2",package_details2[i]);
                it.putExtra("text3",packages2[i][4]);
                startActivity(it);
            }
        });

    }
}