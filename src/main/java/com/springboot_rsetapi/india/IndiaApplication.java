package com.springboot_rsetapi.india;


import com.springboot_rsetapi.india.entity.Employee;
import com.springboot_rsetapi.india.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//public class IndiaApplication implements CommandLineRunner {
public class IndiaApplication {
    public static void main(String[] args) {

        SpringApplication.run(IndiaApplication.class, args);
    }
}
//    @Autowired
//    private EmployeeRepository employeeRepository;

//    @Override
//    public void run(String... args) throws Exception {
//        Employee employee1 = new Employee("Ivan", "Petrov", "ivan@gmail.com");
//        employeeRepository.save(employee1);
//
//        Employee employee2 = new Employee("Igor", "Ivanov", "igor@gmail.com");
//        employeeRepository.save(employee2);
//
//        Employee employee3 = new Employee("Petr", "Smirnov", "petr@gmail.com");
//        employeeRepository.save(employee3);
//
//        Employee employee4 = new Employee("Tom", "Cruse", "tom@gmail.com");
//        employeeRepository.save(employee4);
//
//        Employee employee5 = new Employee("Misha", "Dmitrieev", "misha@gmail.com");
//        employeeRepository.save(employee5);
//
//    }
//}
