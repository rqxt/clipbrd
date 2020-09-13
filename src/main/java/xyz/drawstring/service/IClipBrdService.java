package xyz.drawstring.service;

import com.google.zxing.WriterException;
import org.springframework.stereotype.Service;
import xyz.drawstring.domain.ClipBrdBean;

import java.io.IOException;

public interface IClipBrdService {

    // 创建一个剪切板item
    public ClipBrdBean createOne(String context);

    // 查找一个剪切板item
    public ClipBrdBean findOne(String code);
}
