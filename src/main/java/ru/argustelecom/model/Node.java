package ru.argustelecom.model;

import ru.argustelecom.model.absracts.NamedEntityObject;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Table(name = "node")
public class Node extends NamedEntityObject {

    @Column(name = "region")
    private String region;

    @Column(name = "street")
    private String street;

    @Column(name = "building")
    private String building;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "node")
    private Set<ConnectionUnit> connectionUnits;

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
