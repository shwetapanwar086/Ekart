package com.MobiShop.MobiShopBackend.dao;

import java.io.IOException;

import com.MobiShop.MobiShopBackend.model.Cart;



public interface CartDao {

    Cart getCartById (int cartId);
    
   Cart validate(int cartId) throws IOException;  
    
    public void update(Cart cart);
}
