package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private Button btnMain2;
    TextView txtKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnMain2 = (Button) findViewById(R.id.btn_main2);
        txtKetQua = (TextView) findViewById(R.id.txtKetQua);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("dulieu");
        String ten = bundle.getString("name");
        txtKetQua.setText(ten);
        btnMain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}