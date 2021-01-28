package service;

import model.Contest;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContestService {
    List<User> users;
    List<Contest> contests;

    public ContestService(List<User> list, String name, List<Contest> contests) {
        long count = list.stream().filter(n -> n.getName().equals(name)).count();
        if (count == 0) {
            return;
        } else {
            this.users = list;
            this.contests = contests;
        }
    }

    public void createContest() {
        System.out.println("Enter the Numer of question , Questions");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int i = 0;
        List<Integer> questions = new ArrayList<>();
        for (i = 0; i < number; i++) {
            System.out.println("Enter the " + i+1 + " " + "questions");
            questions.add(sc.nextInt());

        }
        int sum = questions.stream().reduce(0, (a, b) -> a + b);
        if (sum != 100) {
            System.out.println("Sum is not 100");
            return;
        } else {
            contests.add(new Contest(number, questions));
        }
    }


}
