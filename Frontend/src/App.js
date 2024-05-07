import "./App.css";
import {
  BrowserRouter as Router,
  Route,
  Routes,
  BrowserRouter,
} from "react-router-dom";
import ProductCard from "./Customer/Components/product/ProductCard.jsx";
import Product from "./Customer/Components/product/Product.jsx";
import React from "react";
import Homepage from "./Customer/pages/Homepage/Homepage.jsx";
import Navbar from "./Customer/Components/Navbar/Navbar.jsx";
import CartSection from "./Customer/Components/Cart/CartSection.jsx";
import ProductDetails from "./Customer/Components/ProductDetails/ProductDetails.jsx";
import Checkout from "./Customer/Components/Checkout/Checkout.jsx";
import OrderDetails from "./Customer/Components/Order/OrderDetails.jsx";
import OrderPage from "./Customer/Components/Order/OrderPage.jsx";
import CustomersRoutes from "./Routers/CustomersRoutes.jsx";
import {Provider} from 'react-redux'
import { store } from "./State/Store.jsx";

function App() {

  return (

    <React.StrictMode>
       <Provider store={store}>
        <CustomersRoutes />
    </Provider>,

  </React.StrictMode>

  );
}

export default App;


