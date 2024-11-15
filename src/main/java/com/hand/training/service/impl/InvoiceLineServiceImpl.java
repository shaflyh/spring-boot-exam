package com.hand.training.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.training.entity.InvoiceLine;
import com.hand.training.mapper.InvoiceLineMapper;
import com.hand.training.service.InvoiceLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceLineServiceImpl implements InvoiceLineService {
    @Autowired
    private InvoiceLineMapper lineMapper;

    @Override
    public PageInfo<InvoiceLine> list(int page, int pageSize, InvoiceLine invoiceLine) {
        PageHelper.startPage(page, pageSize);

        List<InvoiceLine> list = lineMapper.list(invoiceLine);
        return new PageInfo<>(list);
    }

    @Override
    public InvoiceLine detail(Long invoiceLineId) {
        return lineMapper.detail(invoiceLineId);
    }
}
