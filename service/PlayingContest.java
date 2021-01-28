package service;

import model.Contest;
import model.User;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class PlayingContest {
    List<User> users;
    Contest contest;

    public PlayingContest(List<User> users, List<Contest> contests, int id) {
        this.users = users;
        this.contest = contests.stream().filter(a -> a.getId() == id).findFirst().get();
    }

    void solovingproblem() {
        users.stream().forEach(id -> getMappedRating(id));


    }

    private void getMappedRating(User user) {

        int v = contest.getNumberOfQuestions();
        int sum = 0;
        int d = getRandom(v);
        for (int i = 0; i < d; i++) {
            int id = getRandom(v);
            Optional<Integer> first = contest.getQuestions().stream().filter(a -> a == id).findFirst();
            sum = first.get() + sum;
        }
        user.setRating(sum - 50);
    }

    int getRandom(int n) {
        Random rc = new Random();
        return rc.nextInt(n) + 1;
    }



}
