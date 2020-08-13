package spring04;


import com.home.spring04.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTest {

    @Test
    public void testStoreBook() {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring04/spring-config.xml");
        BookService bookservice=ctx.getBean(BookService.class);
        bookservice.storeBook("《Spring MVC权威指南 第三版》");
    }


}
