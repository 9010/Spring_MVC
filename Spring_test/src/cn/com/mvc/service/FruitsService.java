package cn.com.mvc.service;

import java.util.List;

import cn.com.mvc.model.Fruits;

public interface FruitsService{
    public List<Fruits> queryFruitsList();
    public Fruits queryFruitsById(Integer id);
    public List<Fruits> queryFruitsByCondition(Fruits fruits);
}
