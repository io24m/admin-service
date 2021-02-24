package com.github.io24m.adminservice.module.demoform;

import com.github.io24m.adminservice.common.dto.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lk1
 * @description
 * @create 2021-02-24 17:11
 */
@RestController
@RequestMapping("/demoform/SettlementBill")
public class SettlementBillController {

    @Autowired
    private SettlementBillServiceImpl settlementBillService;

    @PostMapping("/get")
    public AjaxResponse get() {
        settlementBillService.get();
        return AjaxResponse.success();
    }

    @PostMapping("/upload")
    public void upload() {
        settlementBillService.add();
    }

    @PostMapping("/del")
    public void del() {
        settlementBillService.del();
    }

    @PostMapping("/invalid")
    public void invalid() {
        settlementBillService.invalid();
    }
}
