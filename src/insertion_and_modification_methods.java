
import java.io.*;
import java.sql.*;

public class insertion_and_modification_methods {

    static final String JDBC_DRIVER = "net.ucanaccess.jdbc.UcanaccessDriver";
    
    //IMPORTANT! This is assuming that the file is in the src directory with the rest of the .java files. update if necessary!!!
    static final String TARGUT = "Targut.accdb";

    insertion_and_modification_methods() {

    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        insertion_and_modification_methods db = new insertion_and_modification_methods();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

        try {

            connection = DriverManager.getConnection(TARGUT);

            statement = connection.createStatement();

            // db.insertItem(connection); //   THIS IS A TEST TO INSERT AN ITEM
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

        int custID = 99;
        String name = "'abc'";          // !!!!!!!!!! make sure any user entered string values have single quotes attached to both ends. ie) abc would become 'abc'
        String email = "'abc'";
        String paymentMethod = "'abc'";
        String shipInfo = "'abc'";
        boolean confirmation = true;
        int phone = 1234567;

        String stmt = "INSERT INTO Customer([Customer ID],[Cust Name],Email,[Payment Method],[Shipping Info],Confirmation,[Phone Number]) VALUES("
                + custID + "," + name + "," + email + "," + paymentMethod + "," + shipInfo + "," + confirmation + "," + phone + ")";

        Statement s = conn.createStatement();

        s.executeUpdate(stmt);

    }

    void insertDepartment(Connection conn) throws ClassNotFoundException, SQLException {
        int deptID = 0;

        String deptName = "'abc'";

        String stmt = "INSERT INTO Department([Dept ID],[Dept Name]) VALUES("
                + deptID + "," + deptName + ")";

        Statement s = conn.createStatement();

        s.executeUpdate(stmt);

    }

    void insertItem(Connection conn) throws ClassNotFoundException, SQLException {
        int itemID = 0;

        String itemName = "'abc'";

        String expDate = "'1/1/2099'";

        double price = 0;

        int stock = 0;

        boolean onSale = false;

        String stmt = "INSERT INTO Item([Item ID],[Item Name],[Exp Date],Price,Stock,[On Sale]) VALUES("
                + itemID + "," + itemName + "," + expDate + "," + price + "," + stock + "," + onSale + ")";

        Statement s = conn.createStatement();

        s.executeUpdate(stmt);

    }

    // -------------------------------------------------MODIFICATION METHODS----------------------------------------------
    void modifyTable(Connection conn) throws ClassNotFoundException, SQLException {
        String tableToUpdate = "Customer";      //these are test cases, update them to 
        String columnToUpdate = "Phone";

        String stmt = "UPDATE " + tableToUpdate + "\n"
                + "SET " + columnToUpdate + " = 0000000";

        Statement s = conn.createStatement();

        s.executeUpdate(stmt);

    }

    void displayAllCustomers() {

    }

}
