import React from 'react'
import { UserProvider, useUser } from './contexts/UserContext'
import LoginForm from './components/LoginForm'
import UserDashboard from './components/UserDashboard'
import AdminDashboard from './components/AdminDashboard'
import './App.css'
 
function AppContent() {
  const { user } = useUser();
  
  return (
    <div className="container mx-auto p-4">
      <h1 className="text-2xl font-bold mb-4">Library Management System</h1>
      {user ? (
        user.role === 'ADMIN' ? <AdminDashboard /> : <UserDashboard />
      ) : (
        <LoginForm />
      )}
    </div>
  );
}
 
function App() {
  return (
    <UserProvider>
      <AppContent />
    </UserProvider>
  );
}
 
export default App