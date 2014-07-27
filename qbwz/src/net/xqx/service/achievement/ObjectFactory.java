
package net.xqx.service.achievement;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.xqx.service.achievement package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAchievementsResponse_QNAME = new QName("http://achievement.service.xqx.net/", "getAchievementsResponse");
    private final static QName _GetAchievements_QNAME = new QName("http://achievement.service.xqx.net/", "getAchievements");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.xqx.service.achievement
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAchievementsResponse }
     * 
     */
    public GetAchievementsResponse createGetAchievementsResponse() {
        return new GetAchievementsResponse();
    }

    /**
     * Create an instance of {@link GetAchievements }
     * 
     */
    public GetAchievements createGetAchievements() {
        return new GetAchievements();
    }

    /**
     * Create an instance of {@link Achievement }
     * 
     */
    public Achievement createAchievement() {
        return new Achievement();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAchievementsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://achievement.service.xqx.net/", name = "getAchievementsResponse")
    public JAXBElement<GetAchievementsResponse> createGetAchievementsResponse(GetAchievementsResponse value) {
        return new JAXBElement<GetAchievementsResponse>(_GetAchievementsResponse_QNAME, GetAchievementsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAchievements }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://achievement.service.xqx.net/", name = "getAchievements")
    public JAXBElement<GetAchievements> createGetAchievements(GetAchievements value) {
        return new JAXBElement<GetAchievements>(_GetAchievements_QNAME, GetAchievements.class, null, value);
    }

}
