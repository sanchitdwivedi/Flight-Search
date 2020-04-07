package com.nagarro.flights.findflights;

import java.text.*;
import java.util.*;

import com.nagarro.flights.flightmodel.*;
import com.nagarro.flights.readdata.FlightClass;

/**
 * Searches for the flights and creates a hashmap to create a record for the
 * matching flights
 * 
 * @author sanchitdwivedi
 *
 */
public class SearchUtility {

	public void searchForFlights(FlightInfo inputFlight, ArrayList<FlightInfo> flight_details,
			HashMap<FlightInfo, Integer> avail_flights) {

		DateFormat sdformat = new SimpleDateFormat("dd-mm-yyyy");

		try {
			Date d1 = sdformat.parse(inputFlight.getFlightDate());
			for (FlightInfo flight : flight_details) {

				Date d2 = sdformat.parse(flight.getFlightDate());

				if (inputFlight.getDeparture().equals(flight.getDeparture())
						&& inputFlight.getArrival().equals(flight.getArrival())
						&& flight.getFlightClass().contains(inputFlight.getFlightClass()) && d1.compareTo(d2) <= 0) {

					if (inputFlight.getFlightClass().equals(FlightClass.B.toString())) {
						flight.setFlightClass("B");
					}

					avail_flights.put(flight, 1);

				} else {
					avail_flights.put(flight, 0);
				}
			}
		} catch (ParseException e) {
			System.out.println("Wrong date");
		}
	}
}
