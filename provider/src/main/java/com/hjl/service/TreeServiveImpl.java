package com.hjl.service;

import com.hjl.mapper.TreeMapper;
import com.hjl.model.Area;
import com.hjl.model.Dictionary;
import com.hjl.model.Info;
import com.hjl.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TreeServiveImpl implements TreeService {
    @Autowired
    private TreeMapper treeMapper;

    @GetMapping("/selectTree")
    public List<Tree> selectTree() {
        return selectNode(-1);
    }



    private List<Tree> selectNode(Integer id) {
        List<Tree> treeList = treeMapper.selectNodeId(id);
        for (Tree tree : treeList) {
            List<Tree> nodeList = selectNode(tree.getId());

            if (nodeList != null && !nodeList.isEmpty()) {
                tree.setNodes(nodeList);
                tree.setSelectable(true);
            }else{
                tree.setSelectable(true);
            }
        }
        return treeList;
    }

    @GetMapping("/selectList")

    public Map<Object, Object> selectList(@RequestParam Integer page,@RequestParam Integer rows,@RequestParam String name) {
        Long total = treeMapper.selectCount(name);

        //查询列表
        List<Info> newsList = treeMapper.selectList((page-1)*rows,rows,name);

        //将数据放入map集合
        HashMap<Object, Object> Map = new HashMap<>();
        Map.put("total", total);
        Map.put("rows", newsList);
        return Map;

    }

    @GetMapping("/selectInfoType")
    @Override
    public List<Dictionary> selectInfoType() {
        return treeMapper.selectInfoType();
    }

    @GetMapping("/queryArea")
    @Override
    public List<Area> queryArea(@RequestParam Integer pid) {
        return treeMapper.queryArea(pid);
    }

    @GetMapping("/queryArea3")
    @Override
    public List<Area> queryArea3() {
        return treeMapper.queryArea3();
    }

    @GetMapping("/selectList2")
    @Override
    public Long selectList2(@RequestParam String name) {
        Long total = treeMapper.selectCount1(name);

        return total;
    }

    @PostMapping("/saveInfo")
    @Override
    public List<Info> saveInfo(@RequestBody Info info) {

        return treeMapper.saveInfo(info);
    }

    @Override
    public String deleteInfo(@RequestParam Integer id) {
        return treeMapper.deleteInfo(id);
    }


}
