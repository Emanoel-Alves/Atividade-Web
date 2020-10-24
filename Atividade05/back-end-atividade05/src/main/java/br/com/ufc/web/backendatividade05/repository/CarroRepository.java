package br.com.ufc.web.backendatividade05.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ufc.web.backendatividade05.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Integer>  {
	
	@Query(value = "SELECT * FROM carros WHERE marca = :marca", nativeQuery=true)
	List<Carro> findByMarca(@Param("marca")String marca);
	
	@Query(value = "SELECT * FROM carros LIMIT :quantity", nativeQuery=true)
	List<Carro> findByQuantity(@Param("quantity")Integer quantity);
	
	
}
