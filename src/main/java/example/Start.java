package example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Start {

  public static void main(String[] args) {
    try {
      doVulnerableCode();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static void doVulnerableCode() throws SQLException {
    new Vulnerable().vulnerable();
  }

  private static void doVulnerableCode(String output) {
    try {
      DriverManager.getConnection("jdbc:derby:memory:myDB;create=true", "login", "");
    } catch (SQLException e) {
      throw new RuntimeException(output + " " + e);
    }
  }

  private static void anotherVulnerableCode() {
    var regex = "/^([a-zA-Z0-9])(([\\-.]|[_]+)?([a-zA-Z0-9]+))*(@){1}[a-z0-9]+[.]{1}(([a-z]{2,3})|([a-z]{2,3}[.]{1}[a-z]{2,3}))$/";
    if (!"some phrase".matches(regex)){
      throw new Error("Invalid mail format");
    }
  }

  private static void moreVulnerableCode() {
    var regex = "/^([a-zA-Z0-9])(([\\-.]|[_]+)?([a-zA-Z0-9]+))*(@){1}[a-z0-9]+[.]{1}(([a-z]{2,3})|([a-z]{2,3}[.]{1}[a-z]{2,3}))$/";
    if (!"some phrase test".matches(regex)){
      throw new Error("Invalid e-mail format");
    }
  }

}
