package com.yfcld.ZoneSchoolAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yfcld.ZoneSchoolAPI.object.School;
import org.springframework.web.client.RestTemplate;

@RestController
public class AddressReceiver {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/zoneSchool")
    public String zoneSchools(String address) {

        return restTemplate.getForObject("https://www.schools.nyc.gov/find-a-school?address=" + address
                + "&sort=nearest&ShowZonedSchools=1&ShowCurrentYear=1&mpp=36&school_borough=&pg=1&grade_levels=",
                String.class);
    }
}