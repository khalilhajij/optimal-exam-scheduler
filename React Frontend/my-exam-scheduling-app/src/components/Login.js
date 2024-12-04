import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import '../styles/Login.css';


const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [errorMessage, setErrorMessage] = useState('');
  const navigate = useNavigate();

  const handleLogin = (e) => {
    e.preventDefault();

    // Temporary login logic for example purposes
    if (email === 'admin@psu.edu.sa' && password === 'admin') {
      navigate('/schedule'); // Redirect to dashboard
    } else {
      setErrorMessage('Invalid credentials');
    }
  };

  return (
    <div className="container">
      <div className="background-image" />
      <div className="card">
        <div className="card-content">
          <div className="inner-image" />
          <h2 className="text-large">Log In</h2>
          <div className="text-small">
            Don’t have an account? <span style={{ textDecoration: 'underline', cursor: 'pointer'}}>Sign up</span>
          </div>
          <form onSubmit={handleLogin}>
            <div>
              <div className="text-gray">Your email</div>
              <input
                className={`input ${errorMessage ? 'border-red-500' : ''}`}
                placeholder=""
                type="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
            </div>
            <div>
              <div className="text-gray">Your password</div>
              <input
                className={`input ${errorMessage ? 'border-red-500' : ''}`}
                placeholder=""
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </div>
            {errorMessage && <div className="text-red-500 mt-2">{errorMessage}</div>}
            <div className="text-side" style={{ cursor: 'pointer' }}>
              Forget your password?
            </div>
            <button type="submit" style={{ cursor: 'pointer' }} className="button">
              Log In
            </button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Login;