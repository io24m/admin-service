package com.github.io24m.adminservice;

import com.github.io24m.adminservice.common.annotation.SkipToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lk1
 * @description
 * @create 2021-01-21 12:36
 */
@ApiIgnore
@Api(description = "首页")
@Controller
@RequestMapping("")
public class HomeController {

    @ApiOperation("首页")
    @SkipToken
    @GetMapping("")
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect("doc.html");
    }
}
