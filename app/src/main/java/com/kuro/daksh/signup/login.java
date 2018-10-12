package com.kuro.daksh.signup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    String phone;
    String password;
    Button logi;
    EditText pass;
    EditText pho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(getIntent()!=null)
        {
            phone=getIntent().getStringExtra("phone");
            password=getIntent().getStringExtra("password");
        }
        pho=findViewById(R.id.phone1);
        pass=findViewById(R.id.password1);
        logi =(Button) findViewById(R.id.button1);
        logi.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                load();
            }
        });
    }

    private void load() {
        Toast.makeText(this,""+ pho.getText().toString()+"\n"+pass.getText().toString(),Toast.LENGTH_SHORT).show();
        if(phone.equals(pho.getText().toString())&&password.equals(pass.getText().toString()))
        {
            Toast.makeText(login.this,"Welcome",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(login.this,"Wrong Inputs",Toast.LENGTH_SHORT).show();
        }
    }
}