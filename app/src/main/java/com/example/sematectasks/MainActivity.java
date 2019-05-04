package com.example.sematectasks;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText txtname,txtfamily,txtage,txtemail;
Button btnsend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtname=findViewById(R.id.txt_name);
        txtfamily=findViewById(R.id.txt_family);
        txtage=findViewById(R.id.txt_age);
        txtemail=findViewById(R.id.txt_email);
        btnsend=findViewById(R.id.btn_send);
        txtname.setText(PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("name",""));
        txtfamily.setText(PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("family",""));
        txtage.setText(PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("age",""));
        txtemail.setText(PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("email",""));

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=txtname.getText().toString();
                String family=txtfamily.getText().toString();
                String age =txtage.getText().toString();
                String email=txtemail.getText().toString();
                if (name.length()>=3 && family.length()>=4 && (Integer.parseInt(age)>0 && Integer.parseInt(age)<110 )){

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("family",family);
                intent.putExtra("age",age);
                intent.putExtra("email",email);
                startActivityForResult(intent,66);
            }
                else {
                    v.requestFocus();
                    Toast.makeText(MainActivity.this, "لطفا اطلاعات را صحیح وارد کنید.", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==66){
            if (resultCode==RESULT_OK){
                txtname.setText(PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("name",""));
                txtfamily.setText(PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("family",""));
                txtage.setText(PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("age",""));
                txtemail.setText(PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getString("email",""));

                Toast.makeText(this, "اطلاعات با موفقیت ذخیره شد", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "متاسفانه اطلاعات ذخیره نشد", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
