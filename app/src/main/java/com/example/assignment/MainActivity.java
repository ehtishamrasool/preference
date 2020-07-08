package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button mbutton;
    public EditText mtext;
    public TextView mview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbutton = findViewById(R.id.button);
        mtext = findViewById(R.id.mytext);
        mview = findViewById(R.id.textView);

        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String data = mtext.getText().toString();
                SharedPreferences shared = getSharedPreferences("mydata",MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putString("strdata",data);
                editor.apply();
                mview.setText(data);
            }
        });

        SharedPreferences getshared_data = getSharedPreferences("mydata",MODE_PRIVATE);
        String reterive_data = getshared_data.getString("strdata","Please save data first");
        mview.setText(reterive_data);
    }
}