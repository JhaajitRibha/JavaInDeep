package DesignPattern.IteratorDesignPattern;

import java.util.ArrayList;
import java.util.LinkedList;

public class UserManagement {

    private LinkedList<User> userList = new LinkedList<>();


    public void addUser(User user){
        userList.add(user);
    }

    public User getUser(int index){
        return userList.get(index);
    }

    public MyIterator getIterator(){
        return new MyIteratorImpl(userList);
    }

}
