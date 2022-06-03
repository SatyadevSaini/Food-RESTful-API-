package com.incapp.RestController;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.incapp.Service.Service01;
import com.incapp.bean.Food;

@RestController
public class MyRestController1 {
  
	@Autowired 
	Service01 service;
	
	@PostMapping(value ="/addFood") 
		public String addFood(@RequestPart ("Food") Food f ,@RequestPart("image")  MultipartFile image) {
			
			String add = service.addFood(f, image);
             
			return add;
		}
	
	
	@GetMapping(value ="/getAllFood")
		public List<Food> getAllFood() {
		
		List<Food> allFood = service.getAllFood();
		
			return allFood;
		}
	
	@GetMapping(value ="/getFoodLike/{name}")
        public List<Food> getAllFoodLike(@PathVariable String name) {
		
		List<Food> allFood = service.getAllFoodLike(name);
		
			return allFood;
		}
	
	@GetMapping(value ="/getIDs")
	public List<Integer> getIds(){
		
		List<Integer> ids = service.getIDsOnly();
		return ids;
	}
	
	@DeleteMapping(value ="/delete/{id}")
	public String delete(@PathVariable int id) {
		
		String delete = service.deleteFood(id);
		return delete;
	}
	
	@PutMapping("/update/{id}")
	public String update( @PathVariable ("id") int id , @RequestBody Food f ) {
		
		String update = service.updateFood(f, id);
		return update;
		
	}
	
	
	@GetMapping("/getImage/{id}")
	public byte[] getImage(@PathVariable ("id") int id) {
		
		byte [] img = service.getImage(id);
		return img;
		
	}
	
	
	@PutMapping("/updateImage")
	public String updateImage(@RequestPart("id") int id,@RequestPart("image") MultipartFile image)  {
		
		String imgupdate = service.updateImage(id, image);
				
		return imgupdate;
	}
	
	
	
	
	
	















}
	
	
	
	
	
	

