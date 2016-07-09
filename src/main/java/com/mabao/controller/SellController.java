package com.mabao.controller;

import com.mabao.enums.Gender;
import com.mabao.pojo.Address;
import com.mabao.pojo.Goods;
import com.mabao.service.*;
import com.mabao.util.Selector;
import com.mabao.util.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 寄售模块
 * @author jackie
 */
@Controller
@RequestMapping("/sell")
public class SellController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private GoodsTypeService goodsTypeService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private GoodsSizeService goodsSizeService;

    /**
     * 寄售
     * (添加售货地址)
     * @param address               地址对象，需包含用户ID
     * @return                      添加结果页面
     */
    @RequestMapping(value = "/receiptPlaceAdd",method = POST)
    public String addReceiptPlace(@RequestParam Address address){
        address.setState(true);//设为默认地址
        address.setUser(UserManager.getUser());
        Address adr = this.addressService.addAddress(address);
        return adr != null ? "consignment_success" : "consignment_failure";
    }


    /**
     * 自助发布宝物页下拉菜单
     * @param model             map
     * @return                  自助发布宝物页
     */
    @RequestMapping(value = "/releaseSelector",method = GET)
    public String releaseGoodsSelector(Model model){
        Map<String,Object> map = new HashMap<>();
        //商品类型
        List<Selector> goodsTypeList = this.goodsTypeService.getAllGoodsTypeForSelector();
        map.put("goodsType",goodsTypeList);
        //品牌
        List<Selector> brand = this.brandService.findBrandForSelector();
        map.put("brand",brand);
        //宝宝性别
        List<Selector> gender = Gender.toList();
        map.put("gender",gender);
        //尺码
        List<Selector> goodsSize = this.goodsSizeService.findGoodsSizeForSelector();
        map.put("goodsSize",goodsSize);
        model.addAllAttributes(map);
        return "selfup";
    }

    /**
     * 自助发布宝物
     * 添加商品
     * @param newGoods          商品对象，需包含用户ID
     * @param model             success or false
     * @return                  寄售成功页
     */
    @RequestMapping(value = "/release",method = POST)
    public String releaseGoods(Goods newGoods,Model model){
/*      Goods result =  this.goodsService.saveOne(newGoods);
        String result = this.goodsService.saveOne(newGoods) != null ? "success" : "failure";
        model.addAttribute("result",result);*/
        if (this.goodsService.saveOne(newGoods) != null){
            return "publish_success";
        }else {
            return "publish_failure";
        }
    }



}

