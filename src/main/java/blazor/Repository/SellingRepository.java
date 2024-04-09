package blazor.Repository;

import blazor.Entity.SellingPower;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ZYP on 2024/4/10 12:02AM
 */
public interface SellingRepository extends JpaRepository<SellingPower, Integer> {
}


