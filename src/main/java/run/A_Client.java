package run;

import lsieun.cst.Const;

import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class A_Client {
    public static void main(String[] args) throws Exception {
        // 第一步，创建Connector Client
        String connectorAddress = "service:jmx:rmi://127.0.0.1:9876/stub/rO0ABXNyAC5qYXZheC5tYW5hZ2VtZW50LnJlbW90ZS5ybWkuUk1JU2VydmVySW1wbF9TdHViAAAAAAAAAAICAAB4cgAaamF2YS5ybWkuc2VydmVyLlJlbW90ZVN0dWLp/tzJi+FlGgIAAHhyABxqYXZhLnJtaS5zZXJ2ZXIuUmVtb3RlT2JqZWN002G0kQxhMx4DAAB4cHc4AAtVbmljYXN0UmVmMgAADTE5Mi4xNjguMjAwLjEAACaU4NAsDsWMk/r8Hk8BAAABfhJkJeOAAQB4";
        JMXServiceURL address = new JMXServiceURL(connectorAddress);
        JMXConnector connector = JMXConnectorFactory.connect(address);

        // 第二步，连接Connector Server
        MBeanServerConnection beanServerConnection = connector.getMBeanServerConnection();

        // 第三步，向connector server发送请求
        ObjectName objectName = new ObjectName(Const.SMART_BOY_BEAN);
        MBeanInfo beanInfo = beanServerConnection.getMBeanInfo(objectName);

        System.out.println(beanInfo.getClass());
        System.out.println(beanInfo);

        String[] array = new String[]{"Chinese", "Math", "English"};
        for (String item : array) {
            beanServerConnection.invoke(objectName, "study", new Object[]{item, 30}, new String[]{String.class.getName(), int.class.getName()});
        }

        // 第四步，关闭connector client
        connector.close();
    }
}
