package mybatis.utils;

import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

/**
 * @author Pavel Gavrilov
 *         05.09.2017.
 */
public class MyBatisUtil {

    public static SqlSessionFactory getSqlSessionFactory(){
//        try {
//            return SqlSessionFactoryFactory.getFactoryFromResource();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;

        return SqlSessionFactoryFactory.getFactoryFromProperties();
    }
}
