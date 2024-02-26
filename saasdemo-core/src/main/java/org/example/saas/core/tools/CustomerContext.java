package org.example.saas.core.tools;


import org.example.saas.core.domain.dto.CustomerDTO;

public class CustomerContext {
    private static ThreadLocal<CustomerDTO> cachedCustomer = new ThreadLocal<>();

    public static void setCustomer(CustomerDTO customer) {
        cachedCustomer.set(customer);
    }

    public static CustomerDTO getCustomer() {
        return cachedCustomer.get();
    }
}
