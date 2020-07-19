package ru.argustelecom.dao.implementations;

import ru.argustelecom.dao.interfaces.NodeDao;
import ru.argustelecom.entity.ConnectionUnit;
import ru.argustelecom.entity.Node;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Singleton
@Transactional
public class NodeDaoImpl implements NodeDao {

    @PersistenceContext(unitName = "H2PersistenceUnit")
    private EntityManager entityManager;

    @Override
    public Node save(Node node) {
        entityManager.persist(node);
        entityManager.flush();
        return node;
    }

    @Override
    public void save(Iterable<Node> nodes) {
        nodes.forEach(node -> entityManager.persist(node));
        entityManager.flush();
    }

    @Override
    public Node find(Long id) {
        return entityManager.find(Node.class, id);
    }

    @Override
    public List<Node> findAll() {
        return entityManager.createQuery("SELECT n FROM Node n", Node.class).getResultList();
    }

    @Override
    public List<Node> findAllConnectedNodes(Node node) {
        //Возвращает список идентификаторов точек, которые соединены с данным узлом
        List<Long> connected = node.getConnectionUnits().stream()
                .map(ConnectionUnit::getPoints)
                .flatMap(Set::stream)
                .filter(point -> point.getConnected() != null)
                .map(point -> point.getConnected().getId())
                .collect(Collectors.toList());

        if (!connected.isEmpty()) {
            TypedQuery<Node> query = entityManager.createQuery(
                    "SELECT cu.node FROM ConnectionUnit cu WHERE cu IN " +
                            "(SELECT p.connectionUnit FROM Point p WHERE p.id IN :ids)", Node.class);
            query.setParameter("ids", connected);
            return query.getResultList().stream().distinct().collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
