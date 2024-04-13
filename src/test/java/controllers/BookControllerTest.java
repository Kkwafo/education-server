package controllers;

import kokwapf.educationbook.EducationApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = EducationApplication.class)
class BookControllerTest {


    @Test
    void sayHello() {
        BookController bookController = new BookController();
        System.out.println(bookController.sayHello());

    }
}