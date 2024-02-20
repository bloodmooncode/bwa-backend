package blazor.Service;

import blazor.Entity.Microgrid;
import blazor.Repository.MicrogridRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by ZYP on 2024/2/13 9:08PM
 */

@Service
public class MicrogridService {
    @Autowired
    private MicrogridRepository microgridRepository;

    public List<Microgrid> getAllMicrogrids() {
        return microgridRepository.findAll();
    }

    public Microgrid getOneMicrogrid(@PathVariable("microgridId") Integer id) {
        return microgridRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Microgrid not found with id: " + id));
    }

    public void createMicrogrid(@RequestBody Microgrid microgrid) {
        microgridRepository.save(microgrid);
    }

    public void deleteMicrogrid(@PathVariable("microgridId") Integer id) {
        microgridRepository.deleteById(id);
    }
}

