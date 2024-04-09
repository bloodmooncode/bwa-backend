package blazor.Controller;

import blazor.Entity.SellingPower;
import blazor.Service.SellingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ZYP on 2024/4/10 12:02AM
 */
@CrossOrigin(origins = "http://localhost:5277")
@Tag(name = "SellingPowers")
@RestController
@RequestMapping("/elements")
public class SellingController {
    @Autowired
    SellingService sellingService;

    @Operation(summary = "Get SellingPowers of elementId")
    @GetMapping ("/{elementId}/sellingPowers/all")
    public List<SellingPower> getAllSellingPowersinOne(@PathVariable("elementId") Integer elementId) {
        return sellingService.getAllSellingPowersinOne(elementId);
    }

    @Operation(summary = "Get one SellingPower of elementId")
    @GetMapping ("{elementId}/sellingPowers/{sellingPowerId}")
    public ResponseEntity<SellingPower> getSellingPowerById(@PathVariable("elementId") Integer elementId, @PathVariable("sellingPowerId") Integer sellingPowerId) {
        return sellingService.getSellingPowerById(elementId, sellingPowerId);
    }
}
