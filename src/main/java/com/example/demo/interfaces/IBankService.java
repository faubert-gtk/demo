package com.example.demo.interfaces;

import java.util.List;
import java.util.UUID;
import com.example.demo.entity.Bank;

public interface IBankService
{
    Bank saveBank(String name, String bik);

    Bank findById(UUID id);

    Bank updateBank(Bank bank);

    void deleteById(UUID id);

    void deleteAll();

    List<Bank> getBanksListSorted();

}
