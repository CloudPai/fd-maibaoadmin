package com.binwang.controller;

import com.binwang.bean.analysis.UserCollect;
import com.binwang.bean.analysis.Userprize;
import com.binwang.service.AnalysisService;
import com.binwang.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/analysis")
public class AnalysisController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnalysisController.class);
    @Resource
    private AnalysisService analysisService;
    @Value("${fbinwang.crossurl}")
    private String crossUrl;
//    @CrossOrigin(origins ="http://wechat.tuopinpin.com:8080")
    @RequestMapping(value = "/user-prize", method = RequestMethod.GET)
    @ResponseBody
    public Object UserPrize(){
        try {
            List<Userprize> list = analysisService.listUserPrize();
            return ResponseUtil.okJSON(list);
        } catch (Exception e) {
            LOGGER.error("获取抽奖时间统计失败");
            LOGGER.error(e.getMessage());
            return ResponseUtil.errorJSON(e.getMessage());
        }
    }
//    @CrossOrigin(origins = "http://wechat.tuopinpin.com:8080")
    @RequestMapping(value = "/user-collect", method = RequestMethod.GET)
    @ResponseBody
    public Object UserCollect(){
        try {
            List<UserCollect> list = analysisService.listUserCollect();
            return ResponseUtil.okJSON(list);
        } catch (Exception e) {
            LOGGER.error("获取报名时间统计失败");
            LOGGER.error(e.getMessage());
            return ResponseUtil.errorJSON(e.getMessage());
        }
    }
}
