package br.dev.hygino.config;

import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DatabaseConfig {

    private static DataSource dataSource;
private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "89631139";

    public static synchronized DataSource getDataSource() {
        if (dataSource == null) {
            MysqlDataSource mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setURL(DB_URL);
            mysqlDataSource.setUser(DB_USER);
            mysqlDataSource.setPassword(DB_PASSWORD);
            dataSource = mysqlDataSource;
        }
        return dataSource;
    }
}