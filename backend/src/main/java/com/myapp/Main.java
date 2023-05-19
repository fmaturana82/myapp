package com.myapp;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.myapp.domain.Customer;
import com.myapp.domain.Gender;
import com.myapp.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.relational.core.sql.In;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import net.logstash.logback.marker.Markers;

//import static net.logstash.logback.argument.StructuredArguments.kv;
import static net.logstash.logback.argument.StructuredArguments.v;
import static net.logstash.logback.marker.Markers.*;
import static net.logstash.logback.argument.StructuredArguments.*;

@SpringBootApplication
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        return args -> createRandomCustomer(customerRepository, passwordEncoder);
    }

    private static void createRandomCustomer(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        var faker = new Faker();
        Random random = new Random();
        Name name = faker.name();
        String firstName = name.firstName();
        String lastName = name.lastName();
        int age = random.nextInt(16, 99);
        Gender gender = age % 2 == 0 ? Gender.MALE : Gender.FEMALE;
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@amigoscode.com";
        Customer customer = new Customer(
                firstName +  " " + lastName,
                email,
                passwordEncoder.encode("password"),
                age,
                gender);
        customerRepository.save(customer);

        //LOGGER.info("Customer is saved", kv("id", customer.getId()), kv("email", customer.getEmail()));
        //Map myMap = new HashMap();
        //myMap.put("trace_id", "value1");
        //myMap.put("name2", "value2");
        //LOGGER.info(appendEntries(myMap), "log message 1");

        //LOGGER.info(append("Customer is saved 2", kv("id", customer.getEmail())), "log messagexxxx");
        //LOGGER.info("log message 3 {}", fields( kv("trace_id", customer.getId())));

    }

}
