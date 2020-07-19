package ru.argustelecom.webservice;

import ru.argustelecom.dao.interfaces.NodeDao;
import ru.argustelecom.entity.Node;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

//Заготовка, с сервисами пока не разобрался
@WebService
public class NodeWebService {

    @EJB
    private NodeDao nodeDao;

    @WebMethod(operationName = "getinfo")
    public Node getNodeInfo(@WebParam(name = "nodeId") long id) {
        return nodeDao.find(id);
    }
}
