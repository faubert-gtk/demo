package com.example.demo.conrollers;

import com.example.demo.entity.Client;
import com.example.demo.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController
{

    private IClientService clService;

    @Autowired
    public ClientController(@Qualifier("ClientServiceImpl") IClientService clList)
    {
        this.clService = clList;
    }

    @PostMapping("/newClient")
    public ResponseEntity<Client> newClient(@RequestParam String name, String shortName, String address, String organizationForm)
    {
        try
        {
            Client newClient = clService.saveClient(name, shortName, address, organizationForm);
            return ResponseEntity.ok(newClient);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> getClientById(@PathVariable UUID id)
    {
        try
        {
            Client client = clService.findById(id);
            return ResponseEntity.ok(client);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/updateClient")
    public ResponseEntity<Client> updateClient(@RequestParam UUID id, String name, String shortName, String address, String organizationForm)
    {
        Client client = new Client();
        client.setId(id);
        client.setName(name);
        client.setShortName(shortName);
        client.setAddress(address);
        client.setOrganizationForm(organizationForm);
        try
        {
            Client updatedClient = clService.updateClient(client);
            return ResponseEntity.ok(updatedClient);
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable UUID id)
    {
        try
        {
            clService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getClientsSorted")
    public ResponseEntity<List<Client>> getBanksListSorted()
    {
        try
        {
            List<Client> sortedClientsList = clService.getClientsListSorted();
            return ResponseEntity.ok(sortedClientsList);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
