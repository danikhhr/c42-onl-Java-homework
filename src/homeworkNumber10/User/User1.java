package homeworkNumber10.User;

public class User1 implements Cloneable{
    private int id;
    private String userName;
    private Owner user;
    public User1(String userName, int id, Owner owner) {
        this.userName = userName;
        this.id = id;
        this.user = owner;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Owner getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "User system(\n\t" +
                "username: " + this.userName +
                "\n\tuser id: " + this.id +
                "\n\tOwner:" + user;
    }
}
