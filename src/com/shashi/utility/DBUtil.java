package com.shashi.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.shashi.beans.TrainException;
import com.shashi.constant.ResponseCode;

public class DBUtil {

    private static final ResourceBundle rb = ResourceBundle.getBundle("application");
    private static final String DRIVER_NAME = rb.getString("driverName");
    private static final String CONNECTION_STRING = rb.getString("connectionString");
    private static final String USERNAME = rb.getString("username");
    private static final String PASSWORD = rb.getString("password");

    static {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("Failed to load database driver: " + DRIVER_NAME);
        }
    }

    public static Connection getConnection() throws TrainException {
        try {
            return DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new TrainException(ResponseCode.DATABASE_CONNECTION_FAILURE);
        }
    }
}
