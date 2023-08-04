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

public class RoomsActivity extends AppCompatActivity {

    private String[][] packages =
            {{"Package 1 : Single Room ", "", "", "","Fees Monthly : 2000 tk"},
                    {"Package 2 : Single Room(Ac)", "", "", "","Fees Monthly : 5000 tk"},
                    {"Package 3 : Shared Room", "", "", "","Fees Monthly : 1500 tk"},
                    {"Package 4 : Shared Room(Ac)", "", "", "","Fees Monthly : 4000 tk"},
                    {"Package 5 : Personal Balcony Room ", "", "", "","Fees Monthly : 2500 tk"}
            };

    private String[] package_details = {
            "bed\n" +
                    "table\n"+
                    "fan\n"+
                    "weardrobe\n" +
                    "chair\n"+
                    "wifi\n"+
                    "book shelf",

            "bathroom"+"table\n"+
            "fan\n"+
            "weardrobe\n" +
            "water jar\n"+
            "hanger\n"+
            "multi plug\n",

            "wifi\n" + "table\n"+
            "fan\n"+
            "weardrobe\n" +
            "water jar\n"+
            "hanger\n"+
            "multi plug\n",

            "window"+"table\n"+
            "fan\n"+
            "weardrobe\n" +
            "water jar\n"+
            "hanger\n"+
            "multi plug\n",

            "wifi\n" +
                    "laundry\n" +
                    "chair\n"+
                    "calendar\n"+
                    "clock\n"+
                    "mirror\n"+
                    "ips\n"+
                    "dining space"

    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnRoomsCart,btnRoomsBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

        btnRoomsCart = findViewById(R.id.buttonRoomsCart);
        btnRoomsBack = findViewById(R.id.buttonRoomsBack);
        listView = findViewById(R.id.editTextRoomsTextMultiLine);

        btnRoomsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(  RoomsActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i< packages.length;i++){

            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost:"+packages[i][4]+"");
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
                Intent it = new Intent(RoomsActivity.this,RoomsMoreDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });

    }
}