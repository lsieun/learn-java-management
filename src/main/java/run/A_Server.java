package run;

import lsieun.cst.Const;
import lsieun.management.bean.standard.SmartBoy;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import javax.management.remote.rmi.RMIConnectorServer;
import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

public class A_Server {
    public static void main(String[] args) throws Exception {
        // 第一步，创建MBeanServer
        MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();

        // 第二步，注册MBean
        SmartBoy bean = new SmartBoy("Tom", 10);
        ObjectName objectName = new ObjectName(Const.SMART_BOY_BEAN);
        beanServer.registerMBean(bean, objectName);

        // 第三步，创建Connector Server
        JMXServiceURL serviceURL = new JMXServiceURL("rmi", "127.0.0.1", 9876);
        System.out.println(serviceURL);
        JMXConnectorServer connectorServer = JMXConnectorServerFactory.newJMXConnectorServer(serviceURL, null, beanServer);
        System.out.println(connectorServer.getClass());
        boolean status = connectorServer.isActive();
        System.out.println(status);

        // 第四步，开启Connector Server
        connectorServer.start();
        System.out.println(connectorServer.isActive());

        // ===
        JMXServiceURL connectorServerAddress = connectorServer.getAddress();
        System.out.println(connectorServerAddress);
        TimeUnit.SECONDS.sleep(10);
        // ===

        // 第五步，关闭Connector Server
        connectorServer.stop();
        status = connectorServer.isActive();
        System.out.println(status); // false

    }
}
