package com.example.bindingadapter.bindingAdapters;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.example.bindingadapter.R;
import com.example.bindingadapter.model.PhotoListItem;
import com.example.bindingadapter.ui.MainActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ImageBindingAdapter {

    @BindingAdapter("android:imageUrl")
    public static void loadImageByUrl(ImageView view ,String url){
        Picasso.get().load(url)
                .fit()
                .error(R.drawable.ic_launcher_background)
                .into(view, new Callback() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(view.getContext(),"sucess",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(view.getContext(),e.toString(),Toast.LENGTH_LONG).show();
                    }
                }); //http 503 error : service unavailable
    }
}
