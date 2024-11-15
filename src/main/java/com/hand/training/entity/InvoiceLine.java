package com.hand.training.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class InvoiceLine {
    private Long invoiceLineId;
    private Long invoiceHeaderId;
    private String itemNumber;
    private String itemDescription;
    private BigDecimal unitPrice;
    private Integer quantity;
    private BigDecimal totalAmount;
    private String remark;
    private Date creationDate;
    private Long createdBy;
    private Long lastUpdatedBy;
    private Date lastUpdateDate;
}
