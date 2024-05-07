import React from 'react'
import AddressCard from './addressCard/AddressCard'
import CartItems from '../Cart/CartItems'
import { Button } from '@mui/material'

const OrderSummery = () => {
  return (
    <div>
      <div className='p-5 shadow-lg rounded-s-md border'>
        <AddressCard/>

      </div>
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
                //   onClick={<AddressPage/>}
                  className="w-full mt-5"
                  sx={{ px: "2.5rem", py: ".7rem", bgcolor: "#9155fd" }}
                >
                  Checkout
                </Button>
          </div>
        </div>
      </div>
    </div>
    </div>
  )
}

export default OrderSummery
