package com.nagarro.flights.flightmodel;

/**
 * Data Structure that contains the flight details.
 * 
 * @author sanchitdwivedi
 *
 */
public class FlightInfo {
	private String flightNumber;
	private String departure;
	private String arrival;
	private String flightDate;
	private String flightTime;
	private float duration;
	private int fareRate;
	private String seatAvailability;
	private String flightClass;

	public FlightInfo(String departure, String arrival, String flightDate, String flightClass) {
		this.departure = departure;
		this.arrival = arrival;
		this.flightDate = flightDate;
		this.flightClass = flightClass;
	}

	public FlightInfo(String flightNumber, String departure, String arrival, String flightDate, String flightTime,
			float duration, int fareRate, String seatAvailability, String flightClass) {

		this.flightNumber = flightNumber;
		this.departure = departure;
		this.arrival = arrival;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.duration = duration;
		this.fareRate = fareRate;
		this.seatAvailability = seatAvailability;
		this.flightClass = flightClass;

	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public int getFareRate() {
		return fareRate;
	}

	public void setFareRate(int fareRate) {
		this.fareRate = fareRate;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	public String getSeatAvailability() {
		return seatAvailability;
	}

	public void setSeatAvailability(String seatAvailability) {
		this.seatAvailability = seatAvailability;
	}
}
