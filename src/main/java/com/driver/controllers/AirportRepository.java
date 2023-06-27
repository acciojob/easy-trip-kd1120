package com.driver.controllers;

import com.driver.model.Airport;

import com.driver.model.City;
import com.driver.model.Flight;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Repository
public class AirportRepository {

    public String getLargestAirportName;
    HashSet<Airport> airports = new HashSet<>();
    HashMap<String, Integer> airTermi = new HashMap<>();
    HashSet<Flight> flightHashSet = new HashSet<>();



    public void addAirport(Airport airport){
        if(!airports.contains(airport)){
            //return "Already exist";

            airports.add(airport);
            airTermi.put(airport.getAirportName(),airport.getNoOfTerminals());
        }

    }
    public String getLargestAirportName(){
       // Airport max  = new Airport();
       // if(airport.getNoOfTerminals()>)

 //int m =0;
//        for(Airport airport: airports){
//            if(airport.getNoOfTerminals()>m){
//                m = airport.getNoOfTerminals();
//
//            }
//            m  = Math.max(m, airport.getNoOfTerminals());
//
//        }

//        for(Map.Entry<String,Integer> entry: airTermi.entrySet()){
//            if(entry.getValue()>m){
//                m  = entry.getValue();
//
//            }
//
//            m = Math.max(m,entry.getValue() );
//        }
//        String key="";
//        for (Map.Entry<String, Integer> entry : airTermi.entrySet()) {
//            if (entry.getValue() == m) {
//                key = entry.getKey();
//                break;
//            }
//        }
//        return key;

                String largestAirportName = null;
                int maxTerminals = Integer.MIN_VALUE;

                for (Map.Entry<String, Integer> entry : airTermi.entrySet()) {
                    String airportName = entry.getKey();
                    int numTerminals = entry.getValue();

                    if (numTerminals > maxTerminals) {
                        largestAirportName = airportName;
                        maxTerminals = numTerminals;
//                    } else if (numTerminals == maxTerminals && airportName.compareTo(largestAirportName) < 0) {
//                        // If there's a tie, update largestAirportName to the lexicographically smaller airport name
//                        largestAirportName = airportName;
//                    }
                    }


                }
        return largestAirportName;
    }

    public void getShortest(City from, City to) {



    }

    public void addFlight(Flight flight) {
 if(!flightHashSet.contains(flight)){
     flightHashSet.add(flight);
 }
    }
}
