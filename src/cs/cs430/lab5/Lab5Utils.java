package cs.cs430.lab5;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Lab5Utils {
    private static  DatabaseAccess databaseAccess = DatabaseAccess.getInstance();
    public static int FAILURE = -1;

    public static void logMessage(final String message) {
        System.out.println(message);
    }

    public static ResultSet executeSelect(final String sqlStatement) {
//        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance();
        ResultSet resultSet = null;
        try {
            resultSet = databaseAccess.executeQuery(sqlStatement);
        } catch (final SQLException sqlE) {
            Lab5Utils.logMessage("Error while executing statement : " + sqlStatement);
            sqlE.printStackTrace();
        }
        return resultSet;
    }

    public static int updateOrInsertDatabase(final String sqlStatement) {
//        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance();
        int ret = Lab5Utils.FAILURE;
        try {
            ret = databaseAccess.updateDatabase(sqlStatement);
        } catch (SQLException e) {
            logMessage("Error while executing statement : " + sqlStatement);
            e.printStackTrace();
            return Lab5Utils.FAILURE ;
        }
        return ret;
    }

    public static boolean checkRecordFound(final ResultSet resultSet) {
        boolean found = false;
        try {
            if (resultSet.next()) {
                found = true;
            }
        } catch (final Exception exception) {
            found = false;
        }
        return found;
    }

    public static List<String> getAllColumnsAsString(final ResultSet resultSet, final String columnName) {
        final List<String> returnedValue = new ArrayList<>();
//        int columnValues = Lab5Utils.FAILURE;
        try {
            if (resultSet.next()) {
//                columnValues = resultSet.getInt(columnName);
            }
        } catch (final Exception exception) {
//            columnValues = Lab5Utils.FAILURE;
        }
        return returnedValue;
    }

    public static int getColumnAsInt(final ResultSet resultSet, final String columnName) {
        int columnValues = Lab5Utils.FAILURE;
        try {
            if (resultSet.next()) {
                columnValues = resultSet.getInt(columnName);
            }
        } catch (final Exception exception) {
            columnValues = Lab5Utils.FAILURE;
        }
        return columnValues;
    }
}
