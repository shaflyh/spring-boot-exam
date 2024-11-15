package com.hand.training.mapper;

import com.hand.training.entity.InvoiceHeader;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface InvoiceHeaderMapper {
    List<InvoiceHeader> list(InvoiceHeader invoiceHeader);

    InvoiceHeader detail(@Param("invoiceHeaderId") Long invoiceHeaderId);

    void removeInvoiceLines(@Param("ids") List<Long> ids);

    void removeInvoiceHeaders(@Param("ids") List<Long> ids);

    /////
    void saveUpdate(InvoiceHeader invoiceHeader);

    InvoiceHeader findById(Long invoiceHeaderId);

    void updateTotal(Long invoiceHeaderId, BigDecimal total);
}
