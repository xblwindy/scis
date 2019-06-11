package com.jcohy.scis.controller;

import com.jcohy.scis.service.AllotService;
import com.jcohy.scis.service.ExpertService;
import com.jcohy.scis.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/project")
public class AdminProjectController extends BaseController{

    @Autowired
    private AllotService allotService;

    @Autowired
    private ExpertService expertService;

    @Autowired
    private ProjectService projectService;

}
