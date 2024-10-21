package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
    public static String getPropertyString(String propertyFile) {
        Properties properties = new Properties();
        StringBuilder url = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(propertyFile)) {
            properties.load(fis);
            String serverName = properties.getProperty("servername");
            String dbName = properties.getProperty("dbname");

            url.append("jdbc:mysql://")
               .append(serverName)
               .append("/")
               .append(dbName);
            return url.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
