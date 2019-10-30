package com.example.demo.conrollers;

import com.example.demo.entity.Bank;
import com.example.demo.interfaces.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bank")
public class BankController
{

    private IBankService bkService;

    @Autowired
    public BankController(@Qualifier("BankServiceImpl") IBankService bkList)
    {
        this.bkService = bkList;
    }

    @PostMapping("/newBank")
    public ResponseEntity<Bank> newBank(@RequestParam String name, String bik)
    {
        try
        {
            Bank newBank = bkService.saveBank(name, bik);
            return ResponseEntity.ok(newBank);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Bank> getBankById(@PathVariable UUID id)
    {
        try
        {
            Bank bank = bkService.findById(id);
            return ResponseEntity.ok(bank);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping("/updateBank")
    public ResponseEntity<Bank> updateBank(@RequestParam UUID id, String name, String bik)
    {
        Bank bank = new Bank();
        bank.setId(id);
        bank.setName(name);
        bank.setBik(bik);
        try
        {
            Bank updatedBank = bkService.updateBank(bank);
            return ResponseEntity.ok(updatedBank);
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable UUID id)
    {
        try
        {
            bkService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getBanksSorted")
    public ResponseEntity<List<Bank>> getBanksListSorted()
    {
        try
        {
            List<Bank> sortedBanksList = bkService.getBanksListSorted();
            return ResponseEntity.ok(sortedBanksList);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
