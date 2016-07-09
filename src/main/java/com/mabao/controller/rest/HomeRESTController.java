package com.mabao.controller.rest;

import com.mabao.controller.vo.BabyVO;
import com.mabao.controller.vo.BannerVO;
import com.mabao.controller.vo.GoodsVO;
import com.mabao.controller.vo.HomeInitVO;
import com.mabao.enums.Gender;
import com.mabao.pojo.Baby;
import com.mabao.pojo.Goods;
import com.mabao.service.BabyService;
import com.mabao.service.BannerService;
import com.mabao.service.GoodsTypeService;
import com.mabao.util.PageVO;
import com.mabao.service.GoodsService;
import com.mabao.util.Selector;
import com.mabao.util.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
@RequestMapping(value = "/home")
public class HomeRESTController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsTypeService goodsTypeService;
    @Autowired
    private BannerService bannerService;
    @Autowired
    private BabyService babyService;

    /**
     * 首页初始化
     *（查询商品类别，轮播图片，宝宝性别）
     * @return              index首页
     */
    @RequestMapping(method = RequestMethod.GET)
    public HomeInitVO homeInit() {
        HomeInitVO homeInitVO = new HomeInitVO();
        //商品类别
        List<Selector> goodsTypeList = this.goodsTypeService.getAllGoodsTypeForSelector();
        homeInitVO.setGoodsTypeList(goodsTypeList);
        //轮播图片列表
        List<BannerVO> smallBanner =BannerVO.generateBy(this.bannerService.findByStatusOrderBySortDesc(true));
        homeInitVO.setSmallBanner(smallBanner);
        /*//猜你喜欢，宝宝信息
        Baby baby = this.babyService.findBabyByUserId(UserManager.getUser().getId()).get(0);
        if (baby != null) {
           homeInitVO.setBaby(BabyVO.generateBy(baby));
        }*/
        //猜你喜欢，宝宝性别
        List<Selector> gender = Gender.toList();
        homeInitVO.setGender(gender);
        return homeInitVO;
    }

    /**
     * 首页商品模糊搜索（包含商品类型）
     * @param searchKey         关键字
     * @param goodsTypeId       商品类型id
     * @return                  商品
     */
    @RequestMapping(value = "/goodsSearch", method = RequestMethod.GET)
    public PageVO<GoodsVO> goodsSearch(@RequestParam(required = false) Long goodsTypeId,
                              @RequestParam(value = "searchKey",required = false) String searchKey,
                              @RequestParam(value = "page", defaultValue = "0") int page,
                              @RequestParam(value = "pageSize", defaultValue = "4") int pageSize) {

        Page<Goods> goodsList = this.goodsService.goodsSearch(goodsTypeId,searchKey,page,pageSize);
        PageVO<GoodsVO> voPage = new PageVO<>();
        voPage.toPage(goodsList);
        voPage.setItems(GoodsVO.generateBy(goodsList.getContent()));
        return voPage;
    }

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
    @RequestMapping(value = "/goodsGuess",method = RequestMethod.GET)
    public PageVO<GoodsVO> goodsListGuess(@RequestParam String babyName,
                                          @RequestParam String babyBirthday,
                                          @RequestParam Gender gender,
                                          @RequestParam String hobby,
                                          @RequestParam(value = "page", defaultValue = "0")int page,
                                          @RequestParam(value = "pageSize", defaultValue = "4") int pageSize) {
        Page<Goods> goodsPage = this.goodsService.goodsListGuess(babyName,babyBirthday,gender,hobby,page,pageSize);
        PageVO<GoodsVO> voPage = new PageVO<>();
        voPage.toPage(goodsPage);
        voPage.setItems(GoodsVO.generateBy(goodsPage.getContent()));
        return voPage;
    }

    @RequestMapping(value = "/goodsGuess/baby/{babyId}",method = RequestMethod.GET)
    public PageVO<GoodsVO> goodsListGuessByBaby(@PathVariable Long babyId,
                                          @RequestParam String hobby,
                                          @RequestParam(value = "page", defaultValue = "0")int page,
                                          @RequestParam(value = "pageSize", defaultValue = "4") int pageSize) {
        Page<Goods> goodsPage = this.goodsService.goodsPageByBabyId(babyId,hobby,page,pageSize);
        PageVO<GoodsVO> voPage = new PageVO<>();
        voPage.toPage(goodsPage);
        voPage.setItems(GoodsVO.generateBy(goodsPage.getContent()));
        return voPage;
    }

}
