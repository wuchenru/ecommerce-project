// src/App.tsx
import React from 'react';
import './App.css';
import ProductList from './ProductList';

const App: React.FC = () => {
  return (
    <div>
      <header>
        <h1>Welcome to the E-commerce Platform</h1>
      </header>
      <main>
        <ProductList />
      </main>
    </div>
  );
};

export default App;
