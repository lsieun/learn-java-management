package lsieun.management.bean.standard;

public interface SmartBoyMBean {
    String getName();
    void setName(String name);

    int getAge();
    void setAge(int age);

    void study(String subject, int minutes);
}
