package sl.paket.addressbook.tests;

import org.testng.annotations.Test;
import sl.paket.addressbook.model.GroupData;
import sl.paket.addressbook.model.Groups;

import java.sql.*;

/**
 * Created by serglit on 12.09.16.
 */
public class DbConnection {

    @Test
     public void dbConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook?serverTimezone=UTC&user=root&password=");
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("select group_id,group_name,group_header,group_footer from group_list");
            Groups groups = new Groups();
            while (resultSet.next()) {
                groups.add(new GroupData().withId(resultSet.getInt("group_id")).withName(resultSet.getString("group_name")).withHeader(resultSet.getString("group_header"))
                        .withFooter(resultSet.getString("group_footer")));
            }
            resultSet.close();
            st.close();
            conn.close();

            System.out.println(groups);

            // Do something with the Connection

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }
}
