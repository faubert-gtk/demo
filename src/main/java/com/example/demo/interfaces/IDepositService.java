package com.example.demo.interfaces;

import com.example.demo.entity.Bank;
import com.example.demo.entity.Client;
import com.example.demo.entity.Deposit;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface IDepositService
{

     Deposit findById(UUID id);

     void deleteById(UUID id);

     void deleteAll();

     List<Deposit> getDepositsListSorted();
}
