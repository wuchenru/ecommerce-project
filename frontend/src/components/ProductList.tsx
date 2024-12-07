import React, { useEffect, useState } from 'react';
import { fetchProducts } from '../api/productApi';
import styles from './ProductList.module.css'; // Import CSS module

interface Product {
  id: number;
  name: string;
  price: number;
  description: string;
  // Add other product fields as necessary
}

const ProductList: React.FC = () => {
  const [products, setProducts] = useState<Product[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const getProducts = async () => {
      try {
        const products = await fetchProducts();
        console.log(products);
        setProducts(products);
      } catch (error) {
        setError('Failed to fetch products');
      } finally {
        setLoading(false);
      }
    };

    getProducts();
  }, []);

  if (loading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>Error: {error}</div>;
  }

  return (
    <div>
      <h1>Products</h1>
      <div className={styles.container}>
        {products.map(product => (
          <div key={product.id} className={styles.item}>
            <h2>{product.name}</h2>
            <p>${product.price}</p>
            <p>{product.description}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default ProductList;
