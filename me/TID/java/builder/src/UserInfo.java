public class UserInfo {
    private String name;
    private int age;
    private String addr;

    public UserInfo(String name, int age, String addr){
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getUserInfo(){
        return String.format("name: %s, age: %d, addr: %s", name, age, addr);
    }
}

