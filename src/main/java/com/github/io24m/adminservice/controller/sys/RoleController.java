package com.github.io24m.adminservice.controller.sys;

import com.github.io24m.adminservice.common.dto.AjaxResponse;
import com.github.io24m.adminservice.domain.SysRole;
import com.github.io24m.adminservice.service.sys.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lk1
 * @description
 * @create 2020-12-14 10:28
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("")
    public AjaxResponse get() {
        List<SysRole> role = roleService.getRole();
        return AjaxResponse.result(role);
    }

    @PostMapping("/delete")
    public AjaxResponse delete(Integer id) {
        if (id == null) {
            return AjaxResponse.error("");
        }
        roleService.deleteRole(id);
        return AjaxResponse.success();
    }
}
