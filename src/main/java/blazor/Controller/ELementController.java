package blazor.Controller;

/**
 * Created by ZYP on 2024/2/20 4:58PM
 */

import blazor.Entity.Element;
import blazor.Service.ELementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/microgrids")
public class ELementController {
    @Autowired
    ELementService eLementService;

    @GetMapping("/{microgridId}/elements/all")
    public List<Element> getAllElementsinOne(@PathVariable("microgridId") Integer microgridId) {
        return eLementService.getAllElementsinOne(microgridId);
    }

    @GetMapping("/{microgridId}/elements/{elementId}")
    public ResponseEntity<Element> getElementById(@PathVariable("microgridId") Integer microgridId, @PathVariable("elementId") Integer elementId) {
        return eLementService.getElementById(microgridId, elementId);
    }

    @PostMapping("/{microgridId}/elements/create")
    public void createELement(@PathVariable("microgridId") Integer microgridId, @RequestParam String name, String type, Double maximumBuyingPower, Double minimumBuyingPower, Double maximumSellingPower, Double minimumSellingPower) {
        eLementService.createELement(microgridId , name,  type, maximumBuyingPower, minimumBuyingPower, maximumSellingPower, minimumSellingPower);
    }

    @DeleteMapping("/{microgridId}/elements/delete/{elementId}")
    public void deleteMicrogrid(@PathVariable("microgridId") Integer microgridId, @PathVariable("elementId") Integer elementId) {
        eLementService.deleteMicrogrid(microgridId, elementId);
    }

    @PutMapping("/elements/update/{elementId}")
    public void updateElement(@PathVariable("elementId") Integer elementId,  @RequestParam String name, String type, Double maximumBuyingPower, Double minimumBuyingPower, Double maximumSellingPower, Double minimumSellingPower) {
        eLementService.updateElement(elementId, name, type, maximumBuyingPower, minimumBuyingPower, maximumSellingPower, minimumSellingPower);
    }
}
