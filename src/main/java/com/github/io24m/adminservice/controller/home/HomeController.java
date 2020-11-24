package com.github.io24m.adminservice.controller.home;

import com.github.io24m.adminservice.common.annotation.SkipToken;
import com.github.io24m.adminservice.common.dto.AjaxResponse;
import com.github.io24m.adminservice.common.utils.PageUtil;
import com.github.io24m.adminservice.domain.home.Home;
import com.github.io24m.adminservice.service.home.HomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lk1
 * @description
 * @create 2020-11-24 16:02
 */
@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private HomeServiceImpl homeService;

    @RequestMapping("/index")
    @SkipToken
    public AjaxResponse index() {
        return AjaxResponse.result(homeService.get());
    }

    @RequestMapping("/page")
    @SkipToken
    public AjaxResponse indexPage() {
        PageUtil.startPage();
        List<Home> homeResults = homeService.selectAll();
        return AjaxResponse.pageResult(homeResults);
    }
}
