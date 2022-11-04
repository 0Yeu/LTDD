package com.example.sqlite_qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.sqlite_qlsv.dao.SinhVienDAO;
import com.example.sqlite_qlsv.model.SinhVien;

public class AddActivity extends AppCompatActivity {
    //Khai báo
    private EditText edtHoTen, edtEmail, edtDienThoai;
    private RadioGroup rgGioiTinh;
    private Button btn_them, btn_thoat;
    int gioitinh=1;
    private SinhVienDAO svDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        //Ánh xạ
        AnhXa();
        svDao = new SinhVienDAO(AddActivity.this);
        rgGioiTinh.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i==R.id.rb_nam) {
                    gioitinh=1;
                } else {
                    gioitinh=0;
                }
            }
        });

        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten = edtHoTen.getText().toString();
                String email = edtEmail.getText().toString();
                String dienthoai = edtDienThoai.getText().toString();
                SinhVien sv = new SinhVien(hoten, gioitinh, dienthoai, email);
                svDao.ThemSinhVien(sv);
            }
        });

        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void AnhXa(){
        edtHoTen = (EditText) findViewById(R.id.edt_hoten);
        edtEmail = (EditText) findViewById(R.id.edt_email);
        edtDienThoai = (EditText) findViewById(R.id.edt_dienthoai);
        rgGioiTinh = (RadioGroup) findViewById(R.id.rg_gioitinh);
        btn_them = (Button) findViewById(R.id.btn_them);
        btn_thoat = (Button) findViewById(R.id.btn_thoat);
    }
}