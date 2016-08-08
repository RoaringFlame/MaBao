package com.mabao.util.express;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.GZIPInputStream;

public class PackQuery {
    //http://www.kuaidi100.com/query?type=quanfengkuaidi&postid=123456
    private static String order(String company, String orderNo) {
        //String url = "http://www.kuaidi100.com/query?type=yunda&postid=1&id=1&valicode=&temp=0.3015635129995644";
        String url = "http://www.kuaidi100.com/query?type=" + company + "&postid=" + orderNo+ "&id=1&valicode=&temp=0.3015635129995644";
        try {
            HttpURLConnection.setFollowRedirects(true);
            HttpURLConnection http = (HttpURLConnection) (new URL(url).openConnection());
            http.setDoOutput(true);
            http.setDoOutput(true);
            http.setInstanceFollowRedirects(true);
            http.setRequestMethod("GET");
            http.setRequestProperty("Connection", "keep-alive");
            http.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            http.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.92 Safari/537.1 LBBROWSER");
            http.setRequestProperty("Accept", "*/*");
            http.setRequestProperty("Referer", "http://www.kuaidi100.com/");
            http.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
            http.setRequestProperty("Accept-Charset", "utf-8;q=0.7,*;q=0.3");
            http.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");

            String contentEncoding = http.getContentEncoding();
            InputStream in = null;
            if ("gzip".equalsIgnoreCase(contentEncoding)) {
                in = new GZIPInputStream(http.getInputStream());
            } else {
                in = http.getInputStream();
            }
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int data;
            while ((data = in.read()) != -1) {
                baos.write(data);
            }
            String resp = baos.toString("UTF-8");
            return resp;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PackInfo get(String company, String orderNo) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = order(company, orderNo);
        if (json != null) {
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            PackInfo packInfo = mapper.readValue(json, PackInfo.class);
            if (packInfo != null) {
                return packInfo;
            }
        }
        return null;
    }
}
