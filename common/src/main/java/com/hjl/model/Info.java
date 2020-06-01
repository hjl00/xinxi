package com.hjl.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Info implements Serializable {

    private Integer id;
    private String name1;
    private Integer typeId;
    private Integer areaId;
    private Integer areaId2;
    private String handled;
    private String contacts;
    private Integer auditStatus;

    private Integer page;
    private Integer rows;

    //新增
    private String dizhi;
    private String lianxiren;
    private Integer phone;
    private String dianhua;

    private String guojia;
    private String sheng;
    private String jigoujibie;
    private String shi;
    private String areaname;
    private Integer youbian;
    private Integer eamin;
}
