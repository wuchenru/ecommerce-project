// src/App.tsx
import React from 'react';

import ProductList from '../components/ProductList';

const Home: React.FC = () => {
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

export default Home;
