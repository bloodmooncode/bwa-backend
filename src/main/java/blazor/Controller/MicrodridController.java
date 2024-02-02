package blazor.Controller;
import blazor.entity.Microgrid;
import blazor.entity.MicrogridRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by ZYP on 2024/2/2 4:45PM
 */

@Controller // This means that this class is a Controller
@RequestMapping(path="/microgrids") // This means URL's start with /demo (after Application path)
public class MicrodridController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private MicrogridRepository microgridRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Microgrid> getAllMicrogrids() {
        // This returns a JSON or XML with the users
        return microgridRepository.findAll();
    }
}
