package com.example.foodly.data

import com.example.foodly.R
import com.example.foodly.model.MyOrders


object MyOrdersDataDummy {
    val myOrders = MyOrders(
        1,
        R.drawable.burger,
        "Chicken Burger",
        2000
    )

    val myOrdersList = listOf(
        myOrders,
        myOrders.copy(
            id = 2,
            ordersImageId = R.drawable.burger2,
            name = "Beef Burger",
            price = 2500
        ),
        myOrders.copy(
            id = 3,
            ordersImageId = R.drawable.pizza,
            name = "Chicken Pizza",
            price = 9000
        ),
        myOrders.copy(
            id = 3,
            ordersImageId = R.drawable.okok,
            name = "Plat d'Okok",
            price = 2500
        )

    )
}