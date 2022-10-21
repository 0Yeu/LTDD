package com.example.profile_nguoidung;

import java.io.Serializable;

public class KhachSan implements Serializable {
    private  int Hinh;
    private String Ten;
    private String Sao;

    public KhachSan(int hinh, String ten, String sao) {
        Hinh = hinh;
        Ten = ten;
        Sao = sao;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getSao() {
        return Sao;
    }

    public void setSao(String sao) {
        Sao = sao;
    }
}
