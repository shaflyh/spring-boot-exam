package com.hand.training.service;

import com.github.pagehelper.PageInfo;
import com.hand.training.entity.InvoiceLine;

import java.util.List;

public interface InvoiceLineService {
    PageInfo<InvoiceLine> list(int page, int pageSize, InvoiceLine invoiceLine);

    InvoiceLine detail(Long invoiceLineId);

}
