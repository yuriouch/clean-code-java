package com.epam.engx.cleancode.naming;

import com.epam.engx.cleancode.naming.thirdpartyjar.Order;
import com.epam.engx.cleancode.naming.thirdpartyjar.Submitable;

public interface IOrderService  extends Submitable {
    void submitOrder(Order pOrder);
}
