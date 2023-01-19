package com.repository;
import org.springframework.data.repository.CrudRepository;
import com.models.Utilisateur;

public interface UserRepository extends CrudRepository<Utilisateur, Integer>{

}
