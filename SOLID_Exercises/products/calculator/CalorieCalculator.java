package SOLID_Exercises.products.calculator;


import SOLID_Exercises.products.Product;

import java.util.List;

public class CalorieCalculator implements Calculator {



    @Override
    public double calculateTotal(List<Product> products) {
        return products.stream().mapToDouble(Product::getCalories).sum();
    }


    @Override
    public double calculateAverage( List<Product> products) {
        return calculateTotal(products) / products.size();
    }

}
