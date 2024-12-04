// src/hooks/useDarkMode.js
import { useEffect } from 'react';

const useDarkMode = () => {
  useEffect(() => {
    const darkMode = localStorage.getItem('darkMode') === 'true';
    if (darkMode) {
      document.documentElement.classList.add('dark');
    } else {
      document.documentElement.classList.remove('dark');
    }
  }, []);
};

export default useDarkMode;