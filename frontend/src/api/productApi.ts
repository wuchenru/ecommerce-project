// src/api/productApi.ts
import axios from 'axios';

const API_URL = 'http://localhost:8080/products';

export const fetchProducts = async () => {
  try {
    const response = await axios.get(`${API_URL}/all`);
    return response.data;
  } catch (error) {
    console.error('Error fetching products:', error);
    throw error;
  }
};
