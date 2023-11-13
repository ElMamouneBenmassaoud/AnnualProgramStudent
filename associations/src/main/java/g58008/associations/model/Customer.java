package g58008.associations.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer")
    private List<SaleOrder> saleOrders;

    public void addOrder(SaleOrder saleOrder) {
        saleOrders.add(saleOrder);
        saleOrder.setCustomer(this);
    }
}
