package jfSpringBoot.Controller;

import jfSpringBoot.Model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/customers")

public class CustomerController {
    private List<Customer> customers = new ArrayList<>(Arrays.asList(
        new Customer(1, "Juan", "jonh", "123456"),
        new Customer(2, "julio", "jully", "123456"),
        new Customer(3, "gerry", "gerry", "123456"),
        new Customer(4, "sandra", "sandy", "123456")
    ));

    @GetMapping()
    public ResponseEntity<List<Customer>> getCustomers()
    {
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getCustomer(@PathVariable String name)
    {
        for (Customer c : customers){
            if(c.getUserName().equalsIgnoreCase(name)){
                return ResponseEntity.ok(c);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con user name "+name);
    }

    @PostMapping("/add-customer")
    public ResponseEntity<?> AddCustomer(@RequestBody Customer customer)
    {
        customers.add(customer);

        //        URI location = ServletUriComponentsBuilder
        //                .fromCurrentRequest()
        //                .path("/{name}")
        //                .buildAndExpand(customer.getUserName())
        //                .toUri();
        //
        //        return ResponseEntity.created(location).build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/customers/{name}")
                .buildAndExpand(customer.getUserName())
                .toUri();

        return ResponseEntity.created(location).body(customer);
    }

    @PutMapping("/update-customer")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer)
    {
        for (Customer c : customers)
        {
            if(c.getId() == customer.getId()){
                c.setName(customer.getName());
                c.setUserName(customer.getUserName());
                c.setPassword(customer.getPassword());

                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete-customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id)
    {
        for (Customer c : customers)
        {
            if (c.getId() == id){
                customers.remove(c);
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/patch-customer")
    public ResponseEntity<?> patchCustomer(@RequestBody Customer customer)
    {
        for (Customer c: customers){
            if (c.getId() == customer.getId()){
                if(customer.getName() != null){
                    c.setName(customer.getName());
                }

                if(customer.getUserName() != null){
                    c.setUserName(customer.getUserName());
                }

                if(customer.getPassword() != null){
                    c.setPassword(customer.getPassword());
                }

                return ResponseEntity.ok("Cliente modificado con exito "+customer.getUserName());
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no econtrado "+ customer.getId());
    }
}
