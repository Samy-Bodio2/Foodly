package com.example.foodly.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.foodly.Administrateur.AddMenuAdmin
import com.example.foodly.Administrateur.DashBoard
import com.example.foodly.Administrateur.HomeScreenAdministrateur
import com.example.foodly.Restaurant.Consult_Menu
import com.example.foodly.Restaurant.HomeScreenResto
import com.example.foodly.Restaurant.PageManagement
import com.example.foodly.screens.AccountSetup.AddProfileScreen
import com.example.foodly.screens.Chat.ChatScreen
import com.example.foodly.screens.Home_ActionMenu.*
import com.example.foodly.screens.Onboarding_SignUp_SignIn.*
import com.example.foodly.screens.Orders.CancelOrder
import com.example.foodly.screens.Orders.CancelledOrders
import com.example.foodly.screens.Orders.OrderScreen
import com.example.foodly.screens.Profile.*
import com.example.foodly.screens.RestaurantDetail_Order.*
import com.example.foodly.screens.e_wallet.EWalletScreen
import com.example.foodly.screens.e_wallet.TransactionHistoryScreen
//import com.example.foodly.utils.DocumentDetails

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route){

        composable(route = Screen.Splash.route){
            AnimatedSplashScreen(navController)
        }
        composable(route = Screen.PageViewScreen.route){
            PageViewScreen(navController)
        }
        composable(route = Screen.Lets_You_In.route){
            Let_You_In(navController)
        }
        composable(route = Screen.LoginScreen.route){
            LoginScreen(navController)
        }
        composable(route = Screen.RegisterScreen.route){
            RegisterScreen(navController)
        }
        composable(route = Screen.ResetScreen.route){
            ResetScreen(navController)
        }
        composable(route = Screen.OtpVerifyScreen.route){
            OtpVerifyScreen(navController)
        }
        composable(route = Screen.AddProfileScreen.route){
            AddProfileScreen(navController)
        }
        composable(route = Screen.LocationScreen.route){
            //LocationScreen(navController)
        }
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(route = Screen.OrderScreen.route){
            OrderScreen(navController)
        }
        composable(route = Screen.CategoryItem.route){
            CategoryItem(navController)
        }
        composable(route = Screen.CategoryScreen.route){
            CategoryScreen(navController)
        }

        composable(route = Screen.EWalletScreen.route){
            EWalletScreen(navController)
        }
        composable(route = Screen.TransactionHistoryScreen.route){
            TransactionHistoryScreen(navController)
        }
        composable(route = Screen.ShoppingCard.route){
            ShoppingCard(navController)
        }

        composable(route = Screen.CancelOrder.route){
            CancelOrder(navController)
        }
        composable(route = Screen.RestaurantScreen.route){
            RestaurantScreen(navController)
        }
        composable(route = Screen.ProfileScreen.route){
            ProfileScreen(navController)
        }
        composable(route = Screen.FavoriteRestaurants.route){
            FavoriteRestaurants(navController)
        }
        composable(route = Screen.NotificationsScreen.route){
            NotificationsScreen(navController)
        }
        composable(route = Screen.PayementMethodsProfile.route){
            PayementMethodsProfile(navController)
        }
        composable(route = Screen.SecurityScreen.route){
            SecurityScreen(navController)
        }
        composable(route = Screen.UpdateProfileScreen.route){
            UpdateProfileScreen(navController)
        }
        composable(route = Screen.AddressScreen.route){
            AdresseScreen(navController)
        }
        composable(route = Screen.AddMenu.route){
            AddMenu(navController)
        }
        composable(route = Screen.RestaurantScreen.route){
            RestaurantScreen(navController)
        }
        composable(route = Screen.CheckOutOrder.route){
            CheckOutOrders(navController)
        }
        composable(route = Screen.DeliverTo.route){
            DeliverTo(navController)
        }
        composable(route = Screen.RestaurantScreen.route){
            RestaurantScreen(navController)
        }
        composable(route = Screen.RestaurantDetailScreen.route){
            RestaurantDetailScreen(navController)
        }
        composable(
            route = "details/{id}",
            arguments = listOf(navArgument("id"){
                    type = NavType.StringType
                }
            )
        ){
           // DocumentDetails(navController)
        }
        composable(route = Screen.DocumentList.route){
            DocumentList(navController)
        }
        composable(route = Screen.CancelOrder.route){
            CancelOrder(navController)
        }
        composable(route = "menu"){
            MenuList1()
        }
        composable(route = Screen.HomeScreenAdministrateur.route){
            HomeScreenAdministrateur(navController)
        }
        composable(route = Screen.HomeScreenResto.route){
            HomeScreenResto(navController)
        }
        composable(route = Screen.Consult_Menu.route){
            Consult_Menu(navController)
        }
        composable(route = Screen.PageManagement.route){
            PageManagement(navController)
        }
        composable(route = Screen.ChatScreen.route){
            ChatScreen(navController)
        }
        composable(route = Screen.DashBoard.route){
            DashBoard(navController)
        }
        composable(route = Screen.AddMenuAdmin.route){
            AddMenuAdmin(navController)
        }
    }
}