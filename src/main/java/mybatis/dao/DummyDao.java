package mybatis.dao;

import mybatis.domain.Dummy;
import mybatis.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author Pavel Gavrilov
 *         05.09.2017.
 */
public class DummyDao {
    public static void addOne(Dummy dummy) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.insert("DummyMapper.addOne", dummy);
        session.commit();
        session.close();
    }

    public static void upadteOne(Dummy dummy) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.update("DummyMapper.updateOne", dummy);
        session.commit();
        session.close();
    }

    public static void deleteOne(long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.delete("DummyMapper.deleteOne", id);
        session.commit();
        session.close();
    }

    public static Dummy getOne(long id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        Dummy dummy = session.selectOne("com.concretepage.VillageMapper.selectVillage", id);
        session.close();
        return dummy;
    }
}
