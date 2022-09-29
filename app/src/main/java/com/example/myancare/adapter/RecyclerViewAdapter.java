package com.example.myancare.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myancare.R;
import com.example.myancare.model.ItemInfo;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private List<ItemInfo> infoList;
    public void setData(List<ItemInfo> infoList){
        this.infoList=infoList;
    }
    @NonNull
    @NotNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate( R.layout.datarow,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(infoList.get(position).getName());
        holder.tvTagline.setText(infoList.get(position).getTagline());
        holder.tvDescription.setText(infoList.get(position).getDescription());
        Glide.with(holder.imageView).load(infoList.get(position).getImage_url()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        if(infoList==null){
            return 0;
        }
        else {
            return infoList.size();
        }

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvName,tvTagline,tvDescription;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview);
            tvName=itemView.findViewById(R.id.tvName);
            tvTagline=itemView.findViewById(R.id.tvTagline);
            tvDescription=itemView.findViewById(R.id.tvDescription);
        }
    }
}
