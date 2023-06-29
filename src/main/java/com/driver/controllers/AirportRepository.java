package com.driver.controllers;

import com.driver.model.Airport;

import com.driver.model.City;
import com.driver.model.Flight;
import com.driver.model.Passenger;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class AirportRepository {


//    public String getLargestAirportName;
//    HashSet<Airport> airports = new HashSet<>();
//    HashMap<String, Integer> airTermi = new HashMap<>();
//    HashSet<Flight> flightHashSet = new HashSet<>();
//
//    HashSet<Passenger> passengerHashSet = new HashSet<>();
//
private TreeMap<String,Airport> airportMap= new TreeMap<>();
    private HashMap<Integer,Flight> flightMap= new HashMap<>();
    private HashMap<Integer,Passenger> passengerMap= new HashMap<>();
    private HashMap<Integer,Set<Integer>> flightPassMap= new HashMap<>();
    private HashMap<Integer,Integer> revenueMap= new HashMap<>();
    private HashMap<Integer,Integer> paymentMap= new HashMap<>();


    public void addAirport(Airport airport){
        if(!airportMap.containsKey(airport.getAirportName())){
            //return "Already exist";

            airportMap.put(airport.getAirportName(),airport);
            //airTermi.put(airport.getAirportName(),airport.getNoOfTerminals());
        }

    }

    public String getLargestAirportName(){

        String result = "";
        int ans =0;
        for(String name:airportMap.keySet()){
            int ter = airportMap.get(name).getNoOfTerminals();

            if(ter>ans){
                ans = ter;
                result = name;
            }
        }
        return result;

                }

    public double getShortest(City from, City to) {

        double duration = Integer.MAX_VALUE;
        for(Flight flight:flightMap.values()){
            if(from.equals(flight.getFromCity()) && to.equals(flight.getToCity())){
                if(duration>flight.getDuration()){
                    duration  = flight.getDuration();
                }
            }

        }


        return duration == Integer.MAX_VALUE?-1 : duration;
    }

    public void addFlight(Flight flight) {
 if(!flightMap.containsKey(flight.getFlightId())){
     flightMap.put(flight.getFlightId(),flight);
 }
    }

    public void addPassenger(Passenger passenger) {
        if(!passengerMap.containsKey(passenger.getPassengerId())){
            passengerMap.put(passenger.getPassengerId(), passenger);
        }
    }

    public String bookATicket(Integer flightId, Integer passengerId) {
        Flight flight = flightMap.get(flightId);
        int maxCapacity = flight.getMaxCapacity();
        Set<Integer> list = new HashSet<>();
        if(flightPassMap.containsKey(flightId)){
            list = flightPassMap.get(flightId);
        }
        int capacity = list.size();
        if(capacity == maxCapacity) return "FAILURE";
        int fare = calculateFare(flightId);
        paymentMap.put(passengerId,fare);
        fare+= revenueMap.getOrDefault(flightId,0);
        revenueMap.put(flightId,fare);
        list.add(passengerId);
        flightPassMap.put(flightId,list);
        return "SUCCESS";

    }

    public int calculateFare(Integer flightId) {
        int fare=3000;
        int alreadyBooked=0;
        if(flightPassMap.containsKey(flightId))
            alreadyBooked=flightPassMap.get(flightId).size();
        return (fare+(alreadyBooked*50));
    }

    public int getNumberOfPeople(Date date, String airportName) {

        Airport airport = airportMap.get(airportName);
        int c =0;
        if(airport !=null){
            City city = airport.getCity();
            for(Flight flight : flightMap.values()){
                if(date.equals(flight.getFlightDate())){
                    if(city.equals(flight.getToCity()) || city.equals(flight.getFromCity())){
                        int flightId = flight.getFlightId();
                        Set<Integer>    list = flightPassMap.get(flightId);
                        if(list!=null){
                            c+= list.size();
                        }
                    }
                }
            }
        }
        return c;
    }
}
