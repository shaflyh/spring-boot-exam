package com.hand.training.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.training.entity.InvoiceHeader;
import com.hand.training.entity.InvoiceLine;
import com.hand.training.mapper.InvoiceHeaderMapper;
import com.hand.training.mapper.InvoiceLineMapper;
import com.hand.training.service.InvoiceHeaderService;
import com.hand.training.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class InvoiceHeaderServiceImpl implements InvoiceHeaderService {

    @Autowired
    private InvoiceHeaderMapper headerMapper;
    @Autowired
    private InvoiceLineMapper lineMapper;

    @Override
    public PageInfo<InvoiceHeader> list(int page, int pageSize, InvoiceHeader invoiceHeader) {
        PageHelper.startPage(page, pageSize);

        List<InvoiceHeader> list = headerMapper.list(invoiceHeader);
        return new PageInfo<>(list);
    }

    @Override
    public InvoiceHeader detail(Long invoiceHeaderId) {
        return headerMapper.detail(invoiceHeaderId);
    }

    @Override
    public String remove(List<Long> ids) {
        headerMapper.removeInvoiceHeaders(ids);
        headerMapper.removeInvoiceLines(ids);
        return "Invoices removed!";
    }

    @Transactional
    @Override
    public List<InvoiceHeader> saveData(List<InvoiceHeader> invoiceHeaders) {
        for (InvoiceHeader header : invoiceHeaders) {
            // Check the validation for status
            if (!Constants.VALID_STATUSES.contains(header.getStatus())) {
                throw new IllegalArgumentException("Invalid status value, the valid status value: 'D' (Draft), 'S' (Success), 'F' Failed, 'C' (Canceled) ");
            }

            // Check the validation for invoice type
            if (!Constants.VALID_INVOICE_TYPES.contains(header.getInvoiceType())) {
                throw new IllegalArgumentException("Invalid invoice type. The valid invoice type: 'PI' (Paper invoice), 'EI' (E-invoice)");
            }

            // Check the validation for invoice lines
            if (header.getInvoiceLines() != null && !header.getInvoiceLines().isEmpty()) {
                for (InvoiceLine line : header.getInvoiceLines()) {
                    line.setInvoiceHeaderId(header.getInvoiceHeaderId());  // Set foreign key
                    // Check Validate the line
                    if (line.getUnitPrice() == null || line.getQuantity() == null) {
                        throw new IllegalArgumentException("Unit price and quantity must not be null.");
                    }
                    line.setTotalAmount(line.getUnitPrice().multiply(BigDecimal.valueOf(line.getQuantity())));
                    lineMapper.saveUpdate(line);  // Save or update the line
                }
            }

            if (header.getInvoiceNumber() == null) {
                // Create UUID for new invoice
                String invoiceNumber = UUID.randomUUID().toString();
                header.setInvoiceNumber(invoiceNumber);
            } else {
                // Check the invoice number before updating
                InvoiceHeader existingHeader = headerMapper.findById(header.getInvoiceHeaderId());
                if (!existingHeader.getInvoiceNumber().equals(header.getInvoiceNumber())) {
                    // invoice number is different
                    throw new IllegalArgumentException("Invoice number cannot be modified.");
                }
            }

            // Update amount
            Long invoiceHeaderId = header.getInvoiceHeaderId();
            BigDecimal totalAmount = lineMapper.calculateTotalAmount(invoiceHeaderId);
            headerMapper.updateTotal(invoiceHeaderId, totalAmount);

            // Save or update invoice header
            headerMapper.saveUpdate(header);
        }
        return invoiceHeaders;
    }
}
