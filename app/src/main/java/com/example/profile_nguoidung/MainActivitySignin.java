package com.example.profile_nguoidung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivitySignin extends AppCompatActivity {
    TextView txtSignUp, tv_signin;
    TextInputEditText txtEmail, txtPassword;
    Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_signin);

        tv_signin   = findViewById(R.id.tv_signin);
        txtSignUp   = findViewById(R.id.txtSignUp);
        txtEmail    = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnSignIn   = findViewById(R.id.btnSignIn);

        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivitySignin.this, MainActivitySignup.class);
                startActivity(intent);
                finish();
            }
        });

        tv_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivitySignin.this, RecycleViewKhachSan.class);
                startActivity(intent);
                finish();
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtEmail.getText().toString().isEmpty() && txtPassword.getText().toString().isEmpty()){
                    Toast.makeText(MainActivitySignin.this, "Ban can nhap Email va Password", Toast.LENGTH_SHORT).show();
                } else if (txtEmail.getText().toString().isEmpty()){
                    Toast.makeText(MainActivitySignin.this, "Ban can nhap email", Toast.LENGTH_SHORT).show();
                    txtEmail.requestFocus();
                } else if (txtPassword.getText().toString().isEmpty()){
                    Toast.makeText(MainActivitySignin.this, "Ban can nhap Password", Toast.LENGTH_SHORT).show();
                txtPassword.requestFocus();
                } else {
                    Intent intent = new Intent(MainActivitySignin.this, RecycleViewKhachSan.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}