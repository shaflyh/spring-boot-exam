package com.hand.training.controller;

import com.github.pagehelper.PageInfo;
import com.hand.training.entity.InvoiceLine;
import com.hand.training.service.InvoiceLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoiceLines")
public class InvoiceLineController {

    @Autowired
    private InvoiceLineService service;

    @GetMapping("/list")
    public PageInfo<InvoiceLine> list(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestBody(required = false) InvoiceLine invoiceLine
    ) {
        if (invoiceLine == null) {
            invoiceLine = new InvoiceLine();
        }
        return service.list(page, pageSize, invoiceLine);
    }

    @GetMapping("/detail/{id}")
    public InvoiceLine detail(@PathVariable Long id) {
        return service.detail(id);
    }

}
