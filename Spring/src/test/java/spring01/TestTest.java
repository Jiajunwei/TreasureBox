package spring01;

import com.home.spring01.service.impl.BookServiceImpl;
import com.home.spring01.service.impl.StudentServiceImpl;
import org.junit.Test;

public class TestTest {


    @Test
    public void testStoreBook() {
        BookServiceImpl bookservice=new BookServiceImpl();
        bookservice.storeBook("《Spring MVC权威指南 第一版》");
    }

    @Test
    public void getStudent(){
        StudentServiceImpl studentService =  new StudentServiceImpl();
        String student = studentService.getStudent(1);
        System.out.println(student);
    }

}
