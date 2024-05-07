import { Button, IconButton } from "@mui/material";
import RemoveCircleOutlineIcon from '@mui/icons-material/RemoveCircleOutline';
import React from "react";
import ControlPointIcon from '@mui/icons-material/ControlPoint';

const CartItems = () => {
  return (
    <div className="p-5 shadow-lg border rounded-md ">
      <div className="flex items-center">
        <div className="w-[7rem] h-[10rem] lg:w-[9rem] lg:h-9[rem] ">
          <img
            className="w-full h-full object-cover object-top"
            src="https://tailwindui.com/img/ecommerce-images/product-page-02-secondary-product-shot.jpg"
            alt="image"
          />
        </div>
        <div className="ml-5 space-y-1">
          <p className="font-semibold ">Men slim mid rise black jeans</p>
          <p className="opacity-70"> Size: L , White</p>
          <p className="opacity-70 mt-2"> Seller : Crishtaliyo 2 fashion </p>

          <div className="flex space-x-5 items-center  text-gray-900 pt-6">
            <p className="font-semibold">₹199</p>
            <p className="opacity-50 line-through">₹1999</p>
            <p className=" text-green-600">70% off</p>
          </div>
        </div>

      </div>
      <div className="lg:flex items-center lg:space-x-10 pt-4">
          <div className="flex items-center space-x-2">

            <IconButton  sx={{color:'RGB(145 85 253)'}} className="">
              <RemoveCircleOutlineIcon  />
            </IconButton>

            <span className="py-1 px-7 border rounded-sm">3</span>

            <IconButton sx={{color:'RGB(145 85 253)'}} className="">
              <ControlPointIcon />
            </IconButton>
        
          </div>
          <div>
            <Button  sx={{color:'RGB(145 85 253)'}}>remove</Button>
          </div> 
        </div>
    </div>
  );
};

export default CartItems;
