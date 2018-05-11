package hello.service;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;

@Service
public class VisitorService {

    public long saveVisit() {
        final String myUrl = "jdbc:mysql://10.224.132.151:31398/visits";
        Long result = 0L;
        try {
            // create a mysql database connection
            try (Connection conn = DriverManager.getConnection(myUrl,"test","test")) {

                // the mysql insert statement
                String query = " insert into VISIT_AUDIT (visit_date) values (?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setDate(1, new java.sql.Date(System.currentTimeMillis()));

                // execute the preparedstatement
                preparedStmt.execute();

                final String sql = " select count(*) from VISIT_AUDIT";
                PreparedStatement preparedStmt2 = conn.prepareStatement(sql);
                ResultSet resultSet = preparedStmt2.executeQuery();
                resultSet.next();

                result = resultSet.getLong(1);
            } catch (Exception e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
        } catch (Exception ex) {
            System.err.println("Got an exception!");
            System.err.println(ex.getMessage());
        }

        return result;
    }

}