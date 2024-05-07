import React from "react";
import AddressCard from "../Checkout/addressCard/AddressCard";
import OrderTraker from "./OrderTraker";
import OrderCard from "./OrderCard";
import { Box, colors } from "@mui/material";
import { deepPurple } from "@mui/material/colors";
import StarBorderIcon from "@mui/icons-material/StarBorder";
import { className } from "gridjs";

const OrderDetails = () => {
  return (
    <div className="px-5 lg:px-20">
      <div className="shadow-lg border mb-10">
        <div className="ml-20 mb-5">
          <h1 className="font-bold text-xl py-7">Delivery Address</h1>
          <AddressCard />
        </div>
      </div>
      <div className="py-10">
        <OrderTraker activeStep={0} />
      </div>
      <div className="space-x-5 ">
        {[1,1,1,1,1].map((item)=><div
          item
          className="shadow-xl rounded-md p-5 border flex relative mb-5 h-[20vh]"
        >
          <div className="flex items-center space-x-4">
            <img
              className="w-[5rem] h-[5rem] object-cover object-top"
              src="https://tailwindui.com/img/ecommerce-images/product-page-02-secondary-product-shot.jpg"
              alt=""
            />
            <div className="space-y-2 ml-5 w-[30rem]">
              <p className="w-[25rem]">Men slim Mid Rise Black Jeans</p>
              <p className="opacity-50 text-xs font-semibold ">
                <span>Size : M</span> <br /> <span>Color : Black</span>
              </p>
              <p className="opacity-50 text-xs font-semibold">
                Seller : linaria
              </p>
              <p className="opacity-50 text-xs font-bold">₹1290</p>
            </div>
          </div>
          <div className="absolute  right-2">
       
            <p style={{ color: "black",right:0 }}><StarBorderIcon
              
              sx={{ fontSize: "3rem" , color: deepPurple[500]}}
              className="px-2 text-5xl"
            />Rate And Review product</p>
          </div> 
        </div>)}
        
      </div>
    </div>
  );
};

export default OrderDetails;
