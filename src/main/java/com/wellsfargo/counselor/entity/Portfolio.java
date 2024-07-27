package com.wellsfargo.counselor.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue()
    private Integer portfolioId;

    @OneToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    @OneToMany(mappedBy = "portfolio")
    @JsonManagedReference
    private Set<Security> securities;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    protected Portfolio() {
    }

    public Portfolio(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getPortfolioId() {
        return portfolioId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(Set<Security> securities) {
        this.securities = securities;
    }
}
