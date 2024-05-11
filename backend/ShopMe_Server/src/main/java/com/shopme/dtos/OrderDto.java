package com.shopme.dtos;

import java.util.List;

public class OrderDto {

	private List<OrderItemsDto> orderItems;
	private double totalCost;

	public List<OrderItemsDto> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemsDto> orderItems) {
		this.orderItems = orderItems;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public OrderDto(List<OrderItemsDto> orderItems, double totalCost) {
		super();
		this.orderItems = orderItems;
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "[orderItems=" + orderItems + ", totalCost=" + totalCost + "]";
	}

	public OrderDto() {
		super();
	}

}
