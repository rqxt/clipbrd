package xyz.drawstring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.drawstring.domain.ClipBrdBean;
import xyz.drawstring.service.IClipBrdService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 剪切板的控制器
 */
@Controller
public class ClipBrdController {

    @Autowired
    private IClipBrdService service;

    /**
     * 页面导航到 index首页
     * @return
     */
    @RequestMapping(path={"/","index"})
    public String index(){
        return "/index";
    }

    /**
     * 页面导航到 create页面
     * @return
     */
    @RequestMapping(value="/create")
    public String create(){
        return "/create";
    }

    /**
     * 页面导航到 find页面
     * @return
     */
    @RequestMapping(value="/find")
    public String find(){
        return "/find";
    }


    @RequestMapping(value="/createOne")
    public String createOne(String context, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 得到请求存储的文本内容
        // 将文本内容交给service处理
        if(context.contains("\n") || context.contains("\r")) {
            System.out.println("开始转换换行符");
            context = context.replace("\n", "#n#");
            context = context.replace("\r", "#r#");
        }
        context = context.replace(">","&gt;");
        context = context.replace(">","&lt;");

        ClipBrdBean clipBrdBean = service.createOne(context);
        // 转发内容到findOne界面
        return "redirect:findOne?code="+clipBrdBean.getCode();
    }


    @RequestMapping(value="/findOne")
    public String findOne(String code, HttpServletRequest request) throws Exception {
        ClipBrdBean clipBrdBean = service.findOne(code);
        String context = clipBrdBean.getContext();
        if(context.contains("#n#") || context.contains("#r#")){
            System.out.println("开始转换换行符");
            context = context.replace("#n#","\n");
            context = context.replace("#r#","\r");
            clipBrdBean.setContext(context);
        }
        request.getSession().setAttribute("clipbrd",clipBrdBean);

        if(clipBrdBean != null){
            // 转发内容
            return "/detail";
        }else{
            // 重定向过期界面
            return "redirect:overdue?code="+code;
        }

    }

    @RequestMapping("overdue")
    public String overdue(){
        return "/overdue";
    }
}
