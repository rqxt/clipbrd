package xyz.drawstring.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import xyz.drawstring.domain.ClipBrdBean;

public interface IClipBrdDao {
    /**
     * 查找一个是否存在
     */
    public boolean isExists(String code);

    /**
     * 查找一个
     */
    public ClipBrdBean findOne(String code) throws Exception;

    /**
     * 保存对象
     */
    void save(ClipBrdBean clipBrdBean) throws Exception;

    /**
     * 更新对象
     */
    void update(ClipBrdBean clipBrdBean) throws Exception;
}
