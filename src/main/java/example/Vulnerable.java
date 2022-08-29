package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Vulnerable {
  public Connection vulnerable() {
    try {
      return DriverManager.getConnection("jdbc:derby:memory:myDB;create=true", "login", "");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
