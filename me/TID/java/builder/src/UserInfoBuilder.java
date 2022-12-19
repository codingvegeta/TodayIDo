public class UserInfoBuilder {
    private String name;
    private int age;
    private String addr;

    public UserInfoBuilder setName(String name){
        this.name = name;
        return this;
    }

    public UserInfoBuilder setAge(int age){
        this.age = age;
        return this;
    }

    public UserInfoBuilder setAddr(String addr){
        this.addr = addr;
        return this;
    }

    public UserInfo build(){
        return new UserInfo(name, age, addr);
    }
}
