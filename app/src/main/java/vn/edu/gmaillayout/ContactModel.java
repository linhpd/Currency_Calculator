package vn.edu.gmaillayout;

import java.util.Random;

public class ContactModel {
    String name;
    String content;
    boolean isFavorite;
    int color;
    String time;

    public ContactModel(String name, String content, String time) {
        this.name = name;
        this.content = content;
        this.time = time;

        isFavorite = false;
        Random random = new Random();
        this.color = random.nextInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
