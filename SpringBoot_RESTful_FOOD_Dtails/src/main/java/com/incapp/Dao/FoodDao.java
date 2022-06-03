package com.incapp.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.incapp.bean.Food;

@Repository
public class FoodDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	//add Food 
	public String addFood(Food f , MultipartFile image) {
		
		try {
			String query = "insert into food values(?,?,?,?)";
			
			int x = jdbcTemplate.update(query, new Object[] {f.getId() , f.getName() , f.getPrice() , image.getInputStream() });
			if(x==0) {
				return"failed";
			}
			else {
				return"success";
			}
			
		} catch (Exception e) {
			return "failed";
		}
	}
	
	
	//getFood 
	public List<Food> getAllFood(){
		
		class DataMapper implements RowMapper {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				 Food f = new Food();
				 f.setId(rs.getInt("id"));
				 f.setName(rs.getString("name"));
				 f.setPrice(rs.getInt("price"));
				 
				return f;
			}
		}
		
		try { 
			String query = "select * from food";
			List<Food> data = jdbcTemplate.query(query, new DataMapper());
			return data;
			
		} catch (Exception e) {
			return null;
		}	
	}
	
	
	
	
	//like Query Food 
		public List<Food> getAllFoodLike(String name){
			
			class DataMapper implements RowMapper {

				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					 Food f = new Food();
					 f.setId(rs.getInt("id"));
					 f.setName(rs.getString("name"));
					 f.setPrice(rs.getInt("price"));
					 
					return f;
				}
			}
			
			try { 
				String query = "select * from food where name like ?";
				List<Food> data = jdbcTemplate.query(query, new DataMapper() , new Object[] {"%"+name+"%"} );
				return data;
				
			} catch (Exception e) {
				return null;
			}	
		}
		
		
		
		// getId  Only
		
          public List<Integer> getIDsOnly(){
			
			class DataMapper implements RowMapper {

				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				
					return rs.getInt("id");
				}
			}
			
			try { 
				String query = "select id from food";
				List<Integer> id = jdbcTemplate.query(query, new DataMapper()  );
				return id;
				
			} catch (Exception e) {
				return null;
			}	
		}
          
          
          //delete Food 
          
          public String deleteFood(int id ) {
        	  
        	  try {
        		  String query = "delete from food where id =?";
				
        		  int x = jdbcTemplate.update(query , new Object[] {id});
        		  
        		  if(x==0) {
      				return"failed";
      			}
      			else {
      				return"success";
      			}
			} catch (Exception e) {
				
				return"failed";
			}  
          }
          
          
          
          //update Food 
          public String updateFood(Food f , int id ) {
        	  
        	  try {
        		  String query = "update food set id=? , name=? , price=? where id=? ";
        		  int x = jdbcTemplate.update(query , new Object[] {f.getId() , f.getName() , f.getPrice(),f.getId()});
        		  
        		  if(x==0) {
        				return"failed";
        			}
        			else {
        				return"success";
        			}
				
			} catch (Exception e) {
				e.printStackTrace();
				return"failed";
			}  
          }
          
          
          //getImage
          public byte[] getImage(int id) {
        	  
        	  class DataMapper implements RowMapper{

				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					
					return rs.getBytes("image");
				}
        	  }
        	  try {
        		  String query = "select image from food where id =?";
        		  
        		  byte[] image = (byte[]) jdbcTemplate.queryForObject(query, new DataMapper() , new Object[] {id});
        		  
        		  return image;
			} catch (Exception e) {
				return null;
			}
        	  
          }
          
          
          
          
          
          //update image 
          public String updateImage(int id , MultipartFile image) {
        	  
        	  try {
        		  String query = "update food set image=? where id=?";
        		  
        		  int x = jdbcTemplate.update(query , new Object[] {image.getInputStream() ,id}); 
        		  if(x==0) {
      				return"failed";
      			}
      			else {
      				return"success";
      			}
				
			} catch (Exception e) {
				return"failed";
			}
        	  
        	  
          }
          
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
