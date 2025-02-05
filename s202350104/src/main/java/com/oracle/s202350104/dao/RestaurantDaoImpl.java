package com.oracle.s202350104.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.s202350104.model.Restaurants;
import com.oracle.s202350104.model.RestaurantsContent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RestaurantDaoImpl implements RestaurantDao {
	
	private final SqlSession session;

	@Override
	public List<Restaurants> listRestaurant() {
		List<Restaurants> restaurantList = null;
		log.info("RestaurantImpl listRestaurant Start...");
		
		try {
			restaurantList = session.selectList("joRestaurantListAll");
			log.info("RestaurantDaoImpl listRestaurant restaurantList.size()->" + restaurantList.size());
		} catch (Exception e) {
			log.info("RestaurantDaoImpl listRestaurant e.getMessage()->" + e.getMessage());
		}
		return restaurantList;
	}

	@Override
	public RestaurantsContent detailRestaurant(int content_id) {
		RestaurantsContent restaurant = new RestaurantsContent();
		
		try {
			restaurant = session.selectOne("joRestaurantDetail", content_id);
			log.info("RestaurantsContent detailRestaurant() restaurant.getTitle ->" + restaurant.getTitle());
					
		} catch (Exception e) {
			log.info("RestaurantsContent detailRestaurant() ->" + e.getMessage());
		}
		return restaurant;
	}
	
}
