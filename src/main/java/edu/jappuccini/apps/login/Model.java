package edu.jappuccini.apps.login;

import java.util.ArrayList;
import java.util.List;

/** Singleton model that stores the user list and tracks the currently authenticated user. */
public class Model {

   private User user;
   private List<User> users;
   private static final Model INSTANCE = new Model();

   private Model() {
      users = new ArrayList<>();
      users.add(new User("m.maier", "1234", "Max", "Maier"));
      users.add(new User("l.schmidt", "0000", "Lisa", "Schmidt"));
      users.add(new User("Administrator", "admin", "", "Administrator"));
   }

   /** Returns the singleton instance of this model. */
   public static Model getInstance() {
      return INSTANCE;
   }

   /**
    * Looks up the user by credentials and sets it as the current user if found.
    *
    * @param userName the username to match
    * @param password the password to match
    * @return {@code true} if a matching user was found, {@code false} otherwise
    */
   public boolean setUser(String userName, String password) {
      for (User user : users) {
         if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
            this.user = user;
            return true;
         }
      }
      return false;
   }

   /** Returns the currently authenticated user, or {@code null} if no user is logged in. */
   public User getUser() {
      return user;
   }

}
