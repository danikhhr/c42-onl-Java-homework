package homeworkNumber10;

import java.util.Objects;

public class UserSystem {
    private final String userName;
    private final String password;

    public UserSystem(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if(obj.getClass() != getClass()) return false;

        UserSystem otherUserSystem = (UserSystem) obj;

        return Objects.equals(otherUserSystem.userName, this.userName)
                    && Objects.equals(otherUserSystem.password, this.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }

    @Override
    public String toString() {
        return "User system(\n\t" +
                "username: " + this.userName +
                "\n\tpassword: " + this.password;
    }
}
