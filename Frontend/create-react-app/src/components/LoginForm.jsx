import React, { useState } from 'react';
import { useUser } from '../contexts/UserContext';
import { Card, CardHeader, CardContent } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
 
const LoginForm = () => {
  const { login } = useUser();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  
  const handleLogin = async (e) => {
    e.preventDefault();
    // In a real app, you'd make an API call here
    // For demo, we'll simulate login
    const mockUser = {
      id: 1,
      email,
      role: email.includes('admin') ? 'ADMIN' : 'USER'
    };
    login(mockUser);
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