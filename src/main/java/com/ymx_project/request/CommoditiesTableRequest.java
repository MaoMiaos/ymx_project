package com.ymx_project.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CommoditiesTableRequest {

    @JsonProperty(value = "ASIN")
    private String ASIN;
    @JsonProperty(value = "brand")
    private String brand;
    @JsonProperty(value = "ASIN_link")
    private String ASIN_link;
    @JsonProperty(value = "goods_count")
    private String goods_count;
    @JsonProperty(value = "price")
    private String price;
    @JsonProperty(value = "height")
    private String height;
    @JsonProperty(value = "FBA_value")
    private String FBA_value;
    @JsonProperty(value = "picture_link")
    private String pic_link;
    @JsonProperty(value = "caigou_price")
    private String caigou_price;
    @JsonProperty(value = "caigou_link")
    private String caigou_link;
    @JsonProperty(value = "caigou_count")
    private String caigou_count;
    @JsonProperty(value = "huilv")
    private String huilv;
    @JsonProperty(value = "type")
    private String type;
    @JsonProperty(value = "userId")
    private String User_id;

    private Date CreateData;
}

