package com.example.profile_nguoidung;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KhachSanAdapter extends RecyclerView.Adapter<KhachSanAdapter.KhachSanViewHolder>{

    private List<KhachSan> mListKhachSan;
    private Context mcontext;

    public KhachSanAdapter(Context context, List<KhachSan> mListKhachSan) {
        this.mcontext = context;
        this.mListKhachSan = mListKhachSan;
    }

    public void setData(List<KhachSan> list){
                this.mListKhachSan = list;
                notifyDataSetChanged();
    }

    @NonNull
    @Override
    public KhachSanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_khachsan, parent, false);
        return new KhachSanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KhachSanViewHolder holder, int position) {
        KhachSan khachSan = mListKhachSan.get(position);
        if(khachSan == null){
            return;
        }
        holder.img_hotel.setImageResource(khachSan.getHinh());
        holder.tv_hotel.setText(khachSan.getTen());
        holder.tv_star.setText(khachSan.getSao());

        holder.layout_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(khachSan);
            }
        });
    }

    public void onClickGoToDetail (KhachSan khachSan) {
        Intent intent = new Intent(mcontext, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Object_user", khachSan);
        intent.putExtras(bundle);
        mcontext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if (mListKhachSan != null){
            return mListKhachSan.size();
        }
        return 0;
    }

    public class  KhachSanViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_hotel;
        private TextView tv_hotel, tv_star;
        private RelativeLayout layout_item;

        public KhachSanViewHolder(@NonNull View itemView) {
            super(itemView);

            layout_item = itemView.findViewById(R.id.layout_item);
            img_hotel = itemView.findViewById(R.id.img_hotel);
            tv_hotel = itemView.findViewById(R.id.tv_hotel);
            tv_star = itemView.findViewById(R.id.tv_star);


        }
    }
}
