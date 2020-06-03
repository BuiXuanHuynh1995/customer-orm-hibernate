package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.customer.ICustomerService;

@Controller
@RequestMapping("/")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ModelAndView getAllCustomer(){
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers",customerService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    private ModelAndView showFormCreateCustomer(){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    private ModelAndView createCustomer(@ModelAttribute Customer customer, Model model){
        customerService.saveOrUpdate(customer);
        model.addAttribute("sucess","Create customer sucessfully");
        return getAllCustomer();
    }

    @GetMapping("/update")
    private ModelAndView showFormEditCustomer(@RequestParam Long id){
        ModelAndView modelAndView = new ModelAndView("/customer/update");
        modelAndView.addObject("customer",customerService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    private ModelAndView showFormEditStudent(@ModelAttribute Customer customer,Model model){
        customerService.saveOrUpdate(customer);
        model.addAttribute("success", "Update customer successfully!");
        return getAllCustomer();
    }

}
