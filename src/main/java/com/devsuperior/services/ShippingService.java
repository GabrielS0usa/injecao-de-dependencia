package com.devsuperior.services;

import org.springframework.stereotype.Service;
import com.devsuperior.entities.Order;

@Service
public class ShippingService {
	
	public double shipment(Order order) {
		double amount = order.getBasic();
		
		if (amount < 100) {
			return 20;
		} else if (amount >= 100 && amount < 200) {
			return 12;
		} else {
			return 0;
		}
	}
	
}
