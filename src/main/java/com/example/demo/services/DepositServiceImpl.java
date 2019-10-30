package com.example.demo.services;

import com.example.demo.entity.Client;
import com.example.demo.entity.Bank;
import com.example.demo.entity.Deposit;
import com.example.demo.interfaces.IDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Component("DepositServiceImpl")
public class DepositServiceImpl implements IDepositService
{

    private ArrayList<Deposit> depositsList;

    @Autowired
    public DepositServiceImpl()
    {
        depositsList = new ArrayList<Deposit>();
        Client newClient = new Client("Jones Stock Company", "Jones Stock","Born","CJSC");
        Bank newBank = new Bank("Sberbank", "000000001");
        Deposit newDeposit = new Deposit(newClient.getId(), newBank.getId(), 12.0,24);
        depositsList.add(newDeposit);

        newClient = new Client("Woodstock Company","Woodstock","Moscow","LLC");
        newBank = new Bank("VTB24","000000002");
        newDeposit = new Deposit(newClient.getId(), newBank.getId(), 7.4,12);
        depositsList.add(newDeposit);

        newClient = new Client("Bladberry Fund","Bladberry","Philippines","Fund");
        newBank = new Bank("Tinkoff","000000003");
        newDeposit = new Deposit(newClient.getId(), newBank.getId(), 4.4, 6);

        depositsList.add(newDeposit);
    }

    public Deposit findById(UUID id)
    {
        return depositsList.stream()
                .filter((d) -> d.getId().equals(id))
                .findFirst()
                .get();
    }


    public void deleteById(UUID id)
    {
        Deposit deleteDeposit = depositsList.stream()
                .filter((d)->d.getId().equals(id))
                .findFirst()
                .get();
        depositsList.remove(deleteDeposit);
    }

    public void deleteAll()
    {
        depositsList.clear();
    }

    public List<Deposit> getDepositsListSorted()
    {
        return depositsList.stream()
                .sorted(Comparator.comparingDouble(Deposit::getPercent))
                .collect(Collectors.toList());
    }
}
