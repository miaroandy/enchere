package com.service;

import com.models.Data;
import com.models.Error;
import com.models.Token;
import com.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TokenService {
    @Autowired
    TokenRepository repository;


    public Object getTokenById(String id)
    {
        try {
            List<Token> user = new ArrayList<Token>();
            repository.findAll().forEach(user1 -> user.add(user1));
            for (int i = 0; i < user.size(); i++) {
                if(user.get(i).getToken().compareTo(id)==0)
                    return new Data(user.get(i));
            }
            return new Data(null);
        }
        catch (Exception e){
            return new Error(e);
        }
    }

    public void deconnexion(String token){
        Data dt = (Data)this.getTokenById(token);
        Token tkn= (Token) dt.getData();
        tkn.setDatexpiration(Token.getDateNow());
        repository.save(tkn);
    }

    public Object getAllToken(){
        try {
            List<Token> user = new ArrayList<Token>();
            repository.findAll().forEach(user1 -> user.add(user1));
            return new Data(user);
        }
        catch (Exception e){
            return new Error(e);
        }
    }

    public void saveToken(Token token)
    {
        repository.save(token);
    }
}
