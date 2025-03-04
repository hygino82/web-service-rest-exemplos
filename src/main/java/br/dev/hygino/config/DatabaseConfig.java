package br.dev.hygino.config;

import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DatabaseConfig {

    private static DataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            MysqlDataSource mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setURL("jdbc:mysql://localhost:3306/testdb");
            mysqlDataSource.setUser("hygino");
            mysqlDataSource.setPassword("89631139");
            dataSource = mysqlDataSource;
        }
        return dataSource;
    }
}
