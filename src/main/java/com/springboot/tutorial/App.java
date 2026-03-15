package com.springboot.tutorial;

import com.springboot.tutorial.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.File;

@SpringBootApplication
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        SpringApplication.run(App.class, args);
        final Logger logger = LoggerFactory.getLogger(App.class);
        logger.info(" ");

        ObjectMapper mapper = new ObjectMapper();

        Product product = new Product(1L, "Laptop", 2500);

        /* Serialization + Pretty print */
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(product);
        logger.info("{}", json);
        String pathJson = "D:\\Java\\SpringBoot\\Json\\";
        mapper.writeValue(new File(pathJson + "product.json"), product);

    }
}
