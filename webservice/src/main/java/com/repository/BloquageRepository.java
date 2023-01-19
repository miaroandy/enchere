package com.repository;

import com.models.Bloquage;
import org.springframework.data.repository.CrudRepository;

public interface BloquageRepository  extends CrudRepository<Bloquage,Integer> {

    Bloquage findBloquageByIdproduit(int idProduit);
}
