package com.hjl.controller;

import com.hjl.model.Area;
import com.hjl.model.Dictionary;
import com.hjl.model.Info;
import com.hjl.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class InfoController {
    @Autowired
    private TreeService treeService;

    @RequestMapping("/selectList")
    @ResponseBody
    public Map<Object, Object> selectList (@RequestParam Integer page,@RequestParam Integer rows,@RequestParam String name){
        return treeService.selectList(page,rows,name);

    }


    @RequestMapping("/selectInfoType")
    @ResponseBody
    public List<Dictionary> selectInfoType(){
        return treeService.selectInfoType();
    }


    //市
    @RequestMapping("/queryArea")
    @ResponseBody
    public List<Area> queryArea(@RequestParam Integer pid){
        return treeService.queryArea(pid);
    }


    //省
    @RequestMapping("/queryArea3")
    @ResponseBody
    public List<Area> queryArea3(){
        return  treeService.queryArea3();

    }



    //隐藏
    @RequestMapping("/selectList2")
    @ResponseBody
    public Long selectList2 (@RequestParam String name){
        Long i = treeService.selectList2(name);
        return i;
    }

    @RequestMapping("/saveInfo")
    @ResponseBody
    public List<Info> saveInfo ( Info info){
        return treeService.saveInfo(info);

    }
    @RequestMapping("/deleteInfo")
    @ResponseBody
    public String deleteInfo (@RequestParam Integer id){
        return treeService.deleteInfo(id);

    }
}
