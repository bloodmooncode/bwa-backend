package blazor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZYP on 2024/2/2 1:03PM
 */
@SpringBootApplication
@RestController

public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public String indexPage() {
        // return index.html
        // default template directory: sec/main/resources/templates/
        return "index";
    }

}
