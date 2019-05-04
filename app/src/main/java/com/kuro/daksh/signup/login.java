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
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText phone = findViewById(R.id.phone1);
        final EditText password = findViewById(R.id.password1);

        Button button= findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUser user= new getUser();
                user.setFirebase_id("dfgfhfh");
                user.setDevice("4");
                user.setLogin_type("4");
                user.setPhone(phone.getText().toString());
                user.setPassword(password.getText().toString());
                loadData(user);
            }
        });

    }

    private void loadData(getUser user) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient cli = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit.Builder builder=new Retrofit.Builder().
                baseUrl("http://veritracksystems.com/api/customer/")
                .client(cli)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("phone",user.getPhone())
                .addFormDataPart("password",user.getPassword())
                .addFormDataPart("firebase_id", user.getFirebase_id())
                .addFormDataPart("device", user.getDevice())
                .addFormDataPart("login_type",user.getLogin_type())
                .build();


        signUPApi client = retrofit.create(signUPApi.class);
        Call<getUser> call = client.getAcctout(requestBody);
        call.enqueue(new Callback<getUser>() {
            @Override
            public void onResponse(Call<getUser> call, Response<getUser> response) {
                Toast.makeText(login.this, "Successfully Created User\n"+response.body().getStatus()+"\n"+response.body().getData(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<getUser> call, Throwable t) {
                Toast.makeText(login.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
