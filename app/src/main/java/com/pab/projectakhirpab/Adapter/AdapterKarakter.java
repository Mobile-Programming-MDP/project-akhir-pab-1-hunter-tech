package com.pab.projectakhirpab.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pab.projectakhirpab.Activity.DetailActivity;
import com.pab.projectakhirpab.Model.KarakterModel;
import com.pab.projectakhirpab.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterKarakter extends RecyclerView.Adapter<AdapterKarakter.HolderData>{
    private List<KarakterModel> listKarakter = new ArrayList<>();
    public AdapterKarakter(List<KarakterModel>listKarakter){
        this.listKarakter = listKarakter;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_karakter,parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        KarakterModel KM = listKarakter.get(position);


        holder.tvName.setText(KM.getName());
        holder.tvSpecies.setText(KM.getSpecies());
        holder.tvStatus.setText(KM.getStatus());
        holder.tvGender.setText(KM.getGender());
        holder.tvTentang.setText(KM.getTentang());
        Glide.with(holder.itemView.getContext()).load(KM.getImage()).apply(new RequestOptions().override(330, 550)).into(holder.ivImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = listKarakter.get(holder.getAdapterPosition()).getName();
                String tentang = listKarakter.get(holder.getAdapterPosition()).getTentang();
                String image = listKarakter.get(holder.getAdapterPosition()).getImage();

                Intent kirim =new Intent(holder.itemView.getContext(), DetailActivity.class);
                kirim.putExtra("varName", name);
                kirim.putExtra("varTentang", tentang);
                kirim.putExtra("varImage", image);
                holder.itemView.getContext().startActivity(kirim
                );
                //Toast.makeText(holder.itemView.getContext(),"Nama : "+ KM.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listKarakter.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView tvName, tvSpecies, tvStatus, tvGender, tvTentang;
        ImageView ivImage;

        public HolderData(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvSpecies = itemView.findViewById(R.id.tv_species);
            tvStatus = itemView.findViewById(R.id.tv_status);
            tvGender = itemView.findViewById(R.id.tv_gender);
            tvTentang = itemView.findViewById(R.id.tv_tentang);
            ivImage = itemView.findViewById(R.id.iv_image);
        }
    }
}
