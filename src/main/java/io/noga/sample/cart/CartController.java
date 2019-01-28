package io.noga.sample.cart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.noga.sample.Model.Product;
import io.noga.sample.Model.Response;

/**
 * CartController { "id": 2, "title": "Cat Close Up", "thumb": "cat2.jpg",
 * "price": 23.95, "tags": [ "cat", "face" ] },
 */
@RestController
public class CartController {


    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @PostMapping(path = "/carts", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Response addProductToCart(@RequestBody Product product) {
        logger.info("Item in cart added: {}",product.toString());
        return new Response();
    }
    @DeleteMapping(path = "/carts/{id}", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Response removeProdcutFromCart(@PathVariable String id) {
        logger.info("Item in cart removed: ID-{}",id);
        return new Response();
    }
    
    
}