package ru.argustelecom.dao.interfaces;

import ru.argustelecom.entity.Node;

import java.util.List;

public interface NodeDao {

    Node save(Node node);

    Node find(Long id);

    List<Node> findAll();
}
