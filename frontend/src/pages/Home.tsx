import React from 'react';
import './Home.css'; // Styles specific to the Home page
import ProductList from '../components/ProductList'; // Product list remains the same

const Home: React.FC = () => {
  return (
    <div className="home">
      <header className="home__header">
        <h1 className="home__title">Welcome to the E-commerce Platform</h1>
      </header>
      <main className="home__main" aria-label="Home Page Main Content">
        <section className="home__products">
          <ProductList />
        </section>
      </main>
    </div>
  );
};

export default Home;
