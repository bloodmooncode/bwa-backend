package blazor.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by ZYP on 2024/2/2 4:43PM
 */
public interface MicrogridRepository extends JpaRepository<Microgrid, Integer> {

}
