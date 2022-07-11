import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import { JwtContextProvider } from './context/JwtContext';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <JwtContextProvider>
    <App />
    </JwtContextProvider>
  </React.StrictMode>
);

