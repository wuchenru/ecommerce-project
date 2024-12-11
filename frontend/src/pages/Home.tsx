import React from 'react';
import './Home.css'; // Import styles specific to the Home page
import ProductList from '../components/ProductList'; // Product list remains as it is

const Home: React.FC = () => {
  return (
    <div className="home-container">
      <header className="home-header">
        <h1 className="home-title">Welcome to the E-commerce Platform</h1>
      </header>
      <main className="home-main">
        <ProductList />
      </main>
    </div>
  );
};

export default Home;
