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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "connection_unit")
public class ConnectionUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private Node node;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "connectionUnit", cascade = CascadeType.ALL)
    private Set<Point> points = new HashSet<>();

    public Long getId() {
        return id;
    }

    public ConnectionUnit setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ConnectionUnit setTitle(String title) {
        this.title = title;
        return this;
    }

    public Node getNode() {
        return node;
    }

    public ConnectionUnit setNode(Node node) {
        this.node = node;
        return this;
    }

    public Set<Point> getPoints() {
        return points;
    }

    public ConnectionUnit setPoints(Set<Point> points) {
        this.points = points;
        return this;
    }
}
