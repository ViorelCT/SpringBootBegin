package com.mavendemo;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        ProductService service = new ProductService();

        service.addProduct(new Product(1L, "Laptop", 4000));
        service.addProduct(new Product(2L, "Mouse", 100));
        service.addProduct(new Product(3L, "Monitor", 1500));

        System.out.println("All products:");
        service.getAllProducts().forEach(System.out::println);

        System.out.println("\nProduct with id 1:");
        try {
            System.out.println(service.getProductById(1L));
        } catch (ProductNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nProducts above 1000:");
        List<Product> expensive = service.getProductsAbovePrice(1000);
        expensive.forEach(System.out::println);

        System.out.println("\nDeleting product 2...");
        service.deleteProduct(2L);

        System.out.println("\nAll products after delete:");
        service.getAllProducts().forEach(System.out::println);

        service.addProduct(new Product(2L, "MousePad", 50));
        System.out.println("\nProduct with id 2 is: " + service.getProductNameByID(2L));

        System.out.println("\nProduct with price 4000 is: " + service.getProductNamesByPrice(4000));


    }
}
