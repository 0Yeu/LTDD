package com.example.sqlite_qlsv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.sqlite_qlsv.dao.SinhVienDAO;
import com.example.sqlite_qlsv.model.SinhVien;

public class EditActivity extends AppCompatActivity {
    //Ánh xạ
    private EditText edtHoTen, edtEmail, edtDienThoai;
    private RadioGroup rgGioiTinh;
    private RadioButton rbNam, rbNu;
    private Button btnLuu, btnThoat;
    int gioitinh;
    private SinhVienDAO svDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        svDAO = new SinhVienDAO(EditActivity.this);
        //Lấy dữ liệu
        Intent intent = getIntent();
        SinhVien sinhvien = (SinhVien) intent.getSerializableExtra("DULIEU");
        //Ánh xạ
        AnhXa();
        //lấy dữ liệu đưa lên view
        edtHoTen.setText(sinhvien.getHoTen());
        edtEmail.setText(sinhvien.getEmail());
        edtDienThoai.setText(sinhvien.getDienThoai());
        if (sinhvien.getGioiTinh()==1){
            rbNam.setChecked(true);
            gioitinh = 1;
        } else {
            rbNu.setChecked(true);
            gioitinh = 0;
        }

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //Sự kiện cho Group gioi tinh
        rgGioiTinh.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rb_nam){
                    gioitinh=1;
                }else {
                    gioitinh =0;
                }
            }
        });
        //luu
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sinhvien.setHoTen(edtHoTen.getText().toString());
                sinhvien.setEmail(edtEmail.getText().toString());
                sinhvien.setDienThoai(edtDienThoai.getText().toString());
                sinhvien.setGioiTinh(gioitinh);

            }
        });
    }

    private void  AnhXa(){
        edtHoTen = (EditText) findViewById(R.id.edt_hoten);
        edtEmail = (EditText) findViewById(R.id.edt_email);
        edtDienThoai = (EditText) findViewById(R.id.edt_dienthoai);
        rgGioiTinh = (RadioGroup) findViewById(R.id.rg_gioitinh);
        rbNam = (RadioButton) findViewById(R.id.rb_nam);
        rbNu = (RadioButton) findViewById(R.id.rb_nu);
        btnLuu = (Button) findViewById(R.id.btn_luu);
        btnThoat = (Button) findViewById(R.id.btn_thoat);
    }
}