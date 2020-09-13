package xyz.drawstring.domain;

/**
 * 剪切板对象类
 */
public class ClipBrdBean {
    private int times;
    private String code;
    private String context;
    private String QRcode;

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public String getQRcode() {
        return QRcode;
    }

    public void setQRcode(String QRcode) {
        this.QRcode = QRcode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "ClipBrdBean{" +
                "code='" + code + '\'' +
                ", context='" + context + '\'' +
                ", QRcode='" + QRcode + '\'' +
                ", times=" + times +
                '}';
    }
}
