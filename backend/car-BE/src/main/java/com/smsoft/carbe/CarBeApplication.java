package com.smsoft.carbe;

import com.smsoft.carbe.domain.Car;
import com.smsoft.carbe.domain.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CarBeApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CarBeApplication.class);

    @Autowired
    private CarRepository carRepository;

    public static void main(String[] args) {
        SpringApplication.run(CarBeApplication.class, args);
        logger.info("Application Started");
    }

    @Override
    public void run(String... args) throws Exception {
        carRepository.save(Car.builder()
                .brand("Ford")
                .model("Mustang")
                .color("Blue")
                .registerNumber("ABC-1234")
                .manufactureYear(2024)
                .price(7000)
                .build());

        carRepository.save(Car.builder()
                .brand("Toyota")
                .model("Camry")
                .color("White")
                .registerNumber("XYZ-5678")
                .manufactureYear(2020)
                .price(2500)
                .build());

        carRepository.save(Car.builder()
                .brand("Honda")
                .model("Civic")
                .color("Red")
                .registerNumber("DEF-9876")
                .manufactureYear(2022)
                .price(2200)
                .build());

        for(Car car : carRepository.findAll()) {
            logger.info(car.getBrand() + " " + car.getModel() + " " + car.getColor());
        }
    }
}
