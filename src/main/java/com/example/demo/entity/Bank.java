package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "Banks")
public class Bank
{
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "bik", nullable = false)
    private String bik;

    public Bank(){}

    public Bank(String name, String bik)
    {
        this.id = UUID.randomUUID();
        this.name = name;
        this.bik = bik;
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

    public String getBik()
    {
        return bik;
    }

    public void setBik(String bik)
    {
        this.bik = bik;
    }

    public void updateBank(String name, String bik)
    {
        this.name = name;
        this.bik = bik;
    }
}
