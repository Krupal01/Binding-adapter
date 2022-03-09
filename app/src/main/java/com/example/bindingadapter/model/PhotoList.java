package com.example.bindingadapter.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PhotoList{

	@SerializedName("PhotoList")
	private List<PhotoListItem> photoList;

	public List<PhotoListItem> getPhotoList(){
		return photoList;
	}
}