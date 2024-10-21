// // src/components/SignUp.tsx
// import React, { useState } from 'react';
// import axios from 'axios';

// const SignUp: React.FC = () => {
//   const [name, setName] = useState('');
//   const [email, setEmail] = useState('');
//   const [password, setPassword] = useState('');
//   const [errorMessage, setErrorMessage] = useState('');
//   const [successMessage, setSuccessMessage] = useState('');

//   const handleSignUp = async (e: React.FormEvent) => {
//     e.preventDefault();
//     setErrorMessage(''); // Reset error message
//     setSuccessMessage(''); // Reset success message

//     try {
//       const response = await axios.post('http://localhost:8080/users/addUser', {
//         name,
//         email,
//         password
//       }, {
//         headers: {
//           'Content-Type': 'application/json'
//         }
//       });

//       setSuccessMessage(response.data); // Show success message
//       // Reset fields after successful signup
//       setName('');
//       setEmail('');
//       setPassword('');
//     } catch (error: any) {
//       console.error('Error signing up:', error);
//       setErrorMessage(error.response?.data || 'Registration failed');
//     }
//   }

//   return (
//     <form onSubmit={handleSignUp}>
//       <h2>Sign Up</h2>
//       {errorMessage && <div style={{ color: 'red' }}>{errorMessage}</div>}
//       {successMessage && <div style={{ color: 'green' }}>{successMessage}</div>}
//       <div>
//         <label>Name:</label>
//         <input 
//           type="text" 
//           value={name} 
//           onChange={(e) => setName(e.target.value)} 
//           required 
//         />
//       </div>
//       <div>
//         <label>Email:</label>
//         <input 
//           type="email" 
//           value={email} 
//           onChange={(e) => setEmail(e.target.value)} 
//           required 
//         />
//       </div>
//       <div>
//         <label>Password:</label>
//         <input 
//           type="password" 
//           value={password} 
//           onChange={(e) => setPassword(e.target.value)} 
//           required 
//         />
//       </div>
//       <button type="submit">Sign Up</button>
//     </form>
//   );
// }

// export default SignUp;


// src/components/SignUp.tsx
import React, { useState } from 'react';
import axios from 'axios';

const SignUp: React.FC = () => {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [errorMessage, setErrorMessage] = useState('');
  const [successMessage, setSuccessMessage] = useState('');

  const handleSignUp = async (e: React.FormEvent) => {
    e.preventDefault();
    setErrorMessage(''); // Reset error message
    setSuccessMessage(''); // Reset success message

    try {
      const response = await axios.post('http://localhost:8080/api/auth/register', {
        name,
        email,
        password
      }, {
        headers: {
          'Content-Type': 'application/json'
        }
      });

      // Assuming the backend returns a success message upon successful registration
      setSuccessMessage(response.data); // Show success message
      // Reset fields after successful signup
      setName('');
      setEmail('');
      setPassword('');
    } catch (error: any) {
      console.error('Error signing up:', error);
      // Check for a specific error message from the response
      setErrorMessage(error.response?.data || 'Registration failed');
    }
  }

  return (
    <form onSubmit={handleSignUp}>
      <h2>Sign Up</h2>
      {errorMessage && <div style={{ color: 'red' }}>{errorMessage}</div>}
      {successMessage && <div style={{ color: 'green' }}>{successMessage}</div>}
      <div>
        <label>Name:</label>
        <input 
          type="text" 
          value={name} 
          onChange={(e) => setName(e.target.value)} 
          required 
        />
      </div>
      <div>
        <label>Email:</label>
        <input 
          type="email" 
          value={email} 
          onChange={(e) => setEmail(e.target.value)} 
          required 
        />
      </div>
      <div>
        <label>Password:</label>
        <input 
          type="password" 
          value={password} 
          onChange={(e) => setPassword(e.target.value)} 
          required 
        />
      </div>
      <button type="submit">Sign Up</button>
    </form>
  );
}

export default SignUp;
