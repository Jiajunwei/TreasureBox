package spring03;


import com.home.spring03.service.impl.BookServiceImpl;
import org.junit.Test;

public class TestTest {


    @Test
    public void testStoreBook() {
        BookServiceImpl bookService = new BookServiceImpl();
        bookService.storeBook("《Spring MVC权威指南 第一版》");
    }


}
