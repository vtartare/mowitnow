package com.mowitnow.core.data;

import java.util.List;

import com.mowitnow.core.command.Order;
import com.mowitnow.core.context.MowerContext;

/**
 * 
 * 
 * 
 * @author "Vincent TARTARE"
 *
 */
public class Mower {
	
	private Cardinal cardinal;
	
	private int x;
	private int y;
	
	private int mowerId = -1;
	
	private List<Order> orders = null;	
	
	private MowerContext context;

	public int getMowerId() {
		return mowerId;
	}

	public void setMowerId(int mowerId) {
		this.mowerId = mowerId;
	}

	public Cardinal getCardinal() {
		return cardinal;
	}

	public void setCardinal(Cardinal cardinal) {
		this.cardinal = cardinal;
	}

	
	public MowerContext getContext() {
		return context;
	}

	public void setContext(MowerContext context) {
		this.context = context;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public boolean canMove(){
		return this.context.canMove(this);
	}
	
	public void move(){
		this.setX(this.getX() + this.getCardinal().getX());
		this.setY(this.getY() + this.getCardinal().getY());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
			.append(mowerId)
			.append(" ")
			.append("[")
			.append(this.getX())
			.append(",")
			.append(this.getY())
			.append("]")
			.append(" ")
			.append(this.getCardinal().toString());
		return builder.toString();
	}
	
	
	
}
