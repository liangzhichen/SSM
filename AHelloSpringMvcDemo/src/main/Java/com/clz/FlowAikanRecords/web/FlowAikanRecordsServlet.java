package com.clz.FlowAikanRecords.web;

import HelloSpringMvc.controller.TestController;
import com.clz.FlowAikanRecords.bean.FlowAikanRecords;
import com.clz.FlowAikanRecords.service.FlowAikanRecordsService;
import com.clz.FlowAikanRecords.vo.RequestVo;
import com.clz.FlowAikanRecords.vo.ResponseVo;
import com.clz.web.HttpRequestUtil;
import com.sun.glass.ui.mac.MacPasteboard;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.core.Request;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by clz on 2017/12/21.
 */
@Controller
@RequestMapping(value = "/FlowAikanRecords/*")
public class FlowAikanRecordsServlet {
    private Logger log = Logger.getLogger(TestController.class);

    @Autowired
    private FlowAikanRecordsService flowAikanRecordsService;

    @ResponseBody  //写了的话，直接返回接口结果，不写返回的是页面
    @RequestMapping(value = "findById")
    public Map findById(@RequestParam String id ,HttpServletRequest request)throws Exception{
        String session = request.getParameter("session");
        String id1 = request.getParameter("id");
        Map<String,Object> map = new HashMap<String,Object>();
        log.info(id);
        List<FlowAikanRecords> list = flowAikanRecordsService.findById(id);
        map.put("list",list);
        return map;
    }

    @ResponseBody  //分页方法
    @RequestMapping(value = "listByPage")
    public Map listByPage(@RequestParam String pageSize , @RequestParam String pageNo){
        Map<String,Object> map = new HashMap<String,Object>();
        List<FlowAikanRecords> list = flowAikanRecordsService.listByPage(pageSize,pageNo);
        map.put("list",list);
        return map;
    }

    @ResponseBody  //xml 中方法的示例
    @RequestMapping(value = "findByRequest")
    public Map findByRequest(RequestVo requestVo){
        Map<String,Object> map = new HashMap<String,Object>();
        List<ResponseVo> list = flowAikanRecordsService.findByRequest(requestVo);
        map.put("list",list);
        return map;
    }
}
