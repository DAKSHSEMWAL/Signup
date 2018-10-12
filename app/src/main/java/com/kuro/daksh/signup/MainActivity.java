package com.kuro.daksh.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = findViewById(R.id.name);
        final EditText email = findViewById(R.id.Email);
        final EditText phone = findViewById(R.id.Phone);
        final EditText password = findViewById(R.id.password);
        final EditText dob = findViewById(R.id.Date);

        Button button= findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user= new User();
                user.setFirebase_id("rdfhgjhjjy");
                user.setDevice("4");
                user.setName(name.getText().toString());
                user.setPhone(phone.getText().toString());
                user.setEmail(email.getText().toString());
                user.setPassword(password.getText().toString());
                user.setDob(dob.getText().toString());
                postnewData(user);
                Intent in = new Intent(MainActivity.this,login.class);
                in.putExtra("phone",user.getPhone());
                in.putExtra("password",user.getPassword());
                startActivity(in);
            }
        });

    }

    private void postnewData(User user) {
        Retrofit.Builder builder=new Retrofit.Builder().
                baseUrl("http://veritracksystems.com/api/customer/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("firebase_id", user.getFirebase_id())
                .addFormDataPart("device", user.getDevice())
                .addFormDataPart("name",user.getName())
                .addFormDataPart("email",user.getEmail())
                .addFormDataPart("phone",user.getPhone())
                .addFormDataPart("password",user.getPassword())
                .addFormDataPart("dob",user.getDob())
                .build();


        signUPApi client = retrofit.create(signUPApi.class);
        Call<User> call = client.createAccount(requestBody);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(MainActivity.this, "Sucessfully Created User\n"+response.body().getStatus()+"\n"+response.body().getData(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
