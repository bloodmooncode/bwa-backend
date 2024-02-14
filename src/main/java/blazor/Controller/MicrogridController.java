package blazor.Controller;
import blazor.Entity.Microgrid;
import blazor.Service.MicrogridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;


/**
 * Created by ZYP on 2024/2/2 4:45PM
 */

@RestController
@RequestMapping(path="/microgrids") // This means URL's start with /demo (after Application path)
public class MicrogridController {
    @Autowired
    private MicrogridService microgridService;

    @GetMapping(path="/find/all")
    public Iterable<Microgrid> getAllMicrogrids() {
        return microgridService.getAllMicrogrids();
    }

    @GetMapping(path = "/find/{microgridId}")
    public Microgrid getOneMicrogrid(@PathVariable("microgridId") Integer id) {
        return microgridService.getOneMicrogrid(id);
    }


    @PostMapping(path = "/create")
    public void createMicrogrid(@RequestBody Microgrid microgrid) {
        microgridService.createMicrogrid(microgrid);
    }

    @PutMapping(path = "/update")
    void updateMicrogrid(Microgrid microgrid) {
        System.out.println("Put request");
    }

    @DeleteMapping(path = "/delete/{microgridId}")
    void deleteMicrogrid(@PathVariable("microgridId") Integer id) {
        microgridService.deleteMicrogrid(id);
    }
}
