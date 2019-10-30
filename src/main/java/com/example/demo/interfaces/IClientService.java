package com.example.demo.interfaces;

import com.example.demo.entity.Client;
import java.util.List;
import java.util.UUID;

public interface IClientService
{
    Client saveClient(String name, String shortName, String address, String organizationForm);

    Client findById(UUID id);

    Client updateClient(Client client);

    void deleteById(UUID id);

    void deleteAll();

    List<Client> getClientsListSorted();
}
