package bankaccount.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    private final String url = "jdbc:postgresql://localhost/account";
    private final String user = "ajaym";
    private final String password = "";

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

}

