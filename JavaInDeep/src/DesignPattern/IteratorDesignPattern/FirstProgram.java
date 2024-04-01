package DesignPattern.IteratorDesignPattern;

public class FirstProgram {
    public static void main(String[] args) {

        UserManagement userManagement= new UserManagement();
        userManagement.addUser(new User("ajit","11"));
        userManagement.addUser(new User("samar","56"));
        userManagement.addUser(new User("hudge","14"));
        userManagement.addUser(new User("ayaan","65"));
        userManagement.addUser(new User("ashish","54"));
        userManagement.addUser(new User("alok","58"));


        UserManagementUsingArrayList userManagementUsingArrayList = new UserManagementUsingArrayList();
        userManagementUsingArrayList.addUser(new User("chandra","56777"));
        userManagementUsingArrayList.addUser(new User("bade","567ii"));

        MyIterator iterator = userManagement.getIterator();
        if(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

       MyIterator iterator1 = userManagement.getIterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        MyIterator iterator2 = userManagementUsingArrayList.getIterator();
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

    }

}
