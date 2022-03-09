package com.example.bindingadapter.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.rxjava3.PagingRx;

import com.example.bindingadapter.data.PagingDataSource;
import com.example.bindingadapter.model.PhotoListItem;

import io.reactivex.rxjava3.core.Flowable;
import kotlinx.coroutines.CoroutineScope;

public class MainViewModel extends ViewModel {

    public Flowable<PagingData<PhotoListItem>> flowable;
    public PagingDataSource pagingDataSource;
    public Pager<Integer,PhotoListItem> pager;

    public void init(){
        pagingDataSource = new PagingDataSource();

        pager = new Pager(
                new PagingConfig(50,5,false,50,50*20),
                ()->pagingDataSource
        );
        flowable = PagingRx.getFlowable(pager);
        CoroutineScope coroutineScope = ViewModelKt.getViewModelScope(this);
        PagingRx.cachedIn(flowable,coroutineScope);

    }

}
