package com.mabao.controller.rest;

import com.mabao.controller.vo.GoodsVO;
import com.mabao.enums.Gender;
import com.mabao.util.PageVO;
import com.mabao.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by maxu on 2016/6/30.
 */
@RestController
@RequestMapping(value = "/goods")
public class GoodsRESTController {
    @Autowired
    private GoodsService goodsService;

    /**
     * （首页猜你喜欢）
     * @param babyName          宝宝姓名
     * @param babyBirthday      宝宝生日
     * @param gender            宝宝性别
     * @param hobby             爱好
     * @param page              页码
     * @param pageSize          一页大小
     * @return                  商品集合，分页
     */
    @RequestMapping(value = "/goodsGuess",method = RequestMethod.POST,produces = "application/json;charset:UTF-8")
    public PageVO<GoodsVO> goodsListGuess(@RequestParam String babyName,
                                          @RequestParam String babyBirthday,
                                          @RequestParam Gender gender,
                                          @RequestParam String hobby,
                                          @RequestParam(value = "page", defaultValue = "0")int page,
                                          @RequestParam(value = "size", defaultValue = "4") int pageSize) {
        return this.goodsService.goodsListGuess(babyName,babyBirthday,gender,hobby,page,pageSize);
    }
}
