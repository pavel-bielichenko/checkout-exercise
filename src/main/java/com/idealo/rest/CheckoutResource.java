package com.idealo.rest;

import com.idealo.rest.dto.CheckoutRs;
import com.idealo.rest.dto.Item;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/checkout")
public interface CheckoutResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    CheckoutRs checkout(List<Item> items); 
    
}
