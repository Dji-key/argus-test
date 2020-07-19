package ru.argustelecom.dao.implementations;

import ru.argustelecom.dao.interfaces.PointDao;
import ru.argustelecom.entity.Point;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Singleton
@Transactional
public class PointDaoImpl implements PointDao {

    @PersistenceContext(unitName = "H2PersistenceUnit")
    private EntityManager entityManager;

    public Point save(Point point) {
        entityManager.persist(point);
        entityManager.flush();
        return point;
    }
}
