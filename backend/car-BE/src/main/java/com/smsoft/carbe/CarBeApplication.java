package com.smsoft.carbe;

import com.smsoft.carbe.domain.Car;
import com.smsoft.carbe.domain.CarRepository;
import com.smsoft.carbe.domain.Owner;
import com.smsoft.carbe.domain.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@SpringBootApplication
public class CarBeApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CarBeApplication.class);

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    public static void main(String[] args) {
        SpringApplication.run(CarBeApplication.class, args);
        logger.info("Application Started");
    }

    @Override
    public void run(String... args) throws Exception {
        // 소유자
        Owner owner1 = Owner.builder()
                .firstName("kim")
                .lastName("sumin")
                .build();

        Owner owner2 = Owner.builder()
                .firstName("bong")
                .lastName("juhee")
                .build();

        ownerRepository.saveAll(Arrays.asList(owner1, owner2));

        Car car1 = Car.builder()
                .brand("Ford")
                .model("Mustang")
                .color("Blue")
                .registerNumber("ABC-1234")
                .manufactureYear(2024)
                .price(7000)
                .owner(owner1)
                .build();

        Car car2 = Car.builder()
                .brand("Toyota")
                .model("Camry")
                .color("White")
                .registerNumber("XYZ-5678")
                .manufactureYear(2020)
                .price(2500)
                .owner(owner2)
                .build();

        Car car3 = Car.builder()
                .brand("Honda")
                .model("Civic")
                .color("Red")
                .registerNumber("DEF-9876")
                .manufactureYear(2022)
                .price(2200)
                .owner(owner2)
                .build();

        carRepository.saveAll(Arrays.asList(car1, car2, car3));

        for(Car car : carRepository.findAll()) {
            logger.info(car.getBrand() + " " + car.getModel() + " " + car.getColor());
        }
    }
}
