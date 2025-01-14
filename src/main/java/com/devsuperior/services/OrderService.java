package com.devsuperior.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devsuperior.entities.Order;

@Service
public class OrderService {
	
	@Autowired
	private ShippingService shippingService;
	
	public double discount(Order order) {
		return (order.getDiscount() * order.getBasic()) / 100;
		
	}
	
	public double total(Order order) {
		return shippingService.shipment(order) + (order.getBasic() - discount(order)) ;
	}
	
}
