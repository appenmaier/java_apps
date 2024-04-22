package login;

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

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getFamilyName() {
    return familyName;
  }

}
