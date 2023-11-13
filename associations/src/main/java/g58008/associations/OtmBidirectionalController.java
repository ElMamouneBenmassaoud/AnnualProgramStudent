package g58008.associations;

import g58008.associations.service.OtmBidirectional;
import g58008.associations.service.OtmUnidirectional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtmBidirectionalController {
    @Autowired
    private OtmBidirectional otmBidirectional;

    @GetMapping("/customer/create")
    public ResponseEntity<String> createDpt(Model model) {
        otmBidirectional.addCustomer(1L, "Cameron");
        return new ResponseEntity<>("Customer created", HttpStatus.OK);
    }

    @GetMapping("/order/create")
    public ResponseEntity<String> createEmp(Model model) {
        otmBidirectional.addOrder(1L);
        return new ResponseEntity<>("Order created", HttpStatus.OK);
    }

    @GetMapping("/customer/addOrder/{customerId}/{orderId}")
    public ResponseEntity<String> addEmpToDpt(Model model, @PathVariable("customerId") Long customerId, @PathVariable("orderId") Long orderId) {
        otmBidirectional.addOrderToCustomer(orderId, customerId);
        return new ResponseEntity<>("Customer added to order", HttpStatus.OK);
    }
}
