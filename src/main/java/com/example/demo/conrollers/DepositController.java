package com.example.demo.conrollers;

import com.example.demo.entity.Client;
import com.example.demo.entity.Bank;
import com.example.demo.entity.Deposit;
import com.example.demo.interfaces.IDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/deposit")
public class DepositController
{

    private IDepositService dpService;

    @Autowired
    public DepositController(@Qualifier("DepositServiceImpl") IDepositService dpList)
    {
        this.dpService = dpList;
    }

    @GetMapping("{id}")
    public ResponseEntity<Deposit> getDepositById(@PathVariable UUID id)
    {
        try
        {
            Deposit deposit = dpService.findById(id);
            return ResponseEntity.ok(deposit);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDeposit(@PathVariable UUID id)
    {
        try
        {
            dpService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getDepositsSorted")
    public ResponseEntity<List<Deposit>> getDepositsListSorted()
    {
        try
        {
            List<Deposit> sortedDepositsList = dpService.getDepositsListSorted();
            return ResponseEntity.ok(sortedDepositsList);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
