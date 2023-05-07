package sample;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXServiceURL;
import javax.management.remote.rmi.RMIConnectorServer;

public class HelloWorld {
    public static void main(String[] args) throws Exception {
        MBeanServer mbs = MBeanServerFactory.createMBeanServer();
        JMXServiceURL addr = new JMXServiceURL("rmi", null, 0);
        JMXConnectorServer cs = new RMIConnectorServer(addr, null);
        ObjectName csName = new ObjectName(":type=cserver,name=mycserver");
        mbs.registerMBean(cs, csName);
        cs.start();
        JMXServiceURL url = cs.getAddress();
        System.out.println(url);


    }
}
