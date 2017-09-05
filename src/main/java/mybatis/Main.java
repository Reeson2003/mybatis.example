package mybatis;

import mybatis.dao.DummyDao;
import mybatis.domain.Dummy;

import java.util.Date;

/**
 * @author Pavel Gavrilov
 *         05.09.2017.
 */
public class Main {
    public static void main(String[] args) {
        Dummy dummy = new Dummy();
        dummy.setText("TEXT");
        dummy.setDate(new Date());
        DummyDao.addOne(dummy);
    }
}
