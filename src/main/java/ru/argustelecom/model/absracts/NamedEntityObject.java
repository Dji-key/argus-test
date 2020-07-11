package ru.argustelecom.model.absracts;

import javax.persistence.Column;

public abstract class NamedEntityObject extends EntityObject {

    @Column(name = "title")
    private String title;

    public String getTitle() {
        return title;
    }

    public NamedEntityObject setTitle(String title) {
        this.title = title;
        return this;
    }
}
