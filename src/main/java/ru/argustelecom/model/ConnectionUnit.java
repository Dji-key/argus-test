package ru.argustelecom.model;

import ru.argustelecom.model.absracts.NamedEntityObject;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Table(name = "connection_unit")
public class ConnectionUnit extends NamedEntityObject {

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Node node;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "connection_unit")
    private Set<Point> points;

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
