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

public class MeetingActivity extends AppCompatActivity {
    private String[][] packages1 =
            {{"Mohammadpur : Sazzad Hossain ", "Phone :01711111111", "", "","Room :Admission Office"},
                    {"Azimpur : NadimMahmud Prince ", "Phone :01711111112", "", "","Room :Admission Office"},
                    {"Mirpur : Sumaiya binte Ishak ", "Phone :01711111113", "", "","Room :Admission Officek"},
                    {"Uttara : Alimul islam Imon ", "Phone :01711111114", "", "","Room :Admission Office"},
                    {"Gulistan : Tawheed Hasan Mia ", "Phone :01711111115", "", "","Room :Admission Office"}
            };

    private String[] package_details1 = {

                    "Time = 10am - 7pm\n",
            "Time = 10am - 7pm\n",
            "Time = 10am - 7pm\n",
            "Time = 10am - 7pm\n",
            "Time = 10am - 7pm\n",

    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnMeetingCart,btnMeetingBack;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting);

        btnMeetingCart = findViewById(R.id.buttonMeetingCart);
        btnMeetingBack = findViewById(R.id.buttonMeetingBack);
        listView = findViewById(R.id.editTextRoomsTextMultiLine);

        btnMeetingBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(  MeetingActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i< packages1.length;i++){

            item = new HashMap<String,String>();
            item.put("line1",packages1[i][0]);
            item.put("line2",packages1[i][1]);
            item.put("line3",packages1[i][2]);
            item.put("line4",packages1[i][3]);
            item.put("line5",""+packages1[i][4]+"");
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
                Intent it = new Intent(MeetingActivity.this,MeetingDetailsActivity.class);
                it.putExtra("text1",packages1[i][0]);
                it.putExtra("text2",package_details1[i]);
                it.putExtra("text3",packages1[i][4]);
                startActivity(it);
            }
        });



    }


}