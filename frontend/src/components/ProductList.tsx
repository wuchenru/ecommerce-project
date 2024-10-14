// src/components/ProductList.tsx
import React, { useEffect, useState } from 'react';
import { fetchProducts } from '../api/productApi';

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
        console.log(products)
        
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
      <ul>
        {products.map(product => (
          <li key={product.id}>
            {product.name} - ${product.price} - {product.description}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ProductList;
