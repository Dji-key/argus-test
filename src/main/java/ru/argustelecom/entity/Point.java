package ru.argustelecom.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "point")
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id")
    private ConnectionUnit connectionUnit;

    @OneToOne
    private Point connected;

    public Long getId() {
        return id;
    }

    public Point setId(Long id) {
        this.id = id;
        return this;
    }

    public ConnectionUnit getConnectionUnit() {
        return connectionUnit;
    }

    public Point setConnectionUnit(ConnectionUnit connectionUnit) {
        this.connectionUnit = connectionUnit;
        return this;
    }

    public Point getConnected() {
        return connected;
    }

    public Point setConnected(Point connected) {
        this.connected = connected;
        return this;
    }
}
