package com.mabao.controller;

import com.mabao.pojo.Goods;
import com.mabao.pojo.vo.BabyInfoForm;
import com.mabao.service.GoodsService;
import com.mabao.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
@RequestMapping("/goods")
public class GoodsController {
//    @Autowired
//    GoodsRepository goodsRepository;
//
//
//    @RequestMapping(value = "/findByTime",method=RequestMethod.GET,
//            produces = "application/json;charset=UTF-8")
//    public List<Goods> getGoodsListByTime(
//            @RequestParam(value="page", defaultValue="0") int page,
//            @RequestParam(value="size", defaultValue="4") int size) {
//        return /*goodsRepository.findByTime(new PageRequest(page,size,
//                new Sort(Sort.Direction.DESC,"upTime"))).getContent()*/null;
//    }
//
//    @RequestMapping(value = "/findLikeTitle",method=RequestMethod.GET,
//            produces = "application/json;charset=UTF-8")
//    public List<Goods> getGoodsListLikeTitle(
//            @RequestParam(value="title", defaultValue="") String  title,
//            @RequestParam(value="page", defaultValue="0") int page,
//            @RequestParam(value="size", defaultValue="4") int size)  {
//        return goodsRepository.findLikeTitle(title, new PageRequest(page, size,
//                new Sort(Sort.Direction.DESC, "upTime"))).getContent();
//    }
//
//    @RequestMapping(value = "/findByTypeName",method=RequestMethod.GET,
//            produces = "application/json;charset=UTF-8")
//    public List<Goods> getGoodsListByTypeName(
//            @RequestParam(value="typeName", defaultValue="") String  typeName,
//            @RequestParam(value="page", defaultValue="0") int page,
//            @RequestParam(value="size", defaultValue="4") int size) throws UnsupportedEncodingException {
//        String decodeTypeName = URLDecoder.decode(typeName,"UTF-8");
//        return goodsRepository.findByTypeName(decodeTypeName, new PageRequest(page, size,
//                new Sort(Sort.Direction.DESC, "upTime"))).getContent();
//    }

    @Autowired
    private GoodsTypeService goodsTypeService;
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/goodsTime",method = GET)
    public String goodsTime(int page, int size,Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        //商品列表
        List<Goods> goodsList = this.goodsService.getGoodsListByTime(page, size);
        map.put("goodsList", goodsList);
        model.addAllAttributes(map);
        return "index_list";
    }

        @RequestMapping(value ="/goodsTitle",method = GET)
        public String goodsTitle(String title,int page,int size,Model model){
            Map<String,Object> map=new HashMap<String, Object>();
            //商品列表
            List<Goods> goodsList=this.goodsService.getGoodsListLikeTitle(title,page,size);
            map.put("goodsList",goodsList);
            model.addAllAttributes(map);
            return "index_list";
        }

    @RequestMapping(value ="/goodsType",method = GET)
    public String goodsType(String typeName,int page, int size,Model model){
        Map<String,Object> map=new HashMap<String, Object>();
        //商品列表
        List<Goods> goodsList=this.goodsService.getGoodsListByTypeName(typeName,page,size);
        map.put("goodsList",goodsList);
        model.addAllAttributes(map);
        return "index_list";
    }

    @RequestMapping(value = "/goodsTable",method = POST)
    public String goodsTable(BabyInfoForm form,int page, int size, Model model){
        Map<String,Object> map=new HashMap<String, Object>();
        //商品列表
        List<Goods> goodsList=this.goodsService.getGoodsListByTable(form,page,size);
        map.put("goodsList",goodsList);
        model.addAllAttributes(map);
        return "index_list";
    }



}
