package ru.argustelecom.dao.interfaces;

import ru.argustelecom.entity.Node;

import java.util.List;

public interface NodeDao {

    /**
     * Сохранение узла
     * @param node узел {@link Node}
     * @return Сохранённый узел {@link Node}
     */
    Node save(Node node);

    /**
     * Сохраняет список узлов
     * @param nodes список узлов {@link Node}
     */
    void save(Iterable<Node> nodes);

    /**
     * Находит узел по id
     * @param id идентификатор узла
     * @return Найденный узел {@link Node}
     */
    Node find(Long id);

    /**
     * Находит все существующие узлы
     * @return Список узлов
     */
    List<Node> findAll();

    /**
     * Находит список узлов, соединённых с данным
     * @param node узел
     * @return Список узлов
     */
    List<Node> findAllConnectedNodes(Node node);
}
