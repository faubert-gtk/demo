package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Deposits")
public class Deposit
{
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "client", nullable = false)
    private UUID client;
    @Column(name = "bank", nullable = false)
    private UUID bank;
    @Column(name = "dataCreated", nullable = false)
    private Date dataCreated;
    @Column(name = "percent", nullable = false)
    private Double percent;
    @Column(name = "term", nullable = false)
    private Integer term;

    public Deposit(){}

    public Deposit(UUID client, UUID bank, Double percent, Integer term)
    {
        this.id = UUID.randomUUID();
        this.client = client;
        this.bank = bank;
        this.dataCreated = new Date();
        this.percent = percent;
        this.term = term;
    }
    public UUID getId()
    {
        return id;
    }

    public void setId(UUID id)
    {
        this.id = id;
    }

    public UUID getClient()
    {
        return client;
    }

    public void setClient(UUID client)
    {
        this.client = client;
    }

    public UUID getBank()
    {
        return bank;
    }

    public void setBank(UUID bank)
    {
        this.bank = bank;
    }

    public Date getDataCreated()
    {
        return this.dataCreated;
    }

    public  void setDataCreated(Date dataCreated)
    {
        this.dataCreated = dataCreated;
    }

    public Double getPercent()
    {
        return percent;
    }

    public void setPercent(Double percent)
    {
        this.percent = percent;
    }
    public Integer getTerm()
    {
        return term;
    }

    public void setTerm(Integer term)
    {
        this.term = term;
    }

    public void updateDeposit(UUID client, UUID bank, Date dataCreated, Double percent, Integer term)
    {
        this.client = client;
        this.bank = bank;
        this.dataCreated = dataCreated;
        this.percent = percent;
        this.term = term;
    }
}