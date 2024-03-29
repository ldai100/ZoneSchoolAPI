package com.yfcld.ZoneSchoolAPI.service;

import com.yfcld.ZoneSchoolAPI.object.School;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataExtractService {

    public List<School> getDataExtract(String htmlString){

        Document doc = Jsoup.parse(htmlString);
        Elements elements = doc.body().getElementsByClass("featured-item");

        List<School> zonedSchools = new ArrayList<>();

        for(Element e : elements){
            School tempSchool = new School();
            tempSchool.setName(e.attr("data-name"));
            String tempAddress = e.select("div > div > div > p").toString();
            tempAddress= tempAddress.replaceAll("</*[a-zA-Z]+>","");
            tempAddress = tempAddress.substring(0,tempAddress.lastIndexOf(' '));
            tempSchool.setAddress(tempAddress);
            zonedSchools.add(tempSchool);
        }
        return zonedSchools;
    }

}
