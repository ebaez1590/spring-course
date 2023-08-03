package com.ebaez.pizza.persistence.repository;

import com.ebaez.pizza.persistence.entity.PizzaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface PizzaPagSortRepository extends ListPagingAndSortingRepository<PizzaEntity, Integer> {
    //El findBy funciona igual que el findAllBy
    Page<PizzaEntity> findByAvailableTrue(Pageable pageable);
}
