package com.mabao.controller;

import com.mabao.repository.service.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/")
public class HomeController {

  public HomeController() {
  }

  private GoodsRepository goodsRepository;

  @Autowired
  public HomeController(GoodsRepository goodsRepository) {
    this.goodsRepository = goodsRepository;
  }

  @RequestMapping(method = GET)
  public String home(Model model) {
    return "index";
  }

  @RequestMapping(value="/findById/{id}", method= RequestMethod.GET)
  public String getGoodsDetail(
          @PathVariable("id") long id,
          Model model) {
    model.addAttribute(goodsRepository.findOne(id));
    return "detail";
  }
}
