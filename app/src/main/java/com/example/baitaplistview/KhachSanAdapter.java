package com.example.baitaplistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class KhachSanAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private List<KhachSan> KhachSanList;

    public KhachSanAdapter(Context context, int layout, List<KhachSan> khachSanList) {
        this.context = context;
        this.layout = layout;
        KhachSanList = khachSanList;
    }

    @Override
    public int getCount() {
        return KhachSanList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);

        TextView txtTen = (TextView) view.findViewById(R.id.textviewTen);
        TextView txtMoTa = (TextView) view.findViewById(R.id.textviewMoTa);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imageviewHinh);

        KhachSan khachSan = KhachSanList.get(i);

        txtTen.setText(khachSan.getTen());
        txtMoTa.setText(KhachSan.getMoTa());
        imgHinh.setImageResource(KhachSan.getHinh());

        return view;
    }
}
