package application;

import model.Contest;
import model.User;
import service.ContestService;
import service.CreateUser;
import service.PlayingContest;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {


        List<User> users = new ArrayList<>();
        List<Contest> contest = new ArrayList<>();
        ApplicationMenu(users, contest);

    }

    private static void ApplicationMenu(List<User> users, List<Contest> contest) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to create user and contest 2 for join contest and 3 for leaderboards 4 to remnenu");
        while (true) {
            int value = sc.nextInt();
            if (value == 1) {
                creationOfUserAndContest(users, contest);
            } else if (value == 2) {
                joinContest(users, contest);
            } else if (value == 3) {
                if (users.size() > 0 && contest.size() > 0) {
                    leaderboards(users);
                } else {
                    System.out.println("Sorry no contest or user");
                }
            } else if (value == 4) {
                System.out.println("Sorry no contest or user renter the value");
                ApplicationMenu(users, contest);

            } else {
                System.out.println("Sorry wrong choice");
                break;
            }
        }
    }

    private static void joinContest(List<User> users, List<Contest> contest) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENter the contest id");
        int value = sc.nextInt();
        Optional<Contest> first = contest.stream().filter(a -> a.getId() == value).findFirst();
        if (first.isPresent()) {
            PlayingContest playingContest = new PlayingContest(users, contest, first.get().getId());
        } else {
            System.out.println("No contest sorryy||");
            return;
        }

    }

    public static List<User> leaderboards(List<User> users) {
        return users.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }

    private static void creationOfUserAndContest(List<User> users, List<Contest> contest) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu");
        while (true) {
            System.out.println("Enter 1 create user");
            System.out.println("Enter 2 create contest");
            System.out.println("Enter 3 to renetr the value");
            System.out.println("Else to exit");

            int value = sc.nextInt();
            if (value == 1) {
                CreateUser createUser = new CreateUser(users);
                createUser.createUser();
            } else if (value == 2) {
                System.out.println("Enter your name");

                String name = sc.nextLine();
                ContestService createContest = new ContestService(users, name, contest);
                createContest.createContest();
            } else if (value == 3) {
                System.out.println("Renter");
                creationOfUserAndContest(users, contest);
            } else {
                System.out.println("Sorry wrong choice");
                break;
            }
        }
    }
}
