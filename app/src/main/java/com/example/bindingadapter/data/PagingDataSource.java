package com.example.bindingadapter.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import androidx.paging.rxjava3.RxPagingSource;

import com.example.bindingadapter.model.PhotoList;
import com.example.bindingadapter.model.PhotoListItem;
import com.example.bindingadapter.network.RetroInstance;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class PagingDataSource extends RxPagingSource<Integer, PhotoListItem> {
    @Nullable
    @Override
    public Integer getRefreshKey(@NonNull PagingState<Integer, PhotoListItem> pagingState) {
        return 0;
    }

    @NonNull
    @Override
    public Single<LoadResult<Integer, PhotoListItem>> loadSingle(@NonNull LoadParams<Integer> loadParams) {
        try{
            int albumId = loadParams.getKey() != null ? loadParams.getKey():1;
            return new RetroInstance().getAlbumService()
                    .getPhotoList(albumId)
                    .map(photoListItem -> toLoadResult(albumId,photoListItem))
                    .onErrorReturn(LoadResult.Error::new);

        }catch (Exception e){
            return Single.just(new LoadResult.Error<>(e));
        }
    }

    private LoadResult<Integer, PhotoListItem> toLoadResult(int albumId, List<PhotoListItem> photoListItem) {
        return new LoadResult.Page<Integer, PhotoListItem>(
                    photoListItem,
                    albumId ==1 ? null : albumId-1,
                    albumId == 20 ? null : albumId+1,
                    LoadResult.Page.COUNT_UNDEFINED,
                    LoadResult.Page.COUNT_UNDEFINED
                );
    }

}
