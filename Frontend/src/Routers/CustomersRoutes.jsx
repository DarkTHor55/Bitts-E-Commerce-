import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Homepage from "../Customer/pages/Homepage/Homepage";
import CartSection from "../Customer/Components/Cart/CartSection";
import Navbar from "../Customer/Components/Navbar/Navbar";
import Footer from "../Customer/Components/Footer/Footer";
import ProductDetails from "../Customer/Components/ProductDetails/ProductDetails";
import Product from "../Customer/Components/product/Product";
import OrderDetails from "../Customer/Components/Order/OrderDetails";
import Checkout from "../Customer/Components/Checkout/Checkout";
import OrderPage from "../Customer/Components/Order/OrderPage";
import Signup from "../Auth/Signup";
import Login from "../Auth/Login";

const CustomersRoutes = () => {
  const isAuthenticated = true; 
  return (
    <div>
      <Router>
        <Navbar isAuthenticated={isAuthenticated} />
        <Routes>
          <Route path="/login" element={<Login/>} />
          <Route path="/signup" element={<Signup/>} />
          <Route path="/" element={<Homepage />} />
          <Route path="/home" element={<Homepage />} />
          <Route path="/cart" element={<CartSection />} />
          <Route path="/:levelOne/:levelTwo/:levelThree" element={<Product />} />
          <Route path="/product/:productId" element={<ProductDetails />} />
          <Route path="/checkout" element={<Checkout />} />
          <Route path="/account/order" element={<OrderPage />} />
          <Route path="/account/order/:orderId" element={<OrderDetails />} />
        </Routes>
      </Router>
    </div>
  );
};

export default CustomersRoutes;
