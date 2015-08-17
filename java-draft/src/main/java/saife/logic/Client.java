package saife.logic;

/**
 * Created by ypolshchykau on 14.08.2015.
 */
public class Client {

    private String dashboardApiKey;


    //    a piece of hardcoded test data , just for debuggin purposes:
    private String userEmail = "ypolshchykau@exadel.com";
    private String userPass = "Trigger_09031944";


    private final String dashboardHostname="https://dashboard.saifeinc.com";

    public Client(String dashboardApiKey) {
        this.dashboardApiKey = dashboardApiKey;
    }
}
