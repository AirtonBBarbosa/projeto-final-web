package com.gestaofacil.GestaoFacil.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gestaofacil.GestaoFacil.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> { //Fornece métodos CRUD
  
    Usuario findById(long id);

    @Query(value="select * from db_testedasilva.usuario where email = :email and senha = :senha", nativeQuery = true)
    public Usuario login(String email, String senha);

}
