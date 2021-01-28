package service;

import model.User;

import java.util.List;
import java.util.Scanner;

public class CreateUser {
    List<User> list;

    public CreateUser(List<User> list) {
        this.list = list;
    }

    public   void createUser()
    {
        System.out.println("Enter the id , name");
        Scanner sc= new Scanner(System.in);
        User user= new User(sc.nextInt(), sc.next());
        list.add(user);
        System.out.println("USER Created"+ user.getId()+"    "+user.getName()+"   "+user.getRating());

    }
}
