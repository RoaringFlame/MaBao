package com.mabao.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomeControllerTest {

  @Test
  public void testIndexPage() throws Exception {
    /*HomeController controller = new HomeController();
    MockMvc mockMvc = standaloneSetup(controller).build();
    mockMvc.perform(get("/"))
           .andExpect(view().name("index"));*/
  }

  @Test
  public void testShowGoodsDetail() throws Exception {
    /*Goods expectedGoods = new Goods();
    GoodsRepository mockRepository = mock(GoodsRepository.class);
    when(mockRepository.findOne((long) 12345)).thenReturn(expectedGoods);
    HomeController controller = new HomeController(mockRepository);
    MockMvc mockMvc = standaloneSetup(controller).build();
    mockMvc.perform(get("/findById/12345"))
            .andExpect(view().name("detail"))
            .andExpect(model().attributeExists("goods"))
            .andExpect(model().attribute("goods",expectedGoods));*/
  }
}
