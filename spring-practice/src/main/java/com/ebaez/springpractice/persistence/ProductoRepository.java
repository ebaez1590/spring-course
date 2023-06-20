package com.ebaez.springpractice.persistence;

import com.ebaez.springpractice.domain.Product;
import com.ebaez.springpractice.domain.repository.ProductRepository;
import com.ebaez.springpractice.persistence.crud.ProductoCrudRepository;
import com.ebaez.springpractice.persistence.entity.Producto;
import com.ebaez.springpractice.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
//Con Repository le indicamos a spring que esta clase interactua con la bdd
//Repository es equivalente a usar @Component
@Repository
public class ProductoRepository implements ProductRepository {
    //El objetivo principal es que el repository quede enfocado al dominio y no a una tabla de la bdd específica.
    //Orientar nuestro repositorio a términos de dominio
    //Ocupar el contenedor de spring de inversión de control
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        //La arrow function recibe productos y retorna products
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
       return  productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
