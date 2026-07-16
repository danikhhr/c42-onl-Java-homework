package homeworkNumber10.User;

public class User2 implements Cloneable {
    private int id;
    private String userName;

    public User2(String userName, int id) {
        this.id = id;
        this.userName = userName;
    }


    @Override
    public User2 clone() throws CloneNotSupportedException {
        User2 user2 = (User2) super.clone();
        return user2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User system(\n\t" +
                "username: " + this.userName +
                "\n\tuser id: " + this.id;
    }
}
