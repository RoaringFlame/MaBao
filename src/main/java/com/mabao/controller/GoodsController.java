package com.mabao.controller;

import com.mabao.pojo.Goods;
import com.mabao.repository.service.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@RestController
@RequestMapping("/Goods")
public class GoodsController {
    @Autowired
    GoodsRepository goodsRepository;

    @RequestMapping(value = "/findByTime",method=RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public List<Goods> getGoodsListByTime(
            @RequestParam(value="page", defaultValue="0") int page,
            @RequestParam(value="size", defaultValue="4") int size) {
        return goodsRepository.findByTime(new PageRequest(page,size,
                new Sort(Sort.Direction.DESC,"upTime"))).getContent();
    }

    @RequestMapping(value = "/findLikeTitle",method=RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public List<Goods> getGoodsListLikeTitle(
            @RequestParam(value="title", defaultValue="") String  title,
            @RequestParam(value="page", defaultValue="0") int page,
            @RequestParam(value="size", defaultValue="4") int size)  {
        return goodsRepository.findLikeTitle(title, new PageRequest(page, size,
                new Sort(Sort.Direction.DESC, "upTime"))).getContent();
    }

    @RequestMapping(value = "/findByTypeName",method=RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    public List<Goods> getGoodsListByTypeName(
            @RequestParam(value="typeName", defaultValue="") String  typeName,
            @RequestParam(value="page", defaultValue="0") int page,
            @RequestParam(value="size", defaultValue="4") int size) throws UnsupportedEncodingException {
        String decodeTypeName = URLDecoder.decode(typeName,"UTF-8");
        return goodsRepository.findByTypeName(decodeTypeName, new PageRequest(page, size,
                new Sort(Sort.Direction.DESC, "upTime"))).getContent();
    }

}
