package blazor.Controller;

/**
 * Created by ZYP on 2024/2/20 4:58PM
 */

import blazor.Entity.Element;
import blazor.Service.ELementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5277")
@Tag(name = "Elements")
@RestController
@RequestMapping("/microgrids")
public class ELementController {
    @Autowired
    ELementService eLementService;

    @Operation(summary = "Get Elements List of gridId")
    @GetMapping("/{microgridId}/elements/all")
    public List<Element> getAllElementsinOne(@PathVariable("microgridId") Integer microgridId) {
        return eLementService.getAllElementsinOne(microgridId);
    }

    @Operation(summary = "Get one Element of gridId")
    @GetMapping("/{microgridId}/elements/{elementId}")
    public ResponseEntity<Element> getElementById(@PathVariable("microgridId") Integer microgridId, @PathVariable("elementId") Integer elementId) {
        return eLementService.getElementById(microgridId, elementId);
    }

    @Operation(summary = "Get one Element in all")
    @GetMapping("all/elements/{elementId}")
    public ResponseEntity<Element> getElementById(@PathVariable("elementId") Integer elementId) {
        return eLementService.getElementById(elementId);
    }

    @Operation(summary = "Create one Element in gridId")
    @PostMapping("/{microgridId}/elements/create")
    public void createELement(@PathVariable("microgridId") Integer microgridId, @RequestBody Element element) {
        eLementService.createELement(microgridId, element);
    }

    @Operation(summary = "Delete one Element in gridId")
    @DeleteMapping("/{microgridId}/elements/delete/{elementId}")
    public void deleteMicrogrid(@PathVariable("microgridId") Integer microgridId, @PathVariable("elementId") Integer elementId) {
        eLementService.deleteMicrogrid(microgridId, elementId);
    }

    @Operation(summary = "Update one Element in gridId")
    @PutMapping("/elements/update/{elementId}")
    public void updateElement(@PathVariable("elementId") Integer elementId,  @RequestParam String name, String type, Double maximumBuyingPower, Double minimumBuyingPower, Double maximumSellingPower, Double minimumSellingPower) {
        eLementService.updateElement(elementId, name, type, maximumBuyingPower, minimumBuyingPower, maximumSellingPower, minimumSellingPower);
    }
}
