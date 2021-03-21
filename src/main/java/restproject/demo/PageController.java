//package restproject.demo;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import restproject.demo.product.Product;
//
//@Controller
//@RequestMapping(path = "api/v1/products")
//public class PageController {
//    private final ProductRepository repository;
//
//    public PageController(ProductRepository repository) {
//        this.repository = repository;
//    }
//
//    @GetMapping("/")
//    public String main(){
//        return "index";
//    }
//
//    @GetMapping("/add")
//    public String addForm(Model model){
//        model.addAttribute("product", new Product());
//        return "add";
//    }
//    @GetMapping("/about")
//    public String getAbout(){
//        return "about";
//    }
//
//    @PostMapping("/add")
//    public String postForm(@ModelAttribute Product product, Model model){
//        model.addAttribute("product", product);
//        repository.save(product);
//
//        return "result";
//    }
//
//}
