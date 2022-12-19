public class Main {
    public static void main(String[] args) {
        UserInfo user = new UserInfoBuilder().setName("자바").build();
        UserInfo user2 = new UserInfoBuilder().setName("빌더").setAddr("클래스").build();
        UserInfo user3 = new UserInfoBuilder().setName("객체").setAddr("메서드").setAge(10).build();

        System.out.println(user.getUserInfo());
        System.out.println(user2.getUserInfo());
        System.out.println(user3.getUserInfo());

    }
}