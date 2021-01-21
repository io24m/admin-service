package com.github.io24m.adminservice;

import com.github.io24m.adminservice.common.annotation.SkipToken;
import com.github.io24m.adminservice.common.dto.AjaxResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lk1
 * @description
 * @create 2021-01-21 12:36
 */
@RestController
@RequestMapping("")
public class HomeController {
    @SkipToken
    @GetMapping("")
    public AjaxResponse index() {
        String res="文档地址[/doc.html|/swagger-ui.html]";
        return AjaxResponse.result(res);
    }
}
