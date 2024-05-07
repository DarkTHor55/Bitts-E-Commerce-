import React, { useState } from "react";
import { useNavigate } from 'react-router-dom';
import { API_BASE_URL } from "../Configruation/ApiConfig";
import { Login } from "@mui/icons-material";

const Signup = () => {
  const navigate = useNavigate()
  const [firstName, setFirstName] = useState("");
  const [email, setEmail] = useState("");
  const [lastName, setLastName] = useState("");
  const [password, setPassword] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");
  const handleLogin=()=>{
    navigate('/')

  }
  

  const handleSignup = async () => {
    try {
      const response = await fetch(`${API_BASE_URL}/auth/signup`, {
        method: "POST",
        body: JSON.stringify({ firstName, email, lastName, password }),
        headers: {
          "Content-Type": "application/json",
        },
      });
      const data = await response.json();
      console.log(data);
      
      
    } catch (error) {
      console.error("Error signing up", error);
    }
  };

  return (
    <div className="max-w-md mx-auto mt-8 px-4">
      <h2 className="text-3xl font-semibold mb-4">Sign up</h2>
      <div className="space-y-4 text-center">
        <input
          type="text"
          placeholder="First Name"
          onChange={(e) => setFirstName(e.target.value)}
          value={firstName}
          className="block  w-full border border-gray-300 rounded px-4 py-2 focus:outline-none focus:border-blue-500"
          required
        />
        <input
          type="text"
          placeholder="Last Name"
          onChange={(e) => setLastName(e.target.value)}
          value={lastName}
          className="block w-full border border-gray-300 rounded px-4 py-2 focus:outline-none focus:border-blue-500"
          required
        />
         <input
          type="text"
          placeholder="Phone Number"
          onChange={(e) => setPhoneNumber(e.target.value)}
          value={phoneNumber}
          className="block w-full border border-gray-300 rounded px-4 py-2 focus:outline-none focus:border-blue-500"
          required
        />
        <input
          type="email"
          placeholder="Email"
          onChange={(e) => setEmail(e.target.value)}
          value={email}
          className="block w-full border border-gray-300 rounded px-4 py-2 focus:outline-none focus:border-blue-500"
          required
        />
        <input
          type="password"
          placeholder="Password"
          onChange={(e) => setPassword(e.target.value)}
          value={password}
          className="block w-full border border-gray-300 rounded px-4 py-2 focus:outline-none focus:border-blue-500"
          required
        />
        
        <button
          onClick={handleSignup}
          className="text-center  bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
        >
          Sign Up
        </button>
        <br/>
        <p>If you Already signin ? <button onClick={handleLogin}className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-1 px-3 rounded focus:outline-none focus:shadow-outline">
        Login</button></p>
       
      </div>
     
      
    </div>
  );
};

export default Signup;