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
        System.out.println("ENV_1=" + System.getenv().get("ENV_1"));
        long result = visitorService.saveVisit();
        return "Hello Docker World. Count = " + result;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
