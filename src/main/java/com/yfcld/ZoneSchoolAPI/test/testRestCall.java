package com.yfcld.ZoneSchoolAPI.test;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yfcld.ZoneSchoolAPI.object.School;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class testRestCall {

    public static void main(String[] args) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        //System.out.println(o);



        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_HTML));

        restTemplate.getMessageConverters().add(converter);


/*
        String str= "{\"queryState\":{\"mapBounds\":{\"west\":-74.51425813819935,\"east\":-73.1484578618007,\"south\":40.446085602343516,\"north\":40.89586136649694}},\"usersSearchTerm\":\"queens new york\"}";
*/
        String res = restTemplate.getForObject("https://www.schools.nyc.gov/find-a-school?address=1654+65th+street%2C+brooklyn&sort=nearest&ShowZonedSchools=1&ShowCurrentYear=1&mpp=36&school_borough=&pg=1&grade_levels=", String.class);

        //System.out.println(res);

        Document doc = Jsoup.parse(res);


        //System.out.println(doc.body());


/*        for(int i =0; i < 10; i++){
            System.out.println("############################################");
            //child 3
            System.out.println(doc.body().child(i));
            System.out.println("############################################");
        }*/

        /*System.out.println(doc.body().getElementsByClass("featured-item"));
        */
        Elements elements = doc.body().getElementsByClass("featured-item");

        System.out.println(elements.size());

        List<School> zonedSchools = new ArrayList<>();

        for(Element e : elements){
            School tempSchool = new School();
            tempSchool.setName(e.attr("data-name"));
            //System.out.println(e.getElementsByAttributeValueContaining("strong","Address"));
            String tempAddress = e.select("div > div > div > p").toString();
            tempAddress= tempAddress.replaceAll("</*[a-zA-Z]+>","");
            tempAddress = tempAddress.substring(0,tempAddress.lastIndexOf(' '));
            System.out.println(tempAddress);
            tempSchool.setAddress(tempAddress);
            zonedSchools.add(tempSchool);
        }


        //ZillowExtract zillowExtract = new ObjectMapper().readValue(str,ZillowExtract.class);
        //System.out.println(zillowExtract);
    }

}
