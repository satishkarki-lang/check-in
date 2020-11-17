package com.example.checkin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText user,pass;
    Button login, register;

    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        preferences = getApplicationContext().getSharedPreferences("userinfo",MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = user.getText().toString();
                String password = pass.getText().toString();

                String registerUser = preferences.getString("user","");
                String registerPassword = preferences.getString("pass","");

                if(userName.equals(registerUser) && password.equals(registerPassword)){
                    Intent intent = new Intent(MainActivity.this, home.class);
                    startActivity(intent);

                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
    }
}