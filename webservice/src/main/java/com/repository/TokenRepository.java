package com.repository;
import org.springframework.data.repository.CrudRepository;
import com.models.Token;

public interface TokenRepository extends CrudRepository<Token, Integer>{

}
