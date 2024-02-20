package blazor.Controller;
import blazor.Entity.Microgrid;
import blazor.Service.MicrogridService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * Created by ZYP on 2024/2/2 4:45PM
 */
@Tag(name = "Microgrids")
@RestController
@RequestMapping(path="/microgrids") // This means URL's start with /demo (after Application path)
public class MicrogridController {
    @Autowired
    private MicrogridService microgridService;

    @Operation(summary = "Get Grids List")
    @GetMapping(path="/all")
    public List<Microgrid> getAllMicrogrids() {
        return microgridService.getAllMicrogrids();
    }

    @Operation(summary = "Get one grid by id")
    @GetMapping(path = "/{microgridId}")
    public Microgrid getOneMicrogrid(@PathVariable("microgridId") Integer id) {
        return microgridService.getOneMicrogrid(id);
    }

    @Operation(summary = "Create a new grid")
    @PostMapping(path = "/create")
    public void createMicrogrid(@RequestBody Microgrid microgrid) {
        microgridService.createMicrogrid(microgrid);
    }

    @Operation(summary = "Update the grid info")
    @PutMapping(path = "/update")
    void updateMicrogrid(Microgrid microgrid) {
        System.out.println("Put request");
    }

    @Operation(summary = "Delete a grid by id")
    @DeleteMapping(path = "/delete/{microgridId}")
    void deleteMicrogrid(@PathVariable("microgridId") Integer id) {
        microgridService.deleteMicrogrid(id);
    }
}
