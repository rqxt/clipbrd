package xyz.drawstring.service.impl;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;
import xyz.drawstring.dao.IClipBrdDao;
import xyz.drawstring.dao.impl.ClipBrdDaoImpl;
import xyz.drawstring.domain.ClipBrdBean;
import xyz.drawstring.service.IClipBrdService;
import xyz.drawstring.util.QRUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

@Service("ClipBrdService")
public class ClipBrdServiceImpl implements IClipBrdService {
    private final String strs = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private Random r = new Random();

    @Autowired
    private IClipBrdDao dao;

    public ClipBrdBean createOne(String context) {
        // 创建随机的四个字符（访问符）
        String code = randomCode();
        while (dao.isExists(code)) {
            // 确保字符的唯一性
            code = randomCode();
        }

        // 创建对象
        ClipBrdBean clipBrdBean = new ClipBrdBean();
        clipBrdBean.setTimes(0);    // 设置访问次数
        clipBrdBean.setCode(code);  // 设置访问码
        clipBrdBean.setContext(context);    // 文本内容
        clipBrdBean.setQRcode(getQRCode(code));     // QRCode二进制码

        // 将对象存入数据库
        try {
            dao.save(clipBrdBean);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 返回对象
        return clipBrdBean;
    }

    public ClipBrdBean findOne(String code){
        boolean flag = dao.isExists(code);
        if (flag) {
            // 存在，则查找数据库，得到对象
            ClipBrdBean clipBrdBean = null;
            try {
                clipBrdBean = dao.findOne(code);
                // 更新访问次数和删除时间
                dao.update(clipBrdBean);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return clipBrdBean;
        } else {
            return null;
        }
    }


    /**
     * 得到随机的字符串
     */
    public String randomCode() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(strs.length());
            builder.append(strs.charAt(index));
        }

        return builder.toString();
    }

    /**
     * 得到 QRCode的二进制字符串形式
     */
    public String getQRCode(String code) {
        String url = "http://www.drawstring.xyz/clipbrd/findOne?code=" + code;
        String qrCodeImage = null;
        try {
            qrCodeImage = QRUtils.getQRCodeImage(url, 180, 180);
        } catch (Exception e) {

        }
        return qrCodeImage;
    }
}
