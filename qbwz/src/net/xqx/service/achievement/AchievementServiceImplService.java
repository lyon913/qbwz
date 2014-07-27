
package net.xqx.service.achievement;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;


/**
 * This class was generated by the JAXWS SI.
 * JAX-WS RI 2.0_02-b08-fcs
 * Generated source version: 2.0
 * 
 */
@WebServiceClient(name = "AchievementServiceImplService", targetNamespace = "http://achievement.service.xqx.net/", wsdlLocation = "http://localhost:8090/ExamRegService/services/achievement?wsdl")
public class AchievementServiceImplService
    extends Service
{

    private final static URL ACHIEVEMENTSERVICEIMPLSERVICE_WSDL_LOCATION;

    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8090/ExamRegService/services/achievement?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ACHIEVEMENTSERVICEIMPLSERVICE_WSDL_LOCATION = url;
    }

    public AchievementServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AchievementServiceImplService() {
        super(ACHIEVEMENTSERVICEIMPLSERVICE_WSDL_LOCATION, new QName("http://achievement.service.xqx.net/", "AchievementServiceImplService"));
    }

    /**
     * 
     * @return
     *     returns AchievementService
     */
    @WebEndpoint(name = "AchievementServiceImplPort")
    public AchievementService getAchievementServiceImplPort() {
        return (AchievementService)super.getPort(new QName("http://achievement.service.xqx.net/", "AchievementServiceImplPort"), AchievementService.class);
    }

}
