package ru.argustelecom.model;

import ru.argustelecom.model.absracts.EntityObject;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "link")
public class Link extends EntityObject {

    @Column(name = "in")
    private Point inlet;

    @Column(name = "out")
    private Point out;

    public Point getInlet() {
        return inlet;
    }

    public Link setInlet(Point inlet) {
        this.inlet = inlet;
        return this;
    }

    public Point getOut() {
        return out;
    }

    public Link setOut(Point out) {
        this.out = out;
        return this;
    }
}
