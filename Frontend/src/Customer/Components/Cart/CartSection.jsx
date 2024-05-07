import React from "react";
import CartItems from "./CartItems";
import { Button } from "@mui/material";
import AddressPage from "../Checkout/Checkout";
import { useNavigate } from "react-router";

const CartSection = () => {
  const navigate=useNavigate()
  const handleCheckOut=()=>{
    navigate('/checkout?step=2')
  }
  return (
    <div>
      <div className="lg:grid grid-cols-3 lg:px-16 relative">
        <div className="col-span-2">
        {[1,1,1,1,1].map((item)=><CartItems />)}
        </div>
        <div className="px-5 sticky top-0 h-[100vh] mt-5 lg:mt-0">
          <div className="border">
            <p className="uppercase font-bold opacity-60 pb-4 ">Price Details</p>
            <hr />
            <div className="space-y-3 font-semibold mb-10">
                <div className="flex justify-between pt-3 text-black pl-5">
                    <span>Price</span>
                    <span className=" pr-5">₹4199</span>
                </div>
                <div className="flex justify-between pt-3 text-black  pl-5">
                    <span>Discount</span>
                    <span className=" text-green-600 pr-5">₹2990</span>
                </div>
                <div className="flex justify-between pt-3 text-black  pl-5">
                    <span>Delivery Charge</span>
                    <span className=" text-green-600  pr-5">Free</span>
                </div>
                <div className="flex justify-between pt-3 text-black  pl-5 pb-8">
                    <span>Total Amount</span>
                    <span className=" text-green-600  pr-5">₹1290</span>
                </div>
            </div>
            <Button
                  variant="contained"
                  onClick={handleCheckOut}
                  className="w-full mt-5"
                  sx={{ px: "2.5rem", py: ".7rem", bgcolor: "#9155fd" }}
                >
                  Checkout
                </Button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CartSection;
