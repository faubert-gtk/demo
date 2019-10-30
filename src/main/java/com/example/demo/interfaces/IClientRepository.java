package com.example.demo.interfaces;

import java.util.UUID;
import com.example.demo.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends CrudRepository<Client, UUID> {}
