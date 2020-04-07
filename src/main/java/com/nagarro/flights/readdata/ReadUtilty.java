package com.nagarro.flights.readdata;

import java.io.*;
import java.util.*;

import com.nagarro.flights.flightmodel.FlightInfo;

/**
 * ReadUtility creates thread for each file and each thread adds the contents of
 * the file in flight_details
 * 
 * @author sanchitdwivedi
 *
 */
public class ReadUtilty {

	static ArrayList<FlightInfo> flight_details = new ArrayList<FlightInfo>();

	public ArrayList<FlightInfo> readCSV() {

		File directory = new File("C:\\Users\\sanchitdwivedi\\workspace3\\Flights\\src\\main\\resources");
		File[] files = directory.listFiles();

		if (files != null) {
			if (files.length == 0) {
				System.out.println("No files present");
				return null;
			}

			Thread[] threads = new Thread[files.length];

			int index = 0;
			for (File file : files) {

				if (file.isFile()) {
					threads[index] = new Thread(new AddFlights(file, flight_details));
					threads[index].start();
					index++;
				}

				// Callable<ArrayList<FlightInfo>> callable = new
				// AddFlights(file);

			}
			try {
				for (Thread thread : threads) {
					thread.join();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			// use Callable

			return flight_details;

		} else {
			System.out.println("No files");
			return null;
		}

	}

}
