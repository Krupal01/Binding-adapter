package com.example.bindingadapter.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bindingadapter.databinding.RowItemPhotolistBinding;
import com.example.bindingadapter.model.PhotoListItem;

public class PhotoListAdapter extends PagingDataAdapter<PhotoListItem,PhotoListAdapter.MyViewHolder> {

    private RowItemPhotolistBinding photolistBinding;
    public PhotoListAdapter(@NonNull DiffUtil.ItemCallback<PhotoListItem> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         photolistBinding = RowItemPhotolistBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false);
        return new MyViewHolder(photolistBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.setPhotoItem(getItem(position));
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RowItemPhotolistBinding binding;
        public MyViewHolder(RowItemPhotolistBinding photolistBinding) {
            super(photolistBinding.getRoot());
            this.binding = photolistBinding;
        }
    }
}
