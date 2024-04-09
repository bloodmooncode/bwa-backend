package blazor.Service;

import blazor.Entity.Element;
import blazor.Entity.Microgrid;
import blazor.Entity.SellingPower;
import blazor.Repository.ELementRepository;
import blazor.Repository.MicrogridRepository;
import blazor.Repository.SellingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZYP on 2024/4/10 12:03AM
 */

@Service
public class SellingService {
    @Autowired
    private MicrogridRepository microgridRepository;
    @Autowired
    private ELementRepository eLementRepository;

    @Autowired
    private SellingRepository sellingRepository;

    public List<SellingPower> getAllSellingPowersinOne(@PathVariable("elementId") Integer elementId) {
        // 查询 Element
        Element element = eLementRepository.findById(elementId)
                .orElseThrow(() -> new RuntimeException("Element not found with id: " + elementId));
        List<SellingPower> sellingPowers = element.getSellingPowers();
        if (sellingPowers.isEmpty()) {
            return new ArrayList<>();
        }
        return sellingPowers;
    }

    public ResponseEntity<SellingPower> getSellingPowerById(@PathVariable("elementId") Integer elementId, @PathVariable("sellingPowerId") Integer sellingPowerId) {
        // 查询 Element
        Element element = eLementRepository.findById(elementId).orElse(null);
        if (element == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // 在 Element 中查找对应的 SellingPower
        SellingPower sellingPower = sellingRepository.findById(sellingPowerId).orElse(null);
        if (sellingPower == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // 如果找到了对应的 SellingPower，则返回
        return new ResponseEntity<>(sellingPower, HttpStatus.OK);
    }
}
