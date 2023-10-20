package com.example.tp3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText msgenv;
    private TextView msgrec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msgenv = this.findViewById(R.id.msgenv);
        msgrec = this.findViewById(R.id.msgrecu);
    }

    public void Envoyer(View v){
        String s = msgenv.getText().toString();
        if (s.equals("")){
            Toast.makeText(this,"Veuillez Saisir un message",Toast.LENGTH_LONG).show();
        } else{
            Intent i = new Intent(MainActivity.this, Second.class);
            i.putExtra("msg",s);
            startActivityForResult(i,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){
            if (resultCode == RESULT_OK){
                String reply = data.getStringExtra("rep");
                msgrec.setText(reply);
            }
            if (resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Nothing Recieved",Toast.LENGTH_LONG).show();
            }
        }
    }
}