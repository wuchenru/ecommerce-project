// // src/App.tsx
// import React from 'react';
// import './App.css';
// import ProductList from './components/ProductList';

// const App: React.FC = () => {
//   return (
//     <div>
//       <header>
//         <h1>Welcome to the E-commerce Platform</h1>
//       </header>
//       <main>
//         <ProductList />
//       </main>
//     </div>
//   );
// };

// export default App;
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import SignUp from './pages/SignUp';
import SignIn from './pages/SignIn';
import Home from './pages/Home';

const App: React.FC = () => {
  return (
    <Router>
      <Routes>
        <Route path="/signup" Component={SignUp} />
        <Route path="/signin" Component={SignIn} />
        <Route path="/home" Component={Home} />
        <Route path="/" Component={SignIn} />
      </Routes>
    </Router>
  );
}

export default App;
