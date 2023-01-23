package com.entrega_final.entrega_final.entidades;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WorldClock {



        private String id;
        private String currentDateTime;
        private String utcOffset;
        private Boolean isDayLightSavingsTime;
        private String dayOfTheWeek;
        private String timeZoneName;
        private Long currentFileTime;
        private String ordinalDate;
        private String serviceResponse;
}
