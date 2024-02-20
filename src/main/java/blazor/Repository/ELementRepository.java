package blazor.Repository;

import blazor.Entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ZYP on 2024/2/20 6:04PM
 */
public interface ELementRepository extends JpaRepository<Element, Integer> {
}
