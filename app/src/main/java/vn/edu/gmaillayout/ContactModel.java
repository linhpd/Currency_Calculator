package vn.edu.gmaillayout;

public class ContactModel {
    String name;
    String content;
    boolean isChecked;
    String color;

    String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ContactModel(String name, String content, boolean isChecked, String color) {
        this.name = name;
        this.content = content;
        this.isChecked = isChecked;
        this.color  = color;
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

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
