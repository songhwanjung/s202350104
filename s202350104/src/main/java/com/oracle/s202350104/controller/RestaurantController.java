package com.oracle.s202350104.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.oracle.s202350104.model.Restaurants;
import com.oracle.s202350104.model.RestaurantsContent;
import com.oracle.s202350104.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Controller
@RequiredArgsConstructor
@Slf4j
public class RestaurantController {
	private final RestaurantService rs;
	
	@GetMapping(value = "/restaurant")
	public String restaurant(Model model) {
		UUID transactionId = UUID.randomUUID();
		try {
			log.info("[{}]{}:{}", transactionId, "restaurant", "start");
			List<Restaurants> listRestaurant = rs.listRestaurant();
			model.addAttribute("listRestaurant", listRestaurant);
		} catch (Exception e) {
			log.error("[{}]{}:{}", transactionId, "restaurant", e.getMessage());
		} finally {
			log.info("[{}]{}:{}", transactionId, "restaurant", "end");
		}
					
		return "restaurant/restaurantList";
	}
	
	
	@GetMapping(value= "/restaurant/detail")
	public String restuarntDetail(int content_id, Model model) {
		log.info("RestaurantController detailRestaurant Start...");
		
		RestaurantsContent restaurant = rs.detailRestaurant(content_id);
		
		model.addAttribute("content_id", content_id);
		model.addAttribute("restaurant", restaurant);
		
		return "restaurant/restaurantDetail";
	}
	
	
}
