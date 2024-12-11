import React from 'react';
import './styles/Home.css'; // Import the new Home page CSS

const ProductList: React.FC = () => {
  // Example product list
  const products = [
    { id: 1, name: 'Product 1', description: 'This is Product 1' },
    { id: 2, name: 'Product 2', description: 'This is Product 2' },
    { id: 3, name: 'Product 3', description: 'This is Product 3' },
  ];

  return (
    <div className="product-list-container">
      {products.map((product) => (
        <div key={product.id} className="product-card">
          <h2>{product.name}</h2>
          <p>{product.description}</p>
          <button>Buy Now</button>
        </div>
      ))}
    </div>
  );
};

const Home: React.FC = () => {
  return (
    <div>
      <header className="home-header">
        <h1>Welcome to the E-commerce Platform</h1>
      </header>
      <main className="home-main">
        <ProductList />
      </main>
    </div>
  );
};

export default Home;
