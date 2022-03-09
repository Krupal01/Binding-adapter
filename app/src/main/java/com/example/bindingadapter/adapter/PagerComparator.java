package com.example.bindingadapter.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.bindingadapter.model.PhotoListItem;

public class PagerComparator extends DiffUtil.ItemCallback<PhotoListItem> {

    @Override
    public boolean areItemsTheSame(@NonNull PhotoListItem oldItem, @NonNull PhotoListItem newItem) {
        return oldItem.getId()== newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull PhotoListItem oldItem, @NonNull PhotoListItem newItem) {
        return oldItem.getTitle().equals(newItem.getTitle());
    }
}
