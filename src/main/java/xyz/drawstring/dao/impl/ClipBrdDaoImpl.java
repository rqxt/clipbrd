package xyz.drawstring.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import xyz.drawstring.dao.IClipBrdDao;
import xyz.drawstring.domain.ClipBrdBean;
import xyz.drawstring.util.QRUtils;

import java.io.IOException;
import java.util.HashMap;

@Repository
public class ClipBrdDaoImpl implements IClipBrdDao {


    Jedis jedis = new Jedis();



    public boolean isExists(String code) {
        code = code.toUpperCase();
        String ret = jedis.get(code);
        if (ret == null || ret.length() == 0) {
            return false;
        }
        return true;
    }

    // 将对象以 json格式存入redis中
    public void save(ClipBrdBean clipBrdBean){
        // 将对象转换为 String形式
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(clipBrdBean);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // 存入redix中，并设置15分钟后过期
        jedis.setex(clipBrdBean.getCode(), 900, json);
    }



    public ClipBrdBean findOne(String code) {
        // 通过code查找到对象的json数据
        code = code.toUpperCase();
        String json = jedis.get(code);

        // 将json数据转换为对象
        ObjectMapper mapper = new ObjectMapper();
        ClipBrdBean clipBrdBean = null;
        try {
            clipBrdBean = mapper.readValue(json, ClipBrdBean.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 返回对象
        return clipBrdBean;
    }


    public void update(ClipBrdBean clipBrdBean){
        // 更新访问次数
        clipBrdBean.setTimes(clipBrdBean.getTimes() + 1);
        // 重置过期时间
        String code = clipBrdBean.getCode();
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(clipBrdBean);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        jedis.setex(code, 900, json);
    }


}
