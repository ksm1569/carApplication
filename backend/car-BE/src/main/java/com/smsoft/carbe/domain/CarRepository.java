package com.smsoft.carbe.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    // 브랜드로 car 객체 가져오기
    List<Car> findByBrand(String brand);

    // 색상으로 car 객체 가져오기
    List<Car> findByColor(String color);

    // 연도로 car 객체 가져오기
    List<Car> findByYear(int year);

    // 브랜드와 모델로 car 객체 가져오기
    List<Car> findByBrandAndModel(String brand, String model);

    // 브랜드나 색상으로 car 객체 가져오기
    List<Car> findByBrandOrColor(String brand, String color);

    // 브랜드로 검색 후 연도 역순으로 정렬해서 가져오기
    List<Car> findByBrandOrderByYearDesc(String brand);

    // SQL문을 이용해서 브랜드로 자동차를 검색
    @Query("select c from Car c where c.brand = ?1")
    List<Car> findByBrandUsingSql(String brand);

    // SQL문을 이용해 브랜드로 자동차를 검색(like문)
    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrandEndsWith(String brand);
}
