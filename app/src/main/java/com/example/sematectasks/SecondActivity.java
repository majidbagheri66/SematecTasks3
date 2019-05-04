package com.example.sematectasks;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;
import java.util.Set;

public class SecondActivity extends AppCompatActivity {
TextView tvname,tvfamily,tvage,tvemail;
Button btnyes,btnno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvage=findViewById(R.id.tv_age);
        tvemail=findViewById(R.id.tv_email);
        tvfamily=findViewById(R.id.tv_family);
        tvname=findViewById(R.id.tv_name);
        btnyes=findViewById(R.id.btn_yes);
        btnno=findViewById(R.id.btn_no);
        //intent
        Intent intent=getIntent();
        tvname.setText(intent.getStringExtra("name"));
        tvfamily.setText(intent.getStringExtra("family"));
        tvage.setText(intent.getStringExtra("age"));
        tvemail.setText(intent.getStringExtra("email"));
        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceManager.getDefaultSharedPreferences(SecondActivity.this).edit().putString("name",tvname.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(SecondActivity.this).edit().putString("family",tvfamily.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(SecondActivity.this).edit().putString("age",tvage.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(SecondActivity.this).edit().putString("email",tvemail.getText().toString()).apply();

                Intent intent1=new Intent();
                setResult(RESULT_OK,intent1);
                finish();
            }
        });
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent();
                setResult(RESULT_CANCELED,intent2);
                finish();
            }
        });
    }
}
