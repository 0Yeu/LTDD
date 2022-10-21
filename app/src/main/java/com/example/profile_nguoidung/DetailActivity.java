package com.example.profile_nguoidung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.auth.User;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return;
        }

        KhachSan khachSan = (KhachSan) bundle.get("Object_user");

        ImageView img_hinh = findViewById(R.id.img_hinh);
        TextView tv_ten = findViewById(R.id.tv_ten);
        TextView tv_sao = findViewById(R.id.tv_sao);

        img_hinh.setImageResource(khachSan.getHinh());
        tv_ten.setText(khachSan.getTen());
        tv_sao.setText(khachSan.getSao());

    }
}