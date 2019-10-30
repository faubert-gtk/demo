package com.example.demo.interfaces;

import java.util.UUID;
import com.example.demo.entity.Bank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBankRepository extends CrudRepository<Bank, UUID> {}
