package com.hand.training.service;

import com.github.pagehelper.PageInfo;
import com.hand.training.entity.InvoiceHeader;

import java.util.List;

public interface InvoiceHeaderService {
    PageInfo<InvoiceHeader> list(int page, int pageSize, InvoiceHeader invoiceHeader);

    InvoiceHeader detail(Long invoiceHeaderId);

    String remove(List<Long> ids);

    List<InvoiceHeader> saveData(List<InvoiceHeader> invoiceHeaders);
}
