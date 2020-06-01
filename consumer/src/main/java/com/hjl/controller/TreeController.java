package com.hjl.controller;

import com.hjl.model.Tree;
import com.hjl.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class TreeController {
    @Autowired
    private TreeService treeService;

    @RequestMapping("/selectTree")
    @ResponseBody
    public List<Tree> selectTree( ){
        return treeService.selectTree();
    }

}
