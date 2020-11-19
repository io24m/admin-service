package com.github.io24m.adminservice;

import com.github.io24m.adminservice.common.dto.AjaxPageResponse;
import com.github.io24m.adminservice.common.dto.AjaxResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lk1
 * @description
 * @create 2020-11-18 9:38
 */
@RestController
@RequestMapping("/")
public class HomeController {
    @RequestMapping("/")
    public AjaxResponse index() {
        return AjaxResponse.success();
    }

    @PostMapping("/login")
    public AjaxResponse login(String account, String password, HttpServletRequest request) {
        request.getSession().setAttribute(account, password);
        return AjaxResponse.result(account);
    }

    @PostMapping("/auth")
    public AjaxResponse auth(String auth) {
        List<String> res = new ArrayList<>();
        res.add(auth);
        return AjaxResponse.result(res);
    }

    @PostMapping("/list")
    public AjaxPageResponse list() {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            res.add(i + "");
        AjaxPageResponse<String> result = AjaxPageResponse.result(res);
        result.setCount(res.size());
//        result.setMessage("cuowu");
//        result.setSuccess(false);
        return result;
    }
}
