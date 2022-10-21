package com.example.profile_nguoidung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewKhachSan extends AppCompatActivity {
    private RecyclerView rcv_hotel;
    private KhachSanAdapter khachSanAdapter;
    TextView tv_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_khach_san);

        tv_profile = (TextView) findViewById(R.id.tv_back);
        tv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecycleViewKhachSan.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        rcv_hotel = (RecyclerView) findViewById(R.id.rcv_hotel);
        khachSanAdapter = new KhachSanAdapter(this, getListKhachSan());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        rcv_hotel.setLayoutManager(linearLayoutManager);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcv_hotel.addItemDecoration(itemDecoration);

        khachSanAdapter.setData(getListKhachSan());

        rcv_hotel.setAdapter(khachSanAdapter);

    }

    private List<KhachSan> getListKhachSan() {
        List<KhachSan> list = new ArrayList<>();
        list.add(new KhachSan(R.drawable.hotel1, "Khách sạn Mường Thanh","5 Sao"));
        list.add(new KhachSan(R.drawable.hotel4, "Khách sạn Cẩm Thành", "5 Sao"));
        list.add(new KhachSan(R.drawable.hotel5, "Khách sạn Lê Lợi", "5 Sao"));
        list.add(new KhachSan(R.drawable.hotel6, "Khách sạn Hùng Vương", "5 Sao"));
        list.add(new KhachSan(R.drawable.hotel7, "Khách Sạn eden", "4 Sao"));
        list.add(new KhachSan(R.drawable.hotel8, "Khách sạn Balcona", "5 Sao"));
        list.add(new KhachSan(R.drawable.hotel1, "Khách sạn Mường Thanh","5 Sao"));
        list.add(new KhachSan(R.drawable.hotel4, "Khách sạn Cẩm Thành", "5 Sao"));
        list.add(new KhachSan(R.drawable.hotel5, "Khách sạn Lê Lợi", "5 Sao"));
        list.add(new KhachSan(R.drawable.hotel6, "Khách sạn Hùng Vương", "5 Sao"));
        list.add(new KhachSan(R.drawable.hotel7, "Khách Sạn eden", "4 Sao"));
        list.add(new KhachSan(R.drawable.hotel8, "Khách sạn Balcona", "5 Sao"));
        return list;
    }


}