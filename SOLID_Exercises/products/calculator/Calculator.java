package SOLID_Exercises.products.calculator;


import SOLID_Exercises.products.Product;

import java.util.List;

public interface Calculator {

    double calculateTotal(List<Product> products);
    double calculateAverage(List<Product> products);
}
