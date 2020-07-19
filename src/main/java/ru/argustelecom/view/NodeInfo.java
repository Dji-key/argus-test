package ru.argustelecom.view;

//import org.omnifaces.cdi.Param;
import ru.argustelecom.dao.interfaces.NodeDao;
import ru.argustelecom.entity.Node;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

@Named
@RequestScoped
public class NodeInfo implements Serializable {

    @EJB
    private NodeDao nodeDao;

//    @Param
    private Long longId;

//    @Param
    private String stringId;

    private Node node;

    @PostConstruct
    private void init() {
        Map<String, String> param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    }

    public Node getNode() {
        return node;
    }

    public NodeInfo setNode(Node node) {
        this.node = node;
        return this;
    }
}
