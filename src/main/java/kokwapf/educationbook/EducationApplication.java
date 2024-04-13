package kokwapf.educationbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EducationApplication {

    public static void main(String[] args) {
        // Inicia la aplicación
        SpringApplication.run(EducationApplication.class, args);

        // El método main no debe realizar pruebas con controladores.
    }

}
