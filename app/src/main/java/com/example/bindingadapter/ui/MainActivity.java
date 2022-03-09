package com.example.bindingadapter.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.bindingadapter.R;
import com.example.bindingadapter.adapter.PagerComparator;
import com.example.bindingadapter.adapter.PhotoListAdapter;
import com.example.bindingadapter.databinding.ActivityMainBinding;
import com.example.bindingadapter.utils.Constants;
import com.example.bindingadapter.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PhotoListAdapter adapter;
    private MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        PagerComparator comparator = new PagerComparator();
        adapter = new PhotoListAdapter(comparator);

        viewModel.init();

        viewModel.flowable.subscribe(
                photoListItemPagingData -> {
                    adapter.submitData(getLifecycle(),photoListItemPagingData);
                },
                throwable -> {
                    Log.i(Constants.TAG,throwable.getMessage());
                });

        binding.rcvPhotoList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.rcvPhotoList.setAdapter(adapter);
    }
}