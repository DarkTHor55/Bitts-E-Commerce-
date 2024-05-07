import { Button, Grid, TextField } from '@mui/material';
import React, { useState } from 'react'
import { useNavigate } from 'react-router';
import { API_BASE_URL } from '../Configruation/ApiConfig';


const Login = () => {
  const [email, setEmail] = useState("");
  const navigate = useNavigate()
  const [password, setPassword] = useState("");
  const handleLogin=async ()=>{
    try {
      const response = await fetch(`${API_BASE_URL}/auth/login`, {
        method: "POST",
        body: JSON.stringify({  email, password }),
        headers: {
          "Content-Type": "application/json" 
        },
      });
      const data = await response.json();
      localStorage.setItem("jwt", data.jwt);
      const token =localStorage.getItem("jwt")
      console.log(token); 
      navigate('/home')
    } catch (error) {
      console.error("Error signing up", error);
    }
  }
  const handleSignin=()=>{
    navigate('/signup')
  }

  
  return (
    <div className="max-w-md mx-auto mt-8 justify-center px-4">
      
    <h2 className="text-3xl font-semibold mb-4">Sign up</h2>
    <div className="space-y-4 text-center">
   
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
        onClick={handleLogin}
        className="text-center  bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
      >
        Login
      </button>
      <br/>
      <p>If you don't signin ? <button onClick={handleSignin}className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-1 px-3 rounded focus:outline-none focus:shadow-outline">
      Sign in</button></p>
     
    </div>
   
    
  </div>
  )
}

export default Login
