

public class AllService {
    //首页
    //获取所有商品类别
    public List<GoodsType> get();
    //获取轮播图片地址
    public List<Img> get();
    //通过Id查询商品详情
    public Goods get(int goodsId);
    //通过商品Id加入购物车,返回购物车中商品数量
    public int get(int goodsId)

    //用户
    //通过用户Id获取用户地址列表
    public List<Addr> get(int userId)
    
    //通过地址Id获取地址详情


}