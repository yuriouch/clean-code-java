package com.epam.engx.cleancode.functions.task2;

import com.epam.engx.cleancode.functions.task2.thirdpartyjar.Product;

import java.util.List;

public class Order {

    private List<Product> products;

    public double getPriceOfAvailableProducts() {
        double totalPrice = 0.0;
        for (Product product : products) {
            if (product.isAvailable()) {
                totalPrice += product.getProductPrice();
            }
        }
        return totalPrice;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
