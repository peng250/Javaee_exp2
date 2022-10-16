package cn.edu.xmu.JavaEE_Exp1.controller;

import cn.edu.xmu.JavaEE_Exp1.mapper.generator.GoodsPoMapper;
import cn.edu.xmu.JavaEE_Exp1.mapper.po.GoodsPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    private GoodsPoMapper goodsPoMapper;
    @GetMapping("/a")
    public GoodsPo get()
    {
        GoodsPo goodsPo=goodsPoMapper.selectByPrimaryKey(277l);
        return goodsPo;
    }

}
