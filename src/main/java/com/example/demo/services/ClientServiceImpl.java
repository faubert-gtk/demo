package com.example.demo.services;

import com.example.demo.entity.Client;
import com.example.demo.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Component("ClientServiceImpl")
public class ClientServiceImpl implements IClientService
{

    private ArrayList<Client> clientList;
    private HashSet<String> organizationFormSet;

    @Autowired
    public ClientServiceImpl()
    {
        setOrganizationForm();
        clientList = new ArrayList<Client>();
        Client newClient = new Client("Jones Stock Company", "Jones Stock","Born","CJSC");
        clientList.add(newClient);
        newClient = new Client("Woodstock Company","Woodstock","Moscow","LLC");
        clientList.add(newClient);
        newClient = new Client("Bladberry Fund","Bladberry","Philippines","Fund");
        clientList.add(newClient);
    }

    private void setOrganizationForm()
    {
        organizationFormSet = new HashSet<>();
        organizationFormSet.add("CJSC");
        organizationFormSet.add("LLC");
        organizationFormSet.add("Fund");
        organizationFormSet.add("Institution");
    }
    public Client saveClient(String name, String shortName, String address, String organizationForm)
    {
        if (organizationFormSet.contains(organizationForm))
        {
            Client saveClient = new Client(name, shortName, address, organizationForm);
            clientList.add(saveClient);
            return saveClient;
        }
        return null;
    }

    public Client findById(UUID id)
    {
        return clientList.stream()
                .filter((c) -> c.getId().equals(id))
                .findFirst()
                .get();
    }

    public Client updateClient(Client client)
    {
        if (clientList.stream().anyMatch((c) -> c.getId().equals(client.getId())) && organizationFormSet.contains(client.getOrganizationForm())) {
            clientList.stream()
                    .filter((c) -> c.getId().equals(client.getId()))
                    .findFirst()
                    .get()
                    .updateClient(client.getName(), client.getShortName(), client.getAddress(), client.getOrganizationForm());
            return clientList.stream()
                    .filter((c) -> c.getId().equals(client.getId()))
                    .findFirst()
                    .get();
        }
        else
            return null;
    }

    public void deleteById(UUID id)
    {
        Client deleteClient = clientList.stream()
                .filter((c)->c.getId().equals(id))
                .findFirst()
                .get();
        clientList.remove(deleteClient);
    }

    public void deleteAll()
    {
        clientList.clear();
    }

    public List<Client> getClientsListSorted()
    {
        return clientList.stream()
                .sorted(Comparator.comparing(Client::getName))
                .collect(Collectors.toList());
    }
}
