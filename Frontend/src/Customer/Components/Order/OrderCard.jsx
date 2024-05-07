import { Grid } from "@mui/material";
import React from "react";
import AdjustIcon from "@mui/icons-material/Adjust";
import { useNavigate } from "react-router";
const OrderCard = () => {
  const navigate=useNavigate()
  return (
    <div onClick={()=>navigate(`/account/order/${5}`)} className="mt-9 ml-9 mb-4 h-[20vh] shadow-lg hover:shadow-2xl border">
      <div
        className="flex h-auto p-6 "
        clacontainer
        sx={{ justifyContent: "space-between" }}
      >
        <div className="flex cursor-pointer">
          <img
            className="w-[5rem] h-[5rem] "
            src="https://tailwindui.com/img/ecommerce-images/product-page-02-secondary-product-shot.jpg"
            alt="img"
          />
          <div className="space-y-2 ml-5  w-[30rem] ">
            <p className=" w-[25rem]">Men slim Mid Rise Black Jeans</p>
            <p className="opacity-50 text-xs font-semibold">Size :M</p>
            <p className="opacity-50 text-xs font-semibold">Color : Black</p>
          </div>
        </div>

        <div className="h-auto w-[15rem]">
          <p>₹1290</p>
        </div>

        <div>
          {true && <div>
            <p>
              <span>
                <AdjustIcon className="text-green-600  text-sm" /> Delivered on
                march 04/03/2024
              </span>
            </p>
            <p className="text-xs">
              <span>Your item was Delivered</span>

            </p>
            </div>}
          {false && (
            <p>
              <span>
                <AdjustIcon className="text-green-600  text-sm" /> Ecpected
                Delivered on march 04/03/2024
              </span>
            </p>
          )}
        </div>
      </div>
    </div>
  );
};

export default OrderCard;
