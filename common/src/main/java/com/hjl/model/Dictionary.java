package com.hjl.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Dictionary  implements Serializable {
   private Integer typeId;
    private String code;
    private String areaname;
    private String pcode;
    private Integer status;

}
