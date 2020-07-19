package ru.argustelecom.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "node")
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "region")
    private String region;

    @Column(name = "street")
    private String street;

    @Column(name = "building")
    private String building;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "node", cascade = CascadeType.ALL)
    private Set<ConnectionUnit> connectionUnits = new HashSet<>();

    public Long getId() {
        return id;
    }

    public Node setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Node setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public Node setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Node setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getBuilding() {
        return building;
    }

    public Node setBuilding(String building) {
        this.building = building;
        return this;
    }

    public Set<ConnectionUnit> getConnectionUnits() {
        return connectionUnits;
    }

    public Node setConnectionUnits(Set<ConnectionUnit> connectionUnits) {
        this.connectionUnits = connectionUnits;
        return this;
    }
}
