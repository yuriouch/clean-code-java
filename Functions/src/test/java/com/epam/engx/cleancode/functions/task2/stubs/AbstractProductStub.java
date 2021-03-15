package com.epam.engx.cleancode.functions.task2.stubs;

import com.epam.engx.cleancode.functions.task2.thirdpartyjar.Product;

public abstract class AbstractProductStub implements Product {
    @Override
    public double getProductPrice() {
        return 10;
    }

}
