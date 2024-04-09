package blazor.Service;

import blazor.Entity.Element;
import blazor.Entity.Microgrid;
import blazor.Entity.SellingPower;
import blazor.Repository.ELementRepository;
import blazor.Repository.MicrogridRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ZYP on 2024/2/20 4:58PM
 */
@Service
public class ELementService {
    @Autowired
    private MicrogridRepository microgridRepository;

    @Autowired
    private ELementRepository eLementRepository;

    public List<Element> getAllElementsinOne(@PathVariable("microgridId") Integer microgridId) {
        // 查询 Microgrid
        Microgrid microgrid = microgridRepository.findById(microgridId)
                .orElseThrow(() -> new RuntimeException("Microgrid not found with id: " + microgridId));
        List<Element> elements = microgrid.getElements();
        if (elements.isEmpty()) {
            return new ArrayList<>();
        }
        return elements;
    }

    public ResponseEntity<Element> getElementById(@PathVariable("microgridId") Integer microgridId, @PathVariable("elementId") Integer elementId) {
        // 查询 Microgrid
        Microgrid microgrid = microgridRepository.findById(microgridId).orElse(null);
        if (microgrid == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // 在 Microgrid 中查找指定的 Element
        Element element = null;
        for (Element e : microgrid.getElements()) {
            if (e.getId().equals(elementId)) {
                element = e;
                break;
            }
        }

        if (element == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(element, HttpStatus.OK);
    }

    public void createELement(@PathVariable("microgridId") Integer microgridId, @RequestBody Element element) {
        eLementRepository.save(element);
        Microgrid microgrid = microgridRepository.findById(microgridId) .orElseThrow(() -> new RuntimeException("Microgrid not found with id: " + microgridId));
        microgrid.getElements().add(element);
        microgridRepository.save(microgrid);
    }

    public void deleteMicrogrid(@PathVariable("microgridId") Integer microgridId, @PathVariable("elementId") Integer elementId) {
        // 查找要删除的 Element
        Element element = eLementRepository.findById(elementId)
                .orElseThrow(() -> new RuntimeException("Element not found with id: " + elementId));

        Microgrid microgrid = microgridRepository.findById(microgridId)
                .orElseThrow(() -> new RuntimeException("Microgrid not found with id: " + microgridId));

        // 从 Microgrid 的 elements 列表中移除要删除的 Element
        microgrid.getElements().remove(element);

        // 保存 Microgrid 对象，级联更新 Element 关联关系
        microgridRepository.save(microgrid);

        // 删除 Element
        eLementRepository.deleteById(elementId);
    }

    public void updateElement(@PathVariable("elementId") Integer elementId,  @RequestParam String name, String type, Double maximumBuyingPower, Double minimumBuyingPower, Double maximumSellingPower, Double minimumSellingPower) {
        // 获取要替换的旧 Element 对象
        Element oldElement = eLementRepository.findById(elementId)
                .orElseThrow(() -> new RuntimeException("Element not found with id: " + elementId));

        // 更新旧 Element 对象的属性
        oldElement.setName(name);
        oldElement.setType(type);
        oldElement.setMaximumBuyingPower(maximumBuyingPower);
        oldElement.setMinimumBuyingPower(minimumBuyingPower);
        oldElement.setMaximumSellingPower(maximumSellingPower);
        oldElement.setMinimumSellingPower(minimumSellingPower);

        // 保存更新后的 Element 对象到数据库中
        eLementRepository.save(oldElement);
    }

    public List<Integer> getSellingPowerIdsByElementId(Integer elementId) {
        Element element = eLementRepository.findById(elementId).orElse(null);
        if (element != null) {
            List<Integer> sellingPowerIds = new ArrayList<>();
            for (SellingPower sellingPower : element.getSellingPowers()) {
                sellingPowerIds.add(sellingPower.getId());
            }
            return sellingPowerIds;
        }
        return Collections.emptyList();
    }
}
