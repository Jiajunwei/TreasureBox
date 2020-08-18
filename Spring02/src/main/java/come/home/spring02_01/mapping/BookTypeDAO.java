package come.home.spring02_01.mapping;

import java.util.List;

import come.home.spring02_01.entities.BookType;

/**
 * 图书类型数据访问接口
 *
 */
public interface BookTypeDAO {
	/*
	 * 获得所有图书类型
	 */
	public List<BookType> getAllBookTypes();
}
