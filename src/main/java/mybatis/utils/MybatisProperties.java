package mybatis.utils;


import java.io.IOException;
import java.util.Properties;

public class MybatisProperties {

    private static Properties _properties;
    private static final String PROPERTIES_FILE_NAME = "database.properties";

    public static final String JDBC_URL = get("database.url");
    public static final String JDBC_DRIVER = get("database.driver");
    public static final String JDBC_USERNAME = get("database.username");
    public static final String JDBC_PASSWORD = get("database.password");

    public static String get(String key) {
        return _getProperties().get(key) + "";
    }

    private static Properties _getProperties() {
        if (_properties == null) {
            _properties = new Properties();
            try {
                _properties.load(MybatisProperties.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME));
                System.out.println("Load " + PROPERTIES_FILE_NAME + " from classpath");
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return _properties;
    }
}
