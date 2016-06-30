
/**
*   home    首页
    goods   商品
        goodsDetail 商品详情
        shppingCar  购物车        
    orders  订单
        orderDetail 订单明细
    user    用户
        address     收货地址

**/

@Controller
@RequestMapping("/mabao/模块名")
public class SimpleController {
    //首页模块
    @RequestMapping(value="首页加载")
    public String get(){
        //获取商品类别
        //轮播
    }
    //列表
    @RequestMapping(value="列表页加载")
    public String get(关键字，商品表的各个属性，分页属性){
        //获取商品类别存入List<Selector>
        //固定值通过枚举存放，转换成List<Selector>
    }
    //商品详情
    @RequestMapping(value="商品详情")
    public Map<String> get(商品Id){
        
    }

    //用户模块
    @RequestMapping(value="地址加载")
    public String get(){
        //获取用户地址List<Addr>
    }

    @RequestMapping(value="地址编辑")
    public String get(){
        //获取用户地址详情Addr
    }

    @RequestMapping(value="地址编辑")
    public String get(){
        //获取用户地址List<Addr>
    }


    //
    @RequestMapping(value="购物车点击确认订单")
    public String get(){
        //修改购物车数据
        //获取用户默认地址
        //获取相同卖家下的所有商品计算，快递费用
        //总价，总商品数量
        
    }

}

@RestController
@RequestMapping("/mabao/模块名")
public class AjaxController {
    //首页
    @RequestMapping(value="新品")
    public PageVO get(分页相关){}

    @RequestMapping(value="猜你喜欢")
    public PageVO get(宝宝相关，分页相关){}
    //购物车
    @RequestMapping(value="加入购物车")
    public 购物车数量 get(商品Id){

    }


}