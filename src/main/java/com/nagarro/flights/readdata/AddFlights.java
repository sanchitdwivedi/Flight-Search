package com.nagarro.flights.readdata;

import java.io.*;
import java.util.*;

import com.nagarro.flights.flightmodel.FlightInfo;

/**
 * Adds contents of CSV files in flight_details
 * 
 * @author sanchitdwivedi
 *
 */
public class AddFlights implements Runnable {

	ArrayList<FlightInfo> flight_details;
	File file;

	AddFlights(File file, ArrayList<FlightInfo> flight_details) {
		this.file = file;
		this.flight_details = flight_details;
	}

	public void add(File file, ArrayList<FlightInfo> flight_details) {
		try {

			ArrayList<String> tokens = new ArrayList<String>();
			Scanner scan = new Scanner(file);

			while (scan.hasNext()) {

				String line = scan.nextLine().toUpperCase().toString();

				if (!line.isEmpty()) {

					StringTokenizer token = new StringTokenizer(line, "|");

					tokens = new ArrayList<String>();

					while (token.hasMoreTokens()) {
						tokens.add(token.nextToken());
					}

					if (!tokens.get(1).equals("DEP_LOC")) {
						FlightInfo flight = new FlightInfo(tokens.get(0), tokens.get(1), tokens.get(2), tokens.get(3),
								tokens.get(4), Float.parseFloat(tokens.get(5)), Integer.parseInt(tokens.get(6)),
								tokens.get(7), tokens.get(8));

						if (flight != null) {
							flight_details.add(flight);
						}

					}
				}
			}
			flight_details.remove(null);
			scan.close();

		} catch (FileNotFoundException e) {
			System.out.println("No file exists");
		}

	}

	public void run() {
		add(file, flight_details);
	}

}
