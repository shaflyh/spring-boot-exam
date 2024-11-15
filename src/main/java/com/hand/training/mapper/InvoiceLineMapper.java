package com.hand.training.mapper;

import com.hand.training.entity.InvoiceLine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface InvoiceLineMapper {

    List<InvoiceLine> list(InvoiceLine invoiceHeader);

    InvoiceLine detail(@Param("invoiceLineId") Long invoiceLineId);

    void removeInvoiceLines(@Param("ids") List<Long> ids);

    void removeInvoiceHeaders(@Param("ids") List<Long> ids);

    // Insert or update an invoice line
    void saveUpdate(InvoiceLine invoiceLine);

    // Delete invoice lines by header ID
    void deleteByInvoiceHeaderId(Long invoiceHeaderId);

    // Calculate total amount for a given invoice header
    BigDecimal calculateTotalAmount(Long invoiceHeaderId);

    // Retrieve invoice lines by header ID
    List<InvoiceLine> findByInvoiceHeaderId(Long invoiceHeaderId);
}
