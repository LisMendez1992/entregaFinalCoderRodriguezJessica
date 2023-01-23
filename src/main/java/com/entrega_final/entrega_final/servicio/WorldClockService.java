package com.entrega_final.entrega_final.servicio;

import com.entrega_final.entrega_final.entidades.WorldClock;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class WorldClockService {



    public ZonedDateTime getCurrentDateTime() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-dd");
        RestTemplate restTemplate = new RestTemplate();
        WorldClockService worldClockService = new WorldClockService();
        final String url = "http://worldclockapi.com/api/json/utc/now";
        ZonedDateTime currentDate= null;
        try{
            WorldClock worldClock = restTemplate.getForObject(url, WorldClock.class);
             currentDate = ZonedDateTime.parse(worldClock.getCurrentDateTime());
             System.out.println(currentDate);
        }catch (Exception e){
            e.printStackTrace();
            currentDate = ZonedDateTime.now();
       }


   return currentDate;
    }
}
