package com.ebaez.springpractice.persistence.crud;

import com.ebaez.springpractice.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    //Utilizando query methods
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    //Utilizando queries nativos
    /*@Query(name = "SELECT * FROM productos WHERE id_categoria= ?", nativeQuery = true)
    List<Producto> getByCategoria(int idCategoria);*/

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
