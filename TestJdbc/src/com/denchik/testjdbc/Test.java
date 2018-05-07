package com.denchik.testjdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class Test
{
    public Test()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@10.100.22.13:1521:MURTST", "sik4", "sik4");

            ResultSet rs = conn.createStatement().executeQuery(
                "select * from business_units where rownum < 10");

            System.out.println(formatResultSet(rs));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new Test();
    }

    private String formatResultSet(ResultSet resultSet) throws SQLException
    {
        String result = new String();

        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next())
        {
            for (int i = 1; i <= columnsNumber; i++)
            {
                if (i > 1)
                    result += (",  ");
                String columnValue = resultSet.getString(i);
                result += (columnValue + " " + rsmd.getColumnName(i));
            }
            result += ("\n");
        }

        return result;
    }
}
