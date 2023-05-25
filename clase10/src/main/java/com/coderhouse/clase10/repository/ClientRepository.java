package com.coderhouse.clase10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.coderhouse.clase10.model.Client;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    //Custom query by method name
    List<Client> findByNameLike(String name);

    //Custom query by custom JPQL query.
    //Atentos con Client, así se llama la entidad en nuestro programa.
    @Query("SELECT a FROM Client a WHERE name = :nombre ORDER BY lastname ASC")
    List<Client> getByNameOrderedByLastnameJPQL(@Param("nombre") String name);
}
