package ru.argustelecom.service.implementations;

import ru.argustelecom.dao.interfaces.PointDao;
import ru.argustelecom.entity.Point;
import ru.argustelecom.service.interfaces.PointService;

import javax.ejb.EJB;
import javax.ejb.Singleton;

@Singleton
public class PointServiceImpl implements PointService {

    @EJB
    private PointDao pointDao;

    public Point save(Point point) {
        return pointDao.save(point);
    }
}
