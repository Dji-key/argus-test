package ru.argustelecom.view;

import ru.argustelecom.dao.interfaces.NodeDao;
import ru.argustelecom.entity.ConnectionUnit;
import ru.argustelecom.entity.Node;
import ru.argustelecom.util.DataMiner;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Bean для отображения информации по всем узлам
 */
@Named
@ViewScoped
public class OverallInfo implements Serializable {

    @EJB
    private NodeDao nodeDao;
    @EJB
    private DataMiner dataMiner;

    private List<Node> nodes;

    //Флаг для отображения кнопки
    private boolean emptyData = true;

    @PostConstruct
    private void init() {
        nodes = nodeDao.findAll();
        if (!nodes.isEmpty()) {
            emptyData = false;
        }
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public boolean isEmptyData() {
        return emptyData;
    }

    /**
     * Подсчёт суммарного количества точек в узле
     * @param node данный узел {@link Node}
     * @return Суммарное количество точек
     */
    public int getPointsQty(Node node) {
        return node.getConnectionUnits().stream()
                .map(ConnectionUnit::getPoints)
                .mapToInt(Set::size)
                .sum();
    }

    /**
     * Подсчёт суммарного количества свободных точек в узле
     * @param node данный узел {@link Node}
     * @return Суммарное количество свободных точек
     */
    public long getSparePointsQty(Node node) {
        return node.getConnectionUnits().stream()
                .map(ConnectionUnit::getPoints)
                .mapToLong(points -> points.stream()
                        .filter(point -> point.getConnected() == null).count())
                .sum();
    }

    /**
     * Заполняет базу фейковыми данными
     */
    public void addFakeData() {
        if (emptyData) {
            dataMiner.bringItOn();
            init();
        }
    }
}
