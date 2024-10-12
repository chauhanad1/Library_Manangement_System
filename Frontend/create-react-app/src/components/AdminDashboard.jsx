import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Card, CardHeader, CardContent } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "@/components/ui/table";
 
const AdminDashboard = () => {
  const [books, setBooks] = useState([]);
  const [newBook, setNewBook] = useState({
    title: '',
    author: '',
    publisher: '',
    published_year: '',
    category: '',
    total_copies: ''
  });
  
  useEffect(() => {
    fetchBooks();
  }, []);

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
  
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewBook(prev => ({
      ...prev,
      [name]: value
    }));
  };
  
  const addBook = async (e) => {
    e.preventDefault();
    try {
await axios.post(baseurl+'books/add', {
        ...newBook,
        published_year: parseInt(newBook.published_year),
        total_copies: parseInt(newBook.total_copies),
        available_copies: parseInt(newBook.total_copies)
      });
      fetchBooks();
      setNewBook({
        title: '',
        author: '',
        publisher: '',
        published_year: '',
        category: '',
        total_copies: ''
      });
    } catch (error) {
      console.error('Error adding book:', error);
    }
  };
  
  return (
    <div className="space-y-6">
      <AddBookForm newBook={newBook} onInputChange={handleInputChange} onSubmit={addBook} />
      <BookInventory books={books} />
    </div>
  );
};
 
const AddBookForm = ({ newBook, onInputChange, onSubmit }) => (
  <Card>
    <CardHeader>Add New Book</CardHeader>
    <CardContent>
      <form onSubmit={onSubmit} className="space-y-4">
        <Input
          name="title"
          placeholder="Title"
          value={newBook.title}
          onChange={onInputChange}
        />
        <Input
          name="author"
          placeholder="Author"
          value={newBook.author}
          onChange={onInputChange}
        />
        <Input
          name="publisher"
          placeholder="Publisher"
          value={newBook.publisher}
          onChange={onInputChange}
        />
        <Input
          name="published_year"
          type="number"
          placeholder="Published Year"
          value={newBook.published_year}
          onChange={onInputChange}
        />
        <Input
          name="category"
          placeholder="Category"
          value={newBook.category}
          onChange={onInputChange}
        />
        <Input
          name="total_copies"
          type="number"
          placeholder="Total Copies"
          value={newBook.total_copies}
          onChange={onInputChange}
        />
        <Button type="submit">Add Book</Button>
      </form>
    </CardContent>
  </Card>
);
 
const BookInventory = ({ books }) => (
  <Card>
    <CardHeader>Manage Books</CardHeader>
    <CardContent>
      <Table>
        <TableHeader>
          <TableRow>
            <TableHead>Title</TableHead>
            <TableHead>Author</TableHead>
            <TableHead>Total Copies</TableHead>
            <TableHead>Available Copies</TableHead>
          </TableRow>
        </TableHeader>
        <TableBody>
          {books.map(book => (
            <TableRow key={book.book_id}>
              <TableCell>{book.title}</TableCell>
              <TableCell>{book.author}</TableCell>
              <TableCell>{book.total_copies}</TableCell>
              <TableCell>{book.available_copies}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </CardContent>
  </Card>
);
 
export default AdminDashboard;
