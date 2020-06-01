package com.hjl.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Area implements Serializable {
    private Integer areaId;

    private String areaCode;

    private String areaName;

    private String pcode;
}
