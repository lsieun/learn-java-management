package lsieun.management.bean.standard;

public class SmartBoy implements SmartBoyMBean {
    private String name;
    private int age;

    public SmartBoy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void study(String subject, int minutes) {
        String message = String.format("%s who is %d years old has studied %s for %d minutes.", name, age, subject, minutes);
        System.out.println(message);
    }
}
