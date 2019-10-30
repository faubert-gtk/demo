package com.example.demo.services;

import com.example.demo.entity.Bank;
import com.example.demo.interfaces.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Component("BankServiceImpl")
public class BankServiceImpl implements IBankService {

    private ArrayList<Bank> bankList;

    @Autowired
    public BankServiceImpl(){
        bankList = new ArrayList<Bank>();
        Bank newBank = new Bank("Sberbank", "000000001");
        bankList.add(newBank);
        newBank = new Bank("VTB24","000000002");
        bankList.add(newBank);
        newBank = new Bank("Tinkoff","000000003");
        bankList.add(newBank);
    }

    public Bank saveBank(String name, String bik)
    {
        Bank saveBank = new Bank(name, bik);
        bankList.add(saveBank);
        return saveBank;
    }

    public Bank findById(UUID id)
    {
        return bankList.stream().filter((w) -> w.getId().equals(id)).findFirst().get();
    }

    public Bank updateBank(Bank bank)
    {
        if (bankList.stream().anyMatch((b) -> b.getId().equals(bank.getId()))) {
            bankList.stream()
                    .filter((b) -> b.getId().equals(bank.getId()))
                    .findFirst()
                    .get()
                    .updateBank(bank.getName(), bank.getBik());
            return bankList.stream()
                    .filter((b) -> b.getId().equals(bank.getId()))
                    .findFirst()
                    .get();
        }
        else
            return null;
    }

    public void deleteById(UUID id)
    {
        Bank deleteBank = bankList.stream()
                .filter((b)->b.getId().equals(id))
                .findFirst()
                .get();
        bankList.remove(deleteBank);
    }

    public void deleteAll()
    {
        bankList.clear();
    }

    public List<Bank> getBanksListSorted()
    {
        return bankList.stream()
                .sorted(Comparator.comparing(Bank::getName))
                .collect(Collectors.toList());
    }
}
