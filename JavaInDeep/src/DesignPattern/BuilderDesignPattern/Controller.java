package DesignPattern.BuilderDesignPattern;

public class Controller {
    public static void main(String[] args) {
        User user = new User.UserBuilder().
                setEmailId("jhaajit1996").
                setUserId("121").
                setUserName("ajit")
                .build();

        System.out.println(user);

        User userTwo = new User.UserBuilder().setEmailId("jaj").build();

        System.out.println(userTwo);
    }

}
