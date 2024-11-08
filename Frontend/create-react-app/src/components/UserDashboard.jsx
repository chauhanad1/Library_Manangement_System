import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useUser } from '../contexts/UserContext';
import { Card, CardHeader, CardContent } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "@/components/ui/table";
 
const UserDashboard = () => {

  // defining states
  const [books, setBooks] = useState([]);
  const [borrowedBooks, setBorrowedBooks] = useState([]);
  const [alertMessage, setAlertMessage] = useState(null);
  const { user } = useUser();
  

  
  // fetching apis when component will mount
  useEffect(() => {
    if(user){
    fetchBooks();
    fetchBorrowedBooks();
    }
  }, []);
  
  // actual fetching code
  const baseurl = 'http://localhost:8080/api/'
  const fetchBooks = async () => {
    try {
const response = await axios.get(baseurl+'books');
      if (Array.isArray(response.data)) {
        setBooks(response.data);
      } else {
        console.error('Fetched data is not an array:', response.data);
        setBooks([]);
      }
    } catch (error) {
      console.error('Error fetching books:', error);
      setBooks([]);
    }
  };
  
  const fetchBorrowedBooks = async () => {
    try {
const response = await axios.get(baseurl+`borrow/${user.user_id}`);
      if (Array.isArray(response.data)) {
        setBorrowedBooks(response.data);
      } else {
        console.error('Fetched borrowed books data is not an array:', response.data);
        setBorrowedBooks([]);
      }
    } catch (error) {
      console.error('Error fetching borrowed books:', error);
      setBorrowedBooks([]);
    }
  };

  
  const borrowBook = async (bookId) => {
    const book = books.find(b => b.book_id === bookId);
    if(book.available_copies === 0){
      setAlertMessage('no Available copies to borrow');
      return;
    }
    try {
await axios.post(baseurl+`borrow/${bookId}/${user.user_id}`);
      setAlertMessage(null);
      fetchBooks();
      fetchBorrowedBooks();
    } catch (error) {
      if(error.response && error.response.status === 400){
        setAlertMessage('Maximum borrow limit reached.');
        alert('Maximum borrow limit reached.');
      }
      console.error('Error borrowing book:', error);
    }
  };
  
  const returnBook = async (copyId) => {
    try {
await axios.post(baseurl+`return/${copyId}/${user.user_id}`);
      fetchBooks();
      fetchBorrowedBooks();
    } catch (error) {
      console.error('Error returning book:', error);
    }
  };
  
  return (
    <div className="space-y-6">
      <AvailableBooks books={books} onBorrow={borrowBook} />
      <BorrowedBooks borrowedBooks={borrowedBooks} onReturn={returnBook} />
    </div>
  );
};
 
const AvailableBooks = ({ books, onBorrow }) => (
  <Card>
    <CardHeader>Available Books</CardHeader>
    <CardContent>
      <Table>
        <TableHeader>
          <TableRow>
            <TableHead>Title</TableHead>
            <TableHead>Author</TableHead>
            <TableHead>Available Copies</TableHead>
            <TableHead>Action</TableHead>
          </TableRow>
        </TableHeader>
        <TableBody>
          {books.map(book => (
            <TableRow key={book.book_id}>
              <TableCell>{book.title}</TableCell>
              <TableCell>{book.author}</TableCell>
              <TableCell>{book.available_copies}</TableCell>
              <TableCell>
                <Button
                  onClick={() => onBorrow(book.book_id)}
                  disabled={book.available_copies === 0}
                >
                  Borrow
                </Button>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </CardContent>
  </Card>
);
 
const BorrowedBooks = ({ borrowedBooks, onReturn }) => (
  <Card>
    <CardHeader>Borrowed Books</CardHeader>
    <CardContent>
      <Table>
        <TableHeader>
          <TableRow>
            <TableHead>Title</TableHead>
            <TableHead>Borrow Date</TableHead>
            <TableHead>Action</TableHead>
          </TableRow>
        </TableHeader>
        <TableBody>
          {borrowedBooks.map(borrowed => (
            <TableRow key={borrowed.borrow_id}>
              <TableCell>{borrowed.title}</TableCell>
              <TableCell>{new Date(borrowed.borrow_date).toLocaleDateString()}</TableCell>
              <TableCell>
                <Button onClick={() => onReturn(borrowed.copy_id)}>
                  Return
                </Button>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </CardContent>
  </Card>
);
 
export default UserDashboard;