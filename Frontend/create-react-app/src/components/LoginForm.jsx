import React, { useState } from 'react';
import { useUser } from '../contexts/UserContext';
import { Card, CardHeader, CardContent } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
// import { useNavigate } from 'react-router-dom';
 
const LoginForm = () => {
  const { login } = useUser();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  // const navigate = useNavigate();
 
  const handleLogin = async (e) => {
    e.preventDefault();
 
    // Clear any previous error message
    setError('');
 
    try {
      // Make API request to backend
const response = await fetch('http://localhost:8080/api/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          email,
          password,
        }),
      });
 
      const data = await response.json();
 
      // Handle different response status
      if (response.ok) {
        // If login is successful, set the user context
        console.log(data);
        login(data); // Assuming `data` contains the user information from the backend
        
      } else {
        // If login fails, display appropriate error message
        setError(data.message || 'Login failed. Please try again.');
        alert(data.message || 'Login failed. Please check your credentials.');
      }
    } catch (error) {
      // Catch network or other errors
      setError('An error occurred. Please try again.');
    }
  };

  
  return (
    <Card className="max-w-md mx-auto">
      <CardHeader>Login</CardHeader>
      <CardContent>
        <form onSubmit={handleLogin} className="space-y-4">
          <Input
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <Input
            type="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <Button type="submit">Login</Button>
        </form>
      </CardContent>
    </Card>
  );
};
 
export default LoginForm;