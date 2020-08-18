package come.home.spring02_01.dao;

import java.util.List;

import come.home.spring02_01.entities.BookType;
import come.home.spring02_01.mapping.BookTypeDAO;
import org.apache.ibatis.session.SqlSession;


/**
 * 实现图书类型数据访问
 *
 */
public class BookTypeDAOImpl implements BookTypeDAO {

	public List<BookType> getAllBookTypes() {
		//获得会话对象
		SqlSession session=MyBatisUtil.getSession();
		try {
			//通过MyBatis实现接口BookTypeDAO，返回实例
			BookTypeDAO bookTypeDAO=session.getMapper(BookTypeDAO.class);
			return bookTypeDAO.getAllBookTypes();
		} finally {
			session.close();
		}
	}

}
