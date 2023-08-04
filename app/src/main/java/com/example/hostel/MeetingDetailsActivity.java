package com.example.hostel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MeetingDetailsActivity extends AppCompatActivity {


    TextView tvPackageName,tvMeetingTimeFix;
    EditText edDetails;
    Button btnFixMeetingCart,btnFixMeetingBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_details);

        tvPackageName = findViewById(R.id.textViewMeetingTime);
        tvMeetingTimeFix = findViewById(R.id.textViewRoomsMeetingTimeFix);
        edDetails = findViewById(R.id.editTextRoomsTextMultiLine);
        btnFixMeetingCart = findViewById(R.id.buttonMeetingTimeCart);
        btnFixMeetingBack = findViewById(R.id.buttonMeetingTimeBack);

        edDetails.setKeyListener(null);

        Intent intent=getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvMeetingTimeFix.setText(""+intent.getStringExtra("text3")+"");

        btnFixMeetingBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(  MeetingDetailsActivity.this,MeetingActivity.class));
            }
        });

    }
}