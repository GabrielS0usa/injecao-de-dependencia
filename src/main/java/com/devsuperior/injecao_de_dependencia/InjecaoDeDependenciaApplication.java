package com.devsuperior.injecao_de_dependencia;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.devsuperior.entities.Order;
import com.devsuperior.services.OrderService;

@SpringBootApplication
@ComponentScan({"com.devsuperior"})
public class InjecaoDeDependenciaApplication implements CommandLineRunner{
	
	@Autowired
	private OrderService orderService;
	
	

	public static void main(String[] args) {
		SpringApplication.run(InjecaoDeDependenciaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Entre com o código do pedido: ");
		int cod = sc.nextInt();
		System.out.println("Entre com o valor do produto: ");
		double price = sc.nextDouble();
		System.out.println("Entre com o valor do disconto: ");
		double discount = sc.nextDouble();
		
		Order oder = new Order(cod, price, discount);
		
		System.out.printf("Pedido código: %d%n", cod);
		System.out.printf("Valor total: %.2f%n", orderService.total(oder));
		
		
		
		
		sc.close();
	}
	
	

}
