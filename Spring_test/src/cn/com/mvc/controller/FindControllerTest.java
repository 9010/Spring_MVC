package cn.com.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.mvc.model.Fruits;
import cn.com.mvc.service.FruitsService;
import cn.com.mvc.service.FruitsServiceImpl;

@Controller
@RequestMapping("query")
public class FindControllerTest {
    private FruitsService fruitsService = new FruitsServiceImpl();

    @RequestMapping("queryFruitsByCondition")
    public String queryFruitsByCondition(Model model, Fruits fruits){
        List<Fruits> findList = null;
        if (fruits == null || (fruits.getName() == null && fruits.getProducing_area() == null)){
            //如果fruits或查询条件为空，默认查询所有数据
            findList = fruitsService.queryFruitsList();
            //System.out.println("---------------");
        }else {
            //如果fruits查询条件不为空，按条件查询
            findList = fruitsService.queryFruitsByCondition(fruits);
            //System.out.println("+++++++++++++++");
        }
        model.addAttribute("fruitsList", findList);
        return "/fruits/findFruits";
        //return "WEB-INF/jsp/fruits/findFruits.jsp";
    }
}
