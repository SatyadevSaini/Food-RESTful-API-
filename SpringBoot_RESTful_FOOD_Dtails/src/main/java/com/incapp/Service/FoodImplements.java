package com.incapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.incapp.Dao.FoodDao;
import com.incapp.bean.Food;

@Service
public class FoodImplements implements Service01 {
	
	@Autowired 
	FoodDao dao;

	@Override
	public String addFood(Food f, MultipartFile image) {
	
		return dao.addFood(f, image);
	}

	@Override
	public List<Food> getAllFood() {
		
		return dao.getAllFood();
	}

	@Override
	public List<Food> getAllFoodLike(String name) {
		
		return dao.getAllFoodLike(name);
	}

	@Override
	public List<Integer> getIDsOnly() {
		
		return dao.getIDsOnly();
	}

	@Override
	public String deleteFood(int id) {
		
		return dao.deleteFood(id);
	}

	@Override
	public String updateFood(Food f, int id) {
		
		return dao.updateFood(f, id);
	}

	@Override
	public byte[] getImage(int id) {
		
		return dao.getImage(id);
	}

	@Override
	public String updateImage(int id, MultipartFile image) {
		
		return dao.updateImage(id, image);
	}

}
