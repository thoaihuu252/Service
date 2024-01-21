package com.example.service.controller;
import com.example.service.Model.Order;
import com.example.service.Model.Orderr;
import com.example.service.Model.Userdbb;
import com.example.service.Service.OrderSv;
import com.example.service.Service.UserSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/web/orders")
public class OrderController {

    @Autowired
    private OrderSv orderrService;

    @GetMapping("/all")
    public String getAllOrders(Model model) {
        List<Orderr> orders = orderrService.getAllOrder();
        model.addAttribute("orders", orders);
        return "home"; // Tên của template Thymeleaf (ví dụ: orders.html)
    }
    @GetMapping("/status")
    public String getOrdersByStatus( Model model) {
        List<Order> orders = orderrService.findByStatus("Pending");
        model.addAttribute("orders", orders);
        return "home";
    }
    @GetMapping("/statusC")
    public String getOrdersByStatusC( Model model) {
        List<Order> orders = orderrService.findByStatus("Complete");
        model.addAttribute("orders", orders);
        return "home";
    }
    @GetMapping("/{id}")
    public String getAllOrders(@PathVariable("id")String id ,Model model) {
        Orderr orders = orderrService.getAllOrderbyID2(id);
        model.addAttribute("orders", orders);
        return "detail";
    }
    @GetMapping("/neworder")
    public String showformNew(Model model) {
        model.addAttribute("orderr", new Orderr());
        return "create";
    }

    @PostMapping("/addOrder")
    public String addOrder(@ModelAttribute("order") Orderr orderr) {
        // Lưu đơn hàng và sản phẩm vào cơ sở dữ liệu
        orderrService.save(orderr);
        return "redirect:/all";
    }
    @GetMapping("/accept-order/{id}")
    public String AcceptOrder(@PathVariable String id, @RequestParam String newStatus) {
        orderrService.updateOrderStatus(id,newStatus);
        return "home";

    }
    @GetMapping("/refuse-order/{id}")
    public String refuseOrder(@PathVariable String id, @RequestParam String newStatus) {
        orderrService.updateOrderStatus(id,newStatus);
       return "home";

    }
    @Autowired
    private UserSv userSv;
    @GetMapping("/allUser")
    public String getUserById(Model model) {
        List<Userdbb> user= userSv.getAllUser();
        model.addAttribute("users",user);
        return "Alluser";
    }
    @GetMapping("/deleteUser/{id}")
    public String getUserById(@PathVariable String id,Model model) {
        userSv.deleteUser(id);
        List<Userdbb> user= userSv.getAllUser();
        model.addAttribute("users",user);
        return "Alluser";
    }
}


