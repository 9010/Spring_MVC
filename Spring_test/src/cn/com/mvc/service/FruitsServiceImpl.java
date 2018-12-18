package cn.com.mvc.service;

import java.util.ArrayList;
import java.util.List;

import cn.com.mvc.model.Fruits;

public class FruitsServiceImpl implements FruitsService {
    public List<Fruits> fruitsList = null;
    private List<Fruits> init() {
        if (fruitsList == null){
            fruitsList = new ArrayList<>();

            Fruits apple = new Fruits();
            apple.setId(1);
            apple.setName("Apple");
            apple.setPrice(2.3);
            apple.setProducing_area("China");

            Fruits banana = new Fruits();
            banana.setId(2);
            banana.setName("Banana");
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
        System.out.println(name + "   " + area);
        Fruits f;
        for (int i = 0; i < fruitsList.size(); i++){
            f = fruitsList.get(i);
            if ( (!name.equals("") && f.getName().equals(name)) ||
                    (!area.equals("") && f.getProducing_area().equals(area))){
                queryList.add(f);
                System.out.println("111111111");
            }
        }
        return queryList.size() > 0 ? queryList : null;
    }

}
