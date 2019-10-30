package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "Clients")
public class Client
{
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "shortName", nullable = false)
    private String shortName;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "organizationForm", nullable = false)
    private String organizationForm;

    public Client(){}

    public Client(String name, String shortName, String address, String organizationForm)
    {
        this.id = UUID.randomUUID();
        this.name = name;
        this.shortName = shortName;
        this.address = address;
        this.organizationForm = organizationForm;
    }

    public UUID getId()
    {
        return id;
    }

    public void setId(UUID id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getShortName()
    {
        return shortName;
    }

    public void setShortName(String shortName)
    {
        this.shortName = shortName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getOrganizationForm()
    {
        return organizationForm;
    }

    public void setOrganizationForm(String organizationForm)
    {
        this.organizationForm = organizationForm;
    }

    public void updateClient(String name, String shortName, String address, String organizationForm)
    {
        this.name = name;
        this.shortName = shortName;
        this.address = address;
        this.organizationForm = organizationForm;
    }

}
