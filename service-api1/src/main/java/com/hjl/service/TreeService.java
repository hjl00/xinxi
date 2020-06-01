package com.hjl.service;

import com.hjl.model.Area;
import com.hjl.model.Dictionary;
import com.hjl.model.Info;
import com.hjl.model.Tree;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.Map;

@FeignClient(value = "provider")
public interface TreeService {

    @GetMapping("/selectTree")
    List<Tree> selectTree();

    @GetMapping("/selectList")
    Map<Object, Object> selectList(@RequestParam Integer page,@RequestParam Integer rows,@RequestParam String name);

    @GetMapping("/selectInfoType")
    List<Dictionary> selectInfoType();


    @GetMapping("/queryArea")
    List<Area> queryArea(@RequestParam Integer pid);

    @GetMapping("/queryArea3")
    List<Area> queryArea3();

    @GetMapping("/selectList2")
    Long selectList2(@RequestParam String name);

    @PostMapping("/saveInfo")
    List<Info> saveInfo(@RequestBody Info info);

    @PostMapping("/deleteInfo")
    String deleteInfo(@RequestParam Integer id);



}
