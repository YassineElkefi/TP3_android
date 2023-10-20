package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Second extends AppCompatActivity {
    private EditText reply;
    private TextView recieved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("Activity 2");

        reply=this.findViewById(R.id.msgenv2);
        recieved = this.findViewById(R.id.msgrecu2);
        String msgrecu = getIntent().getStringExtra("msg");

        recieved.setText(msgrecu);
    }
    public void Reply(View v){
        String resp = reply.getText().toString();

        Intent replyIntent = new Intent();
        replyIntent.putExtra("rep",resp);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}