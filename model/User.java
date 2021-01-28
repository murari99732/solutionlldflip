package model;

public class User {
    int id;
    String name;
    int rating;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.rating = 1500;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public int getRating() {
        return rating;
    }

    public User setRating(int rating) {
        if (this.rating == 0) {
            this.rating = rating + 1500;
        } else
            this.rating = rating;
        return this;
    }

}
