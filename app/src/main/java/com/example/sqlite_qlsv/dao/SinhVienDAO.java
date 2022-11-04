package com.example.sqlite_qlsv.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqlite_qlsv.database.DbHelper;
import com.example.sqlite_qlsv.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {

    private DbHelper csdl;

    public SinhVienDAO(Context context) {
        csdl = new DbHelper(context);
    }

    //Lấy tất cả sinh viên
    public List<SinhVien> TatCaSinhVien() {
        String sql = "SELECT * FROM SinhVien";
        List<SinhVien> sinhVienList = new ArrayList<SinhVien>();
        SQLiteDatabase database = csdl.getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int  masv = cursor.getInt(0);
            String hoten = cursor.getString(1);
            int gioitinh = cursor.getInt(2);
            String dienThoai = cursor.getString(3);
            String email = cursor.getString(4);
            SinhVien sv = new SinhVien(masv, hoten, gioitinh, dienThoai, email);
            sinhVienList.add(sv);
            cursor.moveToNext();
        }
        return  sinhVienList;
    }

    //Lấy 1 sinh viên

    //Thêm sinh viên
    public void ThemSinhVien(SinhVien sv){
        SQLiteDatabase database = csdl.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("HoTen", sv.getHoTen());
        values.put("GioiTinh", sv.getGioiTinh());
        values.put("DienThoai", sv.getDienThoai());
        values.put("Email", sv.getEmail());
        database.insert("SinhVien","",values);
    }

    //Cập nhật sinh viên

    //Xóa sinh viên

}
