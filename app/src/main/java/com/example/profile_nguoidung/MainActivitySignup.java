package com.example.profile_nguoidung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivitySignup extends AppCompatActivity {
    TextView txtSignIn;
    TextInputEditText txtName, txtEmail, txtPhone, txtPassword, txtRePassword;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_signup);

        txtSignIn       = findViewById(R.id.txtSignIn);
        txtName         = findViewById(R.id.txtName);
        txtEmail        = findViewById(R.id.txtEmail);
        txtPhone        = findViewById(R.id.txtPhone);
        txtPassword     = findViewById(R.id.txtPassword);
        txtRePassword   = findViewById(R.id.txtRePassword);
        btnSignUp       = findViewById(R.id.btnSignUp);

        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivitySignup.this, MainActivitySignin.class);
                startActivity(intent);
                finish();
            }
        });


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtName.getText().toString().isEmpty() && txtEmail.getText().toString().isEmpty() && txtPhone.getText().toString().isEmpty() && txtPassword.getText().toString().isEmpty() && txtRePassword.getText().toString().isEmpty()){
                    Toast.makeText(MainActivitySignup.this, "Ban can nhap thong tin !!!", Toast.LENGTH_SHORT).show();
                } else if (txtName.getText().toString().isEmpty()){
                    Toast.makeText(MainActivitySignup.this, "Ban can nhap Full Name !", Toast.LENGTH_SHORT).show();
                    txtName.requestFocus();
                } else if (txtEmail.getText().toString().isEmpty()){
                    Toast.makeText(MainActivitySignup.this, "Ban can nhap Email !", Toast.LENGTH_SHORT).show();
                    txtEmail.requestFocus();
                } else if (txtPhone.getText().toString().isEmpty()){
                    Toast.makeText(MainActivitySignup.this, "Ban can nhap Phone !", Toast.LENGTH_SHORT).show();
                    txtPhone.requestFocus();
                } else if (txtPassword.getText().toString().isEmpty()){
                    Toast.makeText(MainActivitySignup.this, "Ban can nhap Password !", Toast.LENGTH_SHORT).show();
                    txtPassword.requestFocus();
                } else if (txtRePassword.getText().toString().isEmpty()){
                    Toast.makeText(MainActivitySignup.this, "Ban can nhap Re-Password !", Toast.LENGTH_SHORT).show();
                    txtRePassword.requestFocus();
                } else {
                    Toast.makeText(MainActivitySignup.this, "Ban da dang ky thanh cong !", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivitySignup.this, "Moi ban dang nhap !", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivitySignup.this, MainActivitySignin.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}