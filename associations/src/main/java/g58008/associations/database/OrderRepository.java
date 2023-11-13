package g58008.associations.database;

import g58008.associations.model.SaleOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<SaleOrder, Long> {
}
