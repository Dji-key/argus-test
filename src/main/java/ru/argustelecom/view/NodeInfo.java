package ru.argustelecom.view;

import ru.argustelecom.dao.interfaces.NodeDao;
import ru.argustelecom.entity.Node;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Bean для отображения информации связанной с конкретным узлом
 */
@Named
@ViewScoped
public class NodeInfo implements Serializable {

    @EJB
    private NodeDao nodeDao;

    private Node node;

    private List<Node> connectedNodes;

    @PostConstruct
    private void init() {

        //Очень бесячее место, приходится делать так, потому что javax.faces.annotation.ManagedProperty не работает в бинах @Named
        //А использовать javax.faces.bean.ManagedBean я не буду, потому что она deprecated.
        //Можно было бы использовать библиотеку OmniFaces и её @Param, но не получилось подружить её с WildFly, а я итак уже кучу времени
        //потратил на подобные проблемы совместимостей и всего прочего
        Map<String, String> param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long nodeId = Long.valueOf(param.get("nodeId"));

        node = nodeDao.find(nodeId);
        connectedNodes = nodeDao.findAllConnectedNodes(node);
    }

    public Node getNode() {
        return node;
    }

    public List<Node> getConnectedNodes() {
        return connectedNodes;
    }
}
