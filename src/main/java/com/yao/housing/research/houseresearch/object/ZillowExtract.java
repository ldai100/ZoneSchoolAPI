package com.yao.housing.research.houseresearch.object;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown =  true)
@Data
public class ZillowExtract {

    private String usersSearchTerm;


}
