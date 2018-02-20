package com.idealo.item;

import com.idealo.CheckoutApplication;
import com.idealo.checkout.CheckoutService;
import com.idealo.rest.dto.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CheckoutApplication.class})
@SpringBootTest
@DirtiesContext
public class CheckoutServiceTest {

    @Autowired
    protected CheckoutService checkoutService;

    ArrayList<Item> items1;
    ArrayList<Item> items2;
    ArrayList<Item> items3;
    ArrayList<Item> items4;
    ArrayList<Item> items5;
    ArrayList<Item> items6;
    ArrayList<Item> items7;
    ArrayList<Item> items8;
    ArrayList<Item> items9;
    ArrayList<Item> items10;
    ArrayList<Item> items11;
    ArrayList<Item> items12;
    ArrayList<Item> items13;


    @Before
    public void pupulate() {
        items1 = newArrayList(new Item(""));
        items2 = newArrayList(new Item("A"));
        items3 = newArrayList(new Item("A"), new Item("B"));
        items4 = newArrayList(new Item("C"), new Item("D"), new Item("B"), new Item("A"));
        items5 = newArrayList(new Item("A"), new Item("A"));
        items6 = newArrayList(new Item("A"), new Item("A"), new Item("A"));
        items7 = newArrayList(new Item("A"), new Item("A"), new Item("A"), new Item("A"));
        items8 = newArrayList(new Item("A"), new Item("A"), new Item("A"), new Item("A"), new Item("A"));
        items9 = newArrayList(new Item("A"), new Item("A"), new Item("A"), new Item("A"), new Item("A"), new Item("A"));
        items10 = newArrayList(new Item("A"), new Item("A"), new Item("A"), new Item("B"));
        items11 = newArrayList(new Item("A"), new Item("A"), new Item("A"), new Item("B"), new Item("B"));
        items12 = newArrayList(new Item("A"), new Item("A"), new Item("A"), new Item("B"), new Item("B"), new Item("D"));
        items13 = newArrayList(new Item("D"), new Item("A"), new Item("B"), new Item("A"), new Item("B"), new Item("A"));
    }

    @Test
    public void totals() {
        Assert.assertEquals(new Double(0), checkoutService.calculateTotal(items1));
        Assert.assertEquals(new Double(40), checkoutService.calculateTotal(items2));
        Assert.assertEquals(new Double(90), checkoutService.calculateTotal(items3));
        Assert.assertEquals(new Double(135), checkoutService.calculateTotal(items4));
        Assert.assertEquals(new Double(80), checkoutService.calculateTotal(items5));
        Assert.assertEquals(new Double(100), checkoutService.calculateTotal(items6));
        Assert.assertEquals(new Double(140), checkoutService.calculateTotal(items7));
        Assert.assertEquals(new Double(180), checkoutService.calculateTotal(items8));
        Assert.assertEquals(new Double(200), checkoutService.calculateTotal(items9));
        Assert.assertEquals(new Double(150), checkoutService.calculateTotal(items10));
        Assert.assertEquals(new Double(180), checkoutService.calculateTotal(items11));
        Assert.assertEquals(new Double(200), checkoutService.calculateTotal(items12));
        Assert.assertEquals(new Double(200), checkoutService.calculateTotal(items13));
    }
}
