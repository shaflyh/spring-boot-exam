package com.hand.training.util;

import java.util.Set;
import java.util.HashSet;

public class Constants {
    public static final Set<String> VALID_STATUSES = new HashSet<String>() {{
        add("D");  // Draft
        add("S");  // Success
        add("F");  // Failed
        add("C");  // Canceled
    }};

    public static final Set<String> VALID_INVOICE_TYPES = new HashSet<String>() {{
        add("PI"); // Paper invoice
        add("EI"); // E-invoice
    }};
}