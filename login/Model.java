package login;

import java.util.ArrayList;
import java.util.List;

public class Model {

  private User user;
  private static List<User> users;
  private static Model instance;

  private Model() {
    users = new ArrayList<>();
    users.add(new User("m.maier", "1234", "Max", "Maier"));
    users.add(new User("l.schmidt", "0000", "Lisa", "Schmidt"));
    users.add(new User("Administrator", "admin", "", "Administrator"));
  }

  public static Model getInstance() {
    if (instance == null) {
      instance = new Model();
    }
    return instance;
  }

  public boolean setUser(String userName, String password) {
    for (User user : users) {
      if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
        this.user = user;
        return true;
      }
    }
    return false;
  }

  public User getUser() {
    return user;
  }

}
