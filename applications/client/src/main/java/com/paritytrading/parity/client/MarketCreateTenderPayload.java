package com.paritytrading.parity.client;

import java.time.Duration;
import java.time.Instant;

/*
 * Sent by the LME to the Market with information to be
 * mapped and inserted in the market engine
 * 
 * Information is from an EiCreateTenderPayload received from the LMA
 * and used as contructor parameters by the LME Actor.
 */

public class MarketCreateTenderPayload {
	
	protected String info = "MarketCreateTenderPayload";
	protected SideType side;
	protected long quantity;
	protected long price;
	protected long ctsTenderId;
	protected Instant expireTime;

	MarketCreateTenderPayload(SideType side, long quantity, long price, long ctsTenderId, Instant expireTime)	{
		/*
		 * Ensure that the number of decimal fraction digits
		 * in price and quantity align with the global one which is presently 3
		 * 
		 * This converts from the external price, e.g. one dollar is 1000L
		 */
		this.side = side;
		this.quantity = quantity;
		this.price = price;
//		System.err.println(this.toString());
	}
	
	@Override
	public String toString()	{
		SideType tempSide = this.side;
		String tempString;	

	tempString = (tempSide == SideType.BUY)? "B" : "S";
		
		return (info + " side " + tempString + " quantity " +
				quantity + " price " + price);
	}

	public Instant getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Instant expireTime) {
		this.expireTime = expireTime;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public SideType getSide() {
		return side;
	}

	public void setSide(SideType side) {
		this.side = side;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getCtsTenderId() {
		return ctsTenderId;
	}

	public void setCtsTenderId(long ctsTenderId) {
		this.ctsTenderId = ctsTenderId;
	}	
}