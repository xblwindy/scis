package com.jcohy.scis.controller;

import com.jcohy.scis.common.JsonResult;
import com.jcohy.scis.model.Dept;
import com.jcohy.scis.model.Major;
import com.jcohy.scis.service.DeptService;
import com.jcohy.scis.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/major/")
public class MajorController extends BaseController{

    @Autowired
    private MajorService majorService;

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept")
    @ResponseBody
    public JsonResult getCategoryByTypeId(@RequestParam Integer id){
        System.out.println(id);
        Dept dept = deptService.findById(id);
        List<Major> categories = majorService.findByDept(dept);
        return JsonResult.ok("majors",categories);
    }

}
