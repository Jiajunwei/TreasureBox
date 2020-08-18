package spring09;

import com.home.spring_09_mybatis.entities.BookType;
import com.home.spring_09_mybatis.mapper.BookTypeDAO;
import com.home.spring_09_mybatis.mapper.impl.BookTypeDAOImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class TestTest {
    static BookTypeDAO bookTypeDao;
    @BeforeClass
    public static void beforeClass()
    {
        bookTypeDao=new BookTypeDAOImpl();
    }

    @Test
    public void testGetAllBookTypes() {
        List<BookType> booktypes=bookTypeDao.getAllBookTypes();
        for (BookType bookType : booktypes) {
            System.out.println(bookType);
        }
        assertNotNull(booktypes);
    }
}
