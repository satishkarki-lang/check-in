package com.example.checkin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText  user, pass, date, country, phone, email, address;
    RadioGroup gender;
    Button register, close;

    SharedPreferences preferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        date= findViewById(R.id.date);
        country = findViewById(R.id.country);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        gender = findViewById(R.id.gender);
        register = findViewById(R.id.register);
        close = findViewById(R.id.close);

        preferences = getSharedPreferences("userinfo", 0);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = user.getText().toString();
                String password = pass.getText().toString();
                String dob = date.getText().toString();
                String con = country.getText().toString();
                String phn = phone.getText().toString();
                String emailId = email.getText().toString();
                String adrs = address.getText().toString();
                RadioButton checkedBtn = findViewById(gender.getCheckedRadioButtonId());
                String gender = checkedBtn.getText().toString();

                if(userName.length()>1) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("user", userName);
                    editor.putString("pass", password);
                    editor.putString("date", dob);
                    editor.putString("country", con);
                    editor.putString("phone", phn);
                    editor.putString("email", emailId);
                    editor.putString("address", adrs);
                    editor.putString("gender", gender);
                    editor.apply();
                    Toast.makeText(Register.this, "Thank You for registering with us!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Register.this, "Enter value in the fields", Toast.LENGTH_SHORT).show();
                }



            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nofield();

            }
        });


    }

    public void  nofield(){
        user.setText("");
        pass.setText("");
        date.setText("");
        country.setText("");
        phone.setText("");
        email.setText("");
        address.setText("");
    }
}