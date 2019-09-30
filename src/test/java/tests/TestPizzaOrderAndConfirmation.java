package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static core.Application.atPizzaOrderPage;
import static core.Application.atStartPage;

public class TestPizzaOrderAndConfirmation {

    Connection con = null;
    Statement stmt;
    String DB_URL = "jdbc:mysql://hostname/ databaseName";
    String DB_USER = "user";
    String DB_PASSWORD = "root";
    String ORDER_ID;

    @BeforeTest
    public void setUp() throws Exception {
        try {
            String dbClass = "com.mysql.cj.jdbc.Driver";
            Class.forName(dbClass).newInstance();
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void orderAndConfirmPizzaTest() throws Exception {
        atStartPage()
                .openPizzaOrderForm()
                .assertPizzaOrderFormTransition();
        atPizzaOrderPage()
                .addPizzaMargaritaToCart()
                .openCart()
                .fillOutDeliveryAddress()
                .fillOutDeliveryTime()
                .confirmTheOrder();

        try {
            String query = "select * from order where phone='1-925-2435-234' and date= '30.09.2019' ";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                ORDER_ID = (res.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ORDER_ID.equals(null)) {
            throw new Exception("The order ID is not added to DB");
        } else {
            System.out.println(ORDER_ID);
        }
    }

    @AfterTest
    public void tearDown() throws Exception {
        if (con != null) {
            con.close();
        }
    }
}