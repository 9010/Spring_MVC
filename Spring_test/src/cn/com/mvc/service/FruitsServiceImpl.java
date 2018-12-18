package cn.com.mvc.service;

import java.util.ArrayList;
import java.util.List;

import cn.com.mvc.model.Fruits;

/**
 * FruitsService 实现类
 */
public class FruitsServiceImpl implements FruitsService {
    public List<Fruits> fruitsList = null;
    private List<Fruits> init() {  //初始化函数，模拟数据库
        if (fruitsList == null){
            fruitsList = new ArrayList<>();

            Fruits apple = new Fruits();
            apple.setId(1);
            apple.setName("苹果");
            apple.setPrice(2.3);
            apple.setProducing_area("China");

            Fruits banana = new Fruits();
            banana.setId(2);
            banana.setName("香蕉");
            banana.setPrice(1.3);
            banana.setProducing_area("Japan");

            fruitsList.add(apple);
            fruitsList.add(banana);
            return fruitsList;
        }else{
            return fruitsList;
        }
    }

    public List<Fruits> queryFruitsList(){
        init();
        return fruitsList;
    }

    public Fruits queryFruitsById(Integer id){
        init();
        for(int i = 0;i < fruitsList.size(); i++){
            if (fruitsList.get(i).getId() == id){
                Fruits frutis = fruitsList.get(i);
                return frutis;
            }
        }
        return null;
    }

    public List<Fruits> queryFruitsByCondition(Fruits fruits){
        init();
        String name = fruits.getName();
        String area = fruits.getProducing_area();
        List<Fruits> queryList = new ArrayList<>();
        Fruits f;
        for (int i = 0; i < fruitsList.size(); i++){
            f = fruitsList.get(i);
            if ( (!name.equals("") && f.getName().equals(name)) ||
                    (!area.equals("") && f.getProducing_area().equals(area))){
                queryList.add(f);
            }
        }
        return queryList.size() > 0 ? queryList : null;
    }

}
