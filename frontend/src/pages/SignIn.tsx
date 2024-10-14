// src/components/SignIn.tsx
import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const SignIn: React.FC = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleSignIn = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/users/login', {
        email,
        password
      }, {
        headers: {
          'Content-Type': 'application/json'
        }
      });
      alert(response.data); // "Login successful!" or "Invalid credentials!"
      if (response.data === "Login successful!") {
        navigate('/home');
      }
    } catch (error: any) {
      console.error('Error signing in:', error);
      alert(error.response?.data || 'Login failed');
    }
  }

  return (
    <form onSubmit={handleSignIn}>
      <h2>Sign In</h2>
      <div>
        <label>Email:</label>
        <input 
          type="email" 
          value={email} 
          onChange={(e) => setEmail(e.target.value)} 
          required 
        />
      </div>
      <div>
        <label>Password:</label>
        <input 
          type="password" 
          value={password} 
          onChange={(e) => setPassword(e.target.value)} 
          required 
        />
      </div>
      <button type="submit">Sign In</button>
    </form>
  );
}

export default SignIn;
