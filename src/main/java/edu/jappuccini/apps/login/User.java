package edu.jappuccini.apps.login;

import lombok.Getter;

/** Represents a user account with credentials and personal name information. */
@Getter
public class User {

   private final String userName;
   private final String password;
   private final String firstName;
   private final String familyName;

   public User(String userName, String password, String firstName, String familyName) {
      this.userName = userName;
      this.password = password;
      this.firstName = firstName;
      this.familyName = familyName;
   }

}
