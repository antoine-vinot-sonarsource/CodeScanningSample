package example;

import java.sql.Connection;
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
    DriverManager.getConnection("jdbc:derby:memory:myDB;create=true", "login", "");
  }

  private static void doVulnerableCode(boolean bool) throws SQLException {
    if (bool) {
      DriverManager.getConnection("jdbc:derby:memory:myDB;create=true", "login", "");
    }
  }

  private static void doVulnerableCode(boolean bool, String output) throws SQLException {
    if (bool && output.equals("test")) {
      DriverManager.getConnection("jdbc:derby:memory:myDB;create=true", "login", "");
    }
  }

  private static void doVulnerableCode(String output) throws SQLException {

    Connection conn = DriverManager.getConnection("jdbc:derby:memory:myDB;create=true", "login", "");
    System.out.println(output);
  }



}
