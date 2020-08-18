package come.home.spring02_01.application;

import come.home.spring02_01.entities.BookType;
import come.home.spring02_01.mapping.BookTypeDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static junit.framework.Assert.assertNotNull;

public class Application {
    public static void main(String[] args) {
        // test.TestTest
        test02();
    }

    private static void test02(){
        //初始化容器
        ApplicationContext ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //获得bean
        BookTypeDAO bookTypeDao=ctx.getBean("bookTypeDao",BookTypeDAO.class);
        //访问数据库
        List<BookType> bookTypes=bookTypeDao.getAllBookTypes();
        for (BookType bookType : bookTypes) {
            System.out.println(bookType);
        }
        assertNotNull(bookTypes);
    }
}
