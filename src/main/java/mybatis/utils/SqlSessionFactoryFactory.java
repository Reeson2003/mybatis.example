package mybatis.utils;

import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Pavel Gavrilov
 *         05.09.2017.
 */
public class SqlSessionFactoryFactory {
    public static SqlSessionFactory getFactoryFromResource() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        inputStream = Resources.getResourceAsStream(resource);
        return  new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSessionFactory getFactoryFromProperties() {
        String driver = MybatisProperties.JDBC_DRIVER;
        String dbUrl = MybatisProperties.JDBC_URL;
        String user = MybatisProperties.JDBC_USERNAME;
        String password = MybatisProperties.JDBC_PASSWORD;
        String mapperFile = "mapper/dummyMapper.xml";
        Configuration configuration = new Configuration((new Environment(
                "development",
                new JdbcTransactionFactory(),
                new PooledDataSource(driver, dbUrl, user, password)) ));
        InputStream in = SqlSessionFactory.class.getClassLoader().getResourceAsStream(mapperFile);
        XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(in, configuration, mapperFile, configuration.getSqlFragments());
        xmlMapperBuilder.parse();
        return new SqlSessionFactoryBuilder().build(configuration);
    }

}
