
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;
import java.io.File;
import java.io.IOException;
import net.ucanaccess.jdbc.JackcessOpenerInterface;

import java.sql.*;
import java.util.HashMap;

public class TargutDatabase {

    static final String JDBC_DRIVER = "net.ucanaccess.jdbc.UcanaccessDriver";
    static final String targut = "Targut.accdb";
    static final String URL = "jdbc:ucanaccess://" + targut;
    
    // edit below url to the location of the db. this assumes it is in the same src folder
    static final String DB_URL = "jdbc:ucanaccess://src/Targut.accdb;memory=true"; 
 
 TargutDatabase() {

    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        TargutDatabase db = new TargutDatabase();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

        try {

            connection = DriverManager.getConnection(DB_URL);

            statement = connection.createStatement();

            // db.insertItem(connection); //   THIS IS A TEST TO INSERT AN ITEM
            
            // db.insertCustomer(connection); //   THIS IS A TEST TO INSERT A CUSTOMER
            
            // db.insertDepartment(connection); //   THIS IS A TEST TO INSERT A DEPARTMENT
            
            
            resultSet = statement.executeQuery("SELECT * FROM ITEM");

            // ----------------------- FORMAT THIS TO FIT THE UI: ---------------------------------------------------------
            System.out.println("ID\tItem ID\t    Item Name\tExp Date\tPrice\tStock\tOn Sale\t");
            System.out.println("===\t========\t==================\t============\t=========\t=======\t=======");

            // this prints to console, configure it to print to the UI
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "\t"
                        + resultSet.getString(2) + "\t"
                        + resultSet.getString(3) + "\t"
                        + resultSet.getString(4) + "\t"
                        + resultSet.getString(5) + "\t"
                        + resultSet.getString(6) + "\t"
                        + resultSet.getString(7));

            }

            resultSet = statement.executeQuery("SELECT * FROM CUSTOMER");

            // ----------------------- FORMAT THIS TO FIT THE UI: ---------------------------------------------------------
            System.out.println("ID\tCustomer ID\t Name\t Email\t Payment Method \tShipping Info\tConfirmation\tPhone\t");
            System.out.println("===\t========\t==================\t============\t=========\t=======\t=========\t===========");

            // this prints to console, configure it to print to the UI
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "\t"
                        + resultSet.getString(2) + "\t"
                        + resultSet.getString(3) + "\t"
                        + resultSet.getString(4) + "\t"
                        + resultSet.getString(5) + "\t"
                        + resultSet.getString(6) + "\t"
                        + resultSet.getString(7) + "\t"
                        + resultSet.getString(8));

            }

            resultSet = statement.executeQuery("SELECT * FROM DEPARTMENT");

            // ----------------------- FORMAT THIS TO FIT THE UI: ---------------------------------------------------------
            System.out.println("ID\t Department ID\t Department Name\t");
            System.out.println("===\t=========\t==================\t====");

            // this prints to console, configure it to print to the UI
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "\t"
                        + resultSet.getString(2) + "\t"
                        + resultSet.getString(3));

            }
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        } finally {

            try {
                if (null != connection) {

                    resultSet.close();
                    statement.close();

                    connection.close();
                }
            } catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
    }

    // -------------------------------------INSERTION METHODS--------------------------------------------------------
    void insertCustomer(Connection conn) throws ClassNotFoundException, SQLException, IOException {

        int custID = 99; //have the user able to enter this value
        String name = "'abc'"; // !!!!!!!!!! make sure any user entered string values have single quotes attached to both ends. ie) abc would become 'abc'
        String email = "'abc'"; //have the user able to enter this value
        String paymentMethod = "'abc'"; //have the user able to enter this value
        String shipInfo = "'abc'"; //have the user able to enter this value
        boolean confirmation = true; //have the user able to enter this value
        int phone = 1234567; //have the user able to enter this value

        String stmt = "INSERT INTO Customer([Customer ID],[Cust Name],Email,[Payment Method],[Shipping Info],Confirmation,[Phone Number]) VALUES("
                + custID + "," + name + "," + email + "," + paymentMethod + "," + shipInfo + "," + confirmation + "," + phone + ")";

        Statement s = conn.createStatement();

        s.executeUpdate(stmt);

    }

    void insertDepartment(Connection conn) throws ClassNotFoundException, SQLException {
        int deptID = 0; //have the user able to enter this value
        String deptName = "'abc'"; //have the user able to enter this value

        String stmt = "INSERT INTO Department([Dept ID],[Dept Name]) VALUES("
                + deptID + "," + deptName + ")";

        Statement s = conn.createStatement();

        s.executeUpdate(stmt);

    }

    void insertItem(Connection conn) throws ClassNotFoundException, SQLException {
        int itemID = 0; //have the user able to enter this value
        String itemName = "'abc'"; //have the user able to enter this value
        String expDate = "'1/1/2099'"; //have the user able to enter this value
        double price = 0; //have the user able to enter this value
        int stock = 0; //have the user able to enter this value
        boolean onSale = false; //have the user able to enter this value

        String stmt = "INSERT INTO Item([Item ID],[Item Name],[Exp Date],Price,Stock,[On Sale]) VALUES("
                + itemID + "," + itemName + "," + expDate + "," + price + "," + stock + "," + onSale + ")";

        Statement s = conn.createStatement();

        s.executeUpdate(stmt);

    }

    // -------------------------------------------------MODIFICATION METHODS----------------------------------------------
    void modifyTable(Connection conn) throws ClassNotFoundException, SQLException {
        String tableToUpdate = "Customer";      //these are test cases, update them to 
        String columnToUpdate = "Shipping Info";
        String condition = "[Name]";
        String conditionValue = "'Cody'";
        String newValue = "'abcdefg'"; //need to be able to enter either int, string, double, or boolean

        String stmt = "UPDATE " + tableToUpdate + "\n"
                + "SET " + columnToUpdate + " = " + newValue
                + " WHERE " + condition +  " = " + conditionValue ;

        Statement s = conn.createStatement();

        s.executeUpdate(stmt);

    }

    void displayAllCustomers() {

    }

}
