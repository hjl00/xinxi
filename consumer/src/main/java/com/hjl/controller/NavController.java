package com.hjl.controller;

import com.hjl.model.Area;
import com.hjl.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class NavController {
    @Autowired
    private TreeService treeService;
    @RequestMapping("/toMain")
    public String toMain(){
        return "main";
    }

    @RequestMapping("/toInfoList")
    public String toOrderList(){
        return "infoList";
    }

    @RequestMapping("/toInfoAdd")
    public String toInfoAdd(){
        return "infoAdd";
    }

    @RequestMapping("/toInfoUpdate")
    public String toInfoUpdate(){
        return "updateList";
    }

}
