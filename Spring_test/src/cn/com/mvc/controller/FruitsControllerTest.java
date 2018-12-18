package cn.com.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.mvc.model.Fruits;
import cn.com.mvc.service.FruitsService;
import cn.com.mvc.service.FruitsServiceImpl;

@Controller
public class FruitsControllerTest{

    private FruitsService fruitesService = new FruitsServiceImpl();

    @RequestMapping("/queryFruits")
    public ModelAndView queryFruits() throws Exception{
        //模拟Service获取水果列表
        List<Fruits> fruitsList = fruitesService.queryFruitsList();
        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相当于request的setAttribut，在Jsp页面中通过fruitsList获取数据
        modelAndView.addObject("fruitsList", fruitsList);
        //指定视图
        modelAndView.setViewName("fruits/fruitsList");
        return modelAndView;
    }
}


