package com.dbproject.repository;

import com.dbproject.Models.Credentials;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CredentailRepository extends JpaRepository<Credentials,String> {
    Credentials findByUsername(String username);
    Credentials findByPassword(String password);
    Credentials findByEmail(String email);
   // List<Credentials> findAll();
    Credentials findByUsernameAndPassword(String username , String password);

        boolean existsByUsername(String username);
        boolean existsByEmail(String email);


}
