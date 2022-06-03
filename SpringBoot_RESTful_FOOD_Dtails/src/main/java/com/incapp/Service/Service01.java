package com.incapp.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.incapp.bean.Food;

public interface Service01 {
   
	
	public String addFood(Food f , MultipartFile image);
	public List<Food> getAllFood();
	public List<Food> getAllFoodLike(String name);
	public List<Integer> getIDsOnly();
	public String deleteFood(int id );
	public String updateFood(Food f , int id );
	public byte[] getImage(int id);
	public String updateImage(int id , MultipartFile image);
	
	
}
