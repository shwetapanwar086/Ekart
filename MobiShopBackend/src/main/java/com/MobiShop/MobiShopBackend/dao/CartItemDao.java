package com.MobiShop.MobiShopBackend.dao;

import java.util.List;

import com.MobiShop.MobiShopBackend.model.Cart;
import com.MobiShop.MobiShopBackend.model.CartItem;



public interface CartItemDao {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId (String id,int cartId);
    
   List<CartItem> getAllCartItems(int cartId);

}