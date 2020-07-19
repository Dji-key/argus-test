package ru.argustelecom.util;

import ru.argustelecom.dao.interfaces.NodeDao;
import ru.argustelecom.entity.ConnectionUnit;
import ru.argustelecom.entity.Node;
import ru.argustelecom.entity.Point;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Singleton
public class DataMiner {

    @EJB
    private NodeDao nodeDao;

    public void bringItOn() {
        List<Node> nodes = new ArrayList<>();
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < 10 * StrictMath.random() + 3; i++) {
            Node node = new Node().setTitle("Node №" + i)
                    .setRegion("Region of node №" + i)
                    .setStreet("Street of node №" + i)
                    .setBuilding("№" + i);
            nodes.add(node);
            for (int j = 0; j < 10 * StrictMath.random(); j++) {
                ConnectionUnit connectionUnit = new ConnectionUnit().setTitle("Connection unit №" + j + " of node №" + i).setNode(node);
                node.getConnectionUnits().add(connectionUnit);
                for (int k = 0; k < 10 * StrictMath.random(); k++) {
                    Point point = new Point().setConnectionUnit(connectionUnit);
                    connectionUnit.getPoints().add(point);
                    points.add(point);
                }
            }
        }

        Collections.shuffle(points);

        for (int i = 0; i < points.size();) {
            if (StrictMath.random() > 0.5) {
                if (points.size() != i + 1) {
                    points.get(i).setConnected(points.get(i + 1));
                    points.get(i + 1).setConnected(points.get(i));
                    i += 2;
                }
            } else {
                i++;
            }
        }

        nodeDao.save(nodes);
    }
}
