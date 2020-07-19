package ru.argustelecom.dao.implementations;

import ru.argustelecom.dao.interfaces.NodeDao;
import ru.argustelecom.entity.Node;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

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
    public Node find(Long id) {
        return entityManager.find(Node.class, id);
    }

    @Override
    public List<Node> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Node> query = criteriaBuilder.createQuery(Node.class);
        Root<Node> rootEntry = query.from(Node.class);
        CriteriaQuery<Node> all = query.select(rootEntry);
        TypedQuery<Node> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
}
