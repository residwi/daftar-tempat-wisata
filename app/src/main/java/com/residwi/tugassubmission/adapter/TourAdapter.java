package com.residwi.tugassubmission.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.residwi.tugassubmission.R;
import com.residwi.tugassubmission.model.Tour;

import java.util.ArrayList;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.ListViewHolder> {

    private ArrayList<Tour> listTour;
    public TourAdapter(ArrayList<Tour> list) {
        this.listTour = list;
    }
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_tour, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Tour tour = listTour.get(position);
        Glide.with(holder.itemView.getContext())
                .load(tour.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(tour.getName());
        holder.tvDetail.setText(tour.getDetail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listTour.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTour.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.item_photo_tour);
            tvName = itemView.findViewById(R.id.item_name_tour);
            tvDetail = itemView.findViewById(R.id.item_detail_tour);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Tour data);
    }
}