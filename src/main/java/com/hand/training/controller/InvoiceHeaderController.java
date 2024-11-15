package com.hand.training.controller;

import com.github.pagehelper.PageInfo;
import com.hand.training.entity.InvoiceHeader;
import com.hand.training.service.InvoiceHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceHeaderController {

    @Autowired
    private InvoiceHeaderService service;

    @GetMapping("/list")
    public PageInfo<InvoiceHeader> list(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestBody(required = false) InvoiceHeader invoiceHeader
    ) {
        if (invoiceHeader == null) {
            invoiceHeader = new InvoiceHeader();
        }
        System.out.println(invoiceHeader);

        return service.list(page, pageSize, invoiceHeader);
    }

    @GetMapping("/detail/{id}")
    public InvoiceHeader detail(@PathVariable Long id) {
        return service.detail(id);
    }

    @DeleteMapping("/remove")
    public String remove(@RequestBody List<Long> ids) {
        return service.remove(ids);
    }

    @PostMapping("saveData")
    public List<InvoiceHeader> saveData(@RequestBody List<InvoiceHeader> invoiceHeaders) {
        return service.saveData(invoiceHeaders);
    }

}
