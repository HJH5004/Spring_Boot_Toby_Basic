package tobyspringboot.config.autoConfig;

import org.springframework.stereotype.Component;
import tobyspringboot.config.MyConfigurationProperties;

@MyConfigurationProperties(prefix = "server")
public class ServerProperties {
    private String contextPath;
    private int portNo;


    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public int getPortNo() {
        return portNo;
    }

    public void setPortNo(int portNo) {
        this.portNo = portNo;
    }
}
