package com.example.sqlite_qlsv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqlite_qlsv.adapter.SinhVienAdapter;
import com.example.sqlite_qlsv.dao.SinhVienDAO;
import com.example.sqlite_qlsv.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvSinhVien;
    private List<SinhVien> sinhVienList;
    private SinhVienAdapter adapter;
    private SinhVienDAO svDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ánh xạ
        lvSinhVien = (ListView) findViewById(R.id.lv_sv);
        //Có dữ liệu
        sinhVienList = new ArrayList<SinhVien>();
        svDao = new SinhVienDAO(MainActivity.this);
        sinhVienList = svDao.TatCaSinhVien();
        //
        adapter = new SinhVienAdapter(getApplicationContext(), sinhVienList);
        lvSinhVien.setAdapter(adapter);
        //Sự kiện listview
        SuKien_ListView();

    }

    private void SuKien_ListView() {
        lvSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SinhVien sv = sinhVienList.get(i);
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                intent.putExtra("DULIEU", sv);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menu_them){
            Intent intent = new Intent(MainActivity.this, AddActivity.class);
            startActivity(intent);
        }
        if (id == R.id.menu_thoat){
            finish();
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        sinhVienList.clear();
        sinhVienList.addAll(svDao.TatCaSinhVien());
        adapter.notifyDataSetChanged();
    }
}