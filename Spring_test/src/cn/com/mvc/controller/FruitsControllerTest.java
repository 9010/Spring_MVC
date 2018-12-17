package cn.com.mvc.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cn.com.mvc.model.Fruits;

public class FruitsControllerTest implements Controller {

    private FruitsService fruitesService = new FruitsService();

    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception{
        //模拟Service获取水果列表
        List<Fruits> fruitsList = fruitesService.queryFruitsList();
        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相当于request的setAttribut，在Jsp页面中通过fruitsList获取数据
        modelAndView.addObject("fruitsList", fruitsList);
        //指定视图
        modelAndView.setViewName("WEB-INF/jsp/fruits/fruitsList.jsp");
        return modelAndView;
    }
}

class FruitsService{
    public List<Fruits> queryFruitsList(){
        List<Fruits> fruitsList = new ArrayList<>();

        Fruits apple = new Fruits();
        apple.setName("红富士苹果");
        apple.setPrice(2.3);
        apple.setProducing_area("山东");

        Fruits banana = new Fruits();
        banana.setName("香蕉");
        banana.setPrice(1.5);
        banana.setProducing_area("上海");

        fruitsList.add(apple);
        fruitsList.add(banana);
        return fruitsList;
    }
}
