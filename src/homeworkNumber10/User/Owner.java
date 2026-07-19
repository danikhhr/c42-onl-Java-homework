package homeworkNumber10.User;

public class Owner implements Cloneable{

    private String userName;

    public Owner(String userName) {

        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return userName;

    }

    @Override
    public Owner clone() throws CloneNotSupportedException {
        return (Owner) super.clone();
    }
}
