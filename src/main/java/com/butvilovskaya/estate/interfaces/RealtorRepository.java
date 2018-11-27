package com.butvilovskaya.estate.interfaces;

import com.butvilovskaya.estate.models.Realtor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RealtorRepository extends CrudRepository<Realtor, Integer> {

    List<Realtor> findByName(String name);
}