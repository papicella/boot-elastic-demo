package com.example.elastic.demo.repo;

import com.example.elastic.demo.indices.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends ElasticsearchRepository <Car, String> {

    Page<Car> findByMakeContaining(String make, Pageable page);

}
