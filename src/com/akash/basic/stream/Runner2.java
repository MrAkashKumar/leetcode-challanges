package com.akash.basic.stream;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Runner2 {

    static class  Product {

        private String name;
        private double price;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public double getPrice() {
            return price;
        }
        public void setPrice(double price) {
            this.price = price;
        }

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
        
        @Override
        public String toString() {
            return "Product [name=" + name + ", price=" + price + "]";
        }        
        
    }

    public static void main(String[] args) {
        
        List<Product> productsList = Arrays.asList(new Product("laptop", 100), 
        new Product("mobile", 200),
        new Product("mobile", 50)
        );
        
        findProductIfSamePriceThenSumAndReturnNewMap(productsList);
    }

    private static void findProductIfSamePriceThenSumAndReturnNewMap(List<Product> productsList){

        TreeMap<String, Double> treeMap = productsList.stream().collect(Collectors.toMap(Product::getName, Product::getPrice, Double::sum, TreeMap::new));
        System.out.println(treeMap);

    }
    
}
