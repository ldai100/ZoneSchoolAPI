package com.yfcld.ZoneSchoolAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yfcld.ZoneSchoolAPI.object.School;

@RestController
public class AddressReceiver {

    @GetMapping("/zoneSchool")
    public String zoneSchools(String address) {
        return address;
    }
}
