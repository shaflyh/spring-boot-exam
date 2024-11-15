package com.hand.training.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class InvoiceHeader {
    private Long invoiceHeaderId;
    private String invoiceNumber;
    private String status;
    private String invoiceType;
    private BigDecimal totalAmount;
    private Boolean delFlag;
    private String remark;
    private Date creationDate;
    private Long createdBy;
    private Long lastUpdatedBy;
    private Date lastUpdateDate;

    private List<InvoiceLine> invoiceLines;
}
