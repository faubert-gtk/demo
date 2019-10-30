package com.example.demo.interfaces;

import java.util.UUID;
import com.example.demo.entity.Deposit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepositRepository extends CrudRepository<Deposit, UUID> {}
