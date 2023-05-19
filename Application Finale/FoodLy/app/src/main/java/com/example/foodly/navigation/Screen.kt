package com.example.foodly.navigation

sealed class Screen(val route: String){

    object Splash: Screen("Splash_screen")
    object PageViewScreen: Screen("page_view_screen")
    object Lets_You_In: Screen("let_you_in")
    object HomeScreen: Screen("home_screen")
    object OrderScreen: Screen("order_screen")
    object EWalletScreen: Screen("e_wallet")
    object OtpVerifyScreen: Screen("otp_verify")
    object ProfileScreen: Screen("profile_screen")
    object RegisterScreen: Screen("register")
    object LoginScreen: Screen("login")
    object AddProfileScreen: Screen("add_profile")
    object LocationScreen: Screen("location")
    object CategoryItem: Screen("category_item")
    object CategoryScreen: Screen("category_screen")
    object ShoppingCard: Screen("shopping_card")
    object CancelOrder: Screen("cancel_order")
    object AddressScreen: Screen("address_screen")
    object FavoriteRestaurants: Screen("favorite_restaurant")
    object NotificationsScreen: Screen("notification_screen")
    object PayementMethodsProfile: Screen("payement_profile")
    object SecurityScreen: Screen("security_screen")
    object UpdateProfileScreen: Screen("update_profile_screen")
    object AddMenu: Screen("add_menu")
    object CheckOutOrder: Screen("check_out_order")
    object DeliverTo: Screen("deliver_to")
    object PayementMethodsRestaurant: Screen("payement_restaurant")
    object RestaurantDetailScreen: Screen("restaurant_detail_screen")
    object RestaurantScreen: Screen("restaurant_screen")
    object SearchingDriver: Screen("searching_driver")
    object TransactionHistoryScreen: Screen("transaction_history")
}
