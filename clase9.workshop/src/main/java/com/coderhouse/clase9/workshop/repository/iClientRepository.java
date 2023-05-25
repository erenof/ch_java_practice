package com.coderhouse.clase9.workshop.repository;

import com.coderhouse.clase9.workshop.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface iClientRepository extends JpaRepository<Client, Integer> {

    //Custom query by method name
    List<Client> findByNameLike(String name);

    //Custom query usando JPQL
    //Client es la entidad en nuestro programa.
    @Query("SELECT a FROM Client a WHERE name = :nombre ORDER BY lastname ASC ")
    List<Client> getByNameOrderedByLastNameJPQL(@Param("nombre") String name);


}
