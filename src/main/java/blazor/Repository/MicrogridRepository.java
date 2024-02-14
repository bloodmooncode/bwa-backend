package blazor.Repository;

import blazor.Entity.Microgrid;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ZYP on 2024/2/2 4:43PM
 */
public interface MicrogridRepository extends JpaRepository<Microgrid, Integer> {
}
