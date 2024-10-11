import React from 'react'
import {UserContext } from './contexts/UserContext'
import LoginForm from './components/LoginForm'
import UserDashboard from './components/UserDashboard'
import AdminDashboar from './components/AdminDashboard'
import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const {user} = React.useContext(UserContext);

  return (
    <div className = "container mx-auto p-4">
      <h1 className="text-2x1 font-bold mb-4"> Library Management System</h1>
      {user ? (
        user.role === 'ADMIN' ? <AdminDashboard /> : <UserDashboard />
      ) : (
      <LoginForm />
      )
    }
    </div>
  );
};

export default App
