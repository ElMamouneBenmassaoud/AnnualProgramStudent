package g58008.associations.service;

import g58008.associations.database.CustomerRepository;
import g58008.associations.database.OrderRepository;
import g58008.associations.model.Customer;
import g58008.associations.model.SaleOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Crée une association entre Order et Customer en bi-directional et One To Many
 * WARNING : Aucune vérification, aucun display, que des urls.
 * HELP :
 * /customer/create -> create and store an employee in the database
 * /order/create -> create and store a department in the database
 * /customer/addOrder/{customerId}/{orderId} -> add an order to a customer (create a link between them in the db)
 */
@Service
public class OtmBidirectional {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    public void addCustomer(Long id, String name) {
        List<SaleOrder> saleOrders = new ArrayList<>();
        customerRepository.save(new Customer(id, name, saleOrders));
    }

    public void addOrder(Long id) {
        orderRepository.save(new SaleOrder(id));
    }

    public void addOrderToCustomer(Long orderId, Long customerId) {
        SaleOrder saleOrder = orderRepository.findById(orderId).get();
        Customer customer = customerRepository.findById(customerId).get();
        customer.addOrder(saleOrder);
        customerRepository.save(customer);
    }
}
