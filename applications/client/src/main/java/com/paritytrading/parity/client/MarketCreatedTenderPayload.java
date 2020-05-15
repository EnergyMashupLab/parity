package com.paritytrading.parity.client;

/*
 * Sent by Market responding to MarketCreateTender from LME.
 * 
 * Includes CtsTenderId as a correlation ID
 */

public class MarketCreatedTenderPayload {
	long ctsTenderId;
	public Boolean success = false;	// Ensure set properly
	private String info = "ClientCreatedTenderPayload";
	private String parityOrderId;	// debug. Mapping in CtsBridge
	
	public String getParityOrderId() {
		return parityOrderId;
	}

	public void setParityOrderId(String parityOrderId) {
		this.parityOrderId = parityOrderId;
	}

	MarketCreatedTenderPayload(){
		success = true;
	}
	
	MarketCreatedTenderPayload(long id){
		ctsTenderId = id;
		this.success = true;
	}
	
	MarketCreatedTenderPayload(long ctsTenderId, String parityOrderId)	{
		this.ctsTenderId = ctsTenderId;
		this.parityOrderId = parityOrderId;
		this.success = true;
	}
	
	@Override
	public String toString()	{
		return (info + " success is " + success.toString() +
				" CtsTenderId " + Long.toString(ctsTenderId));
	}

	public long getCtsTenderId() {
		return ctsTenderId;
	}

	public void setCtsTenderId(long ctsTenderId) {
		this.ctsTenderId = ctsTenderId;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}