package com.mabao.util.express;

import java.io.IOException;

public interface ExpressQuery {
    PackInfo get(String company, String orderNo)throws IOException;
}
