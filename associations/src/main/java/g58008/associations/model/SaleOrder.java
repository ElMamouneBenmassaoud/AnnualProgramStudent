package g58008.associations.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SaleOrder {

    @Id
    private Long id;

    @ManyToOne
    private Customer customer;

    void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public SaleOrder(Long id) {
        this.id = id;
    }
}
