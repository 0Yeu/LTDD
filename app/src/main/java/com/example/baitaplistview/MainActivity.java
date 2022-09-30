package com.example.baitaplistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvKhachSan;
    ArrayList<KhachSan> arrayKhachSan;
    KhachSanAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        adapter = new KhachSanAdapter(this, R.layout.khach_san, arrayKhachSan);
        lvKhachSan.setAdapter(adapter);
    }

    private void  AnhXa() {
        lvKhachSan = (ListView) findViewById(R.id.ListviewKhachSan);
        arrayKhachSan = new ArrayList<>();

        arrayKhachSan.add(new KhachSan("Khach san Hung Vuong", "3 sao", R.drawable.ic_launcher_background));
        arrayKhachSan.add(new KhachSan("Khach san Le Loi", "3 sao", R.drawable.ic_launcher_background));
        arrayKhachSan.add(new KhachSan("Khach san Le Trung Dinh", "3 sao", R.drawable.ic_launcher_background));
        arrayKhachSan.add(new KhachSan("Khach san Duc Manh", "3 sao", R.drawable.ic_launcher_background));
        arrayKhachSan.add(new KhachSan("Khach san Thuy Tram", "3 sao", R.drawable.ic_launcher_background));


    }
}