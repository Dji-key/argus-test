package ru.argustelecom.view;

import ru.argustelecom.dao.interfaces.NodeDao;
import ru.argustelecom.entity.ConnectionUnit;
import ru.argustelecom.entity.Node;
import ru.argustelecom.entity.Point;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class OverallInfo implements Serializable {

    @EJB
    private NodeDao nodeDao;

    private List<Node> nodes;

    @PostConstruct
    private void init() {
        nodes = nodeDao.findAll();
        System.out.println("hello");
    }

    public NodeDao getNodeDao() {
        return nodeDao;
    }

    public OverallInfo setNodeDao(NodeDao nodeDao) {
        this.nodeDao = nodeDao;
        return this;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public OverallInfo setNodes(List<Node> nodes) {
        this.nodes = nodes;
        return this;
    }

    public void addNode() {
        Point point = new Point();
        ConnectionUnit connectionUnit = new ConnectionUnit();
        connectionUnit.setTitle("Unit");
        connectionUnit.getPoints().add(point);
        point.setConnectionUnit(connectionUnit);
        Node node = new Node();
        node.setTitle("Node").setStreet("Street").setBuilding("Building").setRegion("Region");
        node.getConnectionUnits().add(connectionUnit);
        connectionUnit.setNode(node);
        nodes.add(nodeDao.save(node));
        System.out.println("Hello");
    }

    public void deleteNode() {

    }
}
