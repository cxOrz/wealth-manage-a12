package com.miaoc.wealthmanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button bt_login;
    private Button bt_cancel;
    private EditText et_password;
    private String pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences sharedPreferences = getSharedPreferences("wealth",0);
        pwd = sharedPreferences.getString("pwd","");
        bt_login = findViewById(R.id.button);
        bt_cancel = findViewById(R.id.button2);
        et_password = findViewById(R.id.editText);
        Intent intent = new Intent(this, MainActivity.class);
        bt_login.setOnClickListener(e -> {
            if (et_password.getText().toString().equals(pwd)) {
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "密码错误，爬！", Toast.LENGTH_LONG).show();
            }
        });
        bt_cancel.setOnClickListener(e -> {
            finish();
        });
    }
}