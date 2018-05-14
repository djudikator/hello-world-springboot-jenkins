package hello;

import hello.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
    @Autowired
    private VisitorService visitorService;

    @RequestMapping("/")
    public String home() {
        long result = visitorService.saveVisit();
        StringBuilder sb = new StringBuilder();
        sb.append("MYSQL_ROOT_HOST =").append(System.getenv().get("MYSQL_ROOT_HOST")).append(" ");
        sb.append("DB_HOST =").append(System.getenv().get("DB_HOST")).append(" ");
        sb.append("DB_PORT =").append(System.getenv().get("DB_PORT")).append(" ");
        sb.append("DB_USER =").append(System.getenv().get("DB_USER")).append(" ");
        sb.append("DB_PASSWORD =").append(System.getenv().get("DB_PASSWORD"));

        return "Hello Docker World. Count = " + result + "Env Vars: " + sb.toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
