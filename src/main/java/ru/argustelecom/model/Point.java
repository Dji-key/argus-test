package ru.argustelecom.model;

import ru.argustelecom.model.absracts.EntityObject;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "point")
public class Point extends EntityObject {

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ConnectionUnit connectionUnit;

    public ConnectionUnit getConnectionUnit() {
        return connectionUnit;
    }

    public Point setConnectionUnit(ConnectionUnit connectionUnit) {
        this.connectionUnit = connectionUnit;
        return this;
    }
}
