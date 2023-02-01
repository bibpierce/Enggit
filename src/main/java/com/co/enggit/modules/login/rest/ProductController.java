package com.co.enggit.modules.login.rest;

import com.co.enggit.modules.login.model.Product;
import com.co.enggit.modules.login.service.impl.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> findAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/find")
    public ResponseEntity<Optional<Product>> findById(@RequestBody Long id){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

}
