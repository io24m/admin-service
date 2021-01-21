package com.github.io24m.adminservice.controller.home;

import com.github.io24m.adminservice.common.annotation.SkipToken;
import com.github.io24m.adminservice.common.dto.AjaxResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author lk1
 * @description
 * @create 2020-11-24 16:02
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @PostMapping("/index")
    @SkipToken
    public AjaxResponse index() {
        return AjaxResponse.result(new ArrayList<>());
    }

//    @RequestMapping("/page")
//    @SkipToken
//    public AjaxResponse indexPage() {
//        PageUtil.startPage();
//        List<Home> homeResults = homeService.selectAll();
//        return AjaxResponse.pageResult(homeResults);
//    }
}
