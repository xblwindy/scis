package com.jcohy.scis.directive;

import com.jcohy.scis.model.Circular;
import com.jcohy.scis.model.Project;
import com.jcohy.scis.service.CircularService;
import com.jcohy.scis.service.ProjectService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class CircularDirective implements TemplateDirectiveModel{
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CircularDirective.class);

    @Autowired
    private CircularService circularService;
    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        List<Circular> list = circularService.findAllVisiable();
        logger.warn("Circular:{}",list.size());
        environment.setVariable("list", new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25).build().wrap(list));
        if (templateDirectiveBody != null) {
            templateDirectiveBody.render(environment.getOut());
        }
    }
}
