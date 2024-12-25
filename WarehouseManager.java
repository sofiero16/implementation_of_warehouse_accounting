package ru.view.console;

import java.util.HashMap;
import java.util.Map;

public class WarehouseManager {
    private Map<String, Product> products;

    public WarehouseManager() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (products.containsKey(product.getName())) {
            products.get(product.getName()).setQuantity(products.get(product.getName()).getQuantity() + product.getQuantity());
        } else {
            products.put(product.getName(), product);
        }
    }

    public void removeProduct(String name, int quantity) {
        if (products.containsKey(name)) {
            Product product = products.get(name);
            if (product.getQuantity() >= quantity) {
                product.setQuantity(product.getQuantity() - quantity);
                if (product.getQuantity() == 0) {
                    products.remove(name);
                }
            } else {
                System.out.println("Недостаточное количество " + name + " на складе.");
            }
        } else {
            System.out.println("Продукт " + name + " не найден на складе.");
        }
    }

    public void displayProducts() {
        for (Product product : products.values()) {
            System.out.println(product.getName() + " - Количество: " + product.getQuantity() + ", Цена: " + product.getPrice());
        }
    }
}
