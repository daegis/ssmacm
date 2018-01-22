package cn.aegisa.acm.web.controller;

import cn.aegisa.acm.dao.service.ICommonService;
import cn.aegisa.acm.model.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Using IntelliJ IDEA.
 *
 * @author HNAyd.xian
 * @date 2018/1/22 12:26
 */
@Slf4j
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    @Qualifier("ucenterCommonService")
    private ICommonService service;

    @RequestMapping("/01/{id}")
    public String test01(@PathVariable Integer id, Model model) {
        log.info("访问到了这个方法");
        List<City> id1 = service.getList(City.class, "id", id);
        model.addAttribute("name", id1.get(0).getName());
        return "test";
    }
}
