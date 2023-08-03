package com.ebaez.pizza.persistence.repository;

import com.ebaez.pizza.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {
    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
    //PizzaEntity findAllByAvailableTrueAndNameIgnoreCase(String name);
    //Con el findFirst o FindTop me aseguro que solo traiga un registro
    Optional<PizzaEntity> findFirstByAvailableTrueAndNameIgnoreCase(String name);
    //findAllBy = getAllBy = queryBy = searchAllBy -> por convención usamos findAllBy
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainsIgnoreCase(String description);
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainsIgnoreCase(String description);
    List<PizzaEntity> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double price);
    int countByVeganTrue();
}
