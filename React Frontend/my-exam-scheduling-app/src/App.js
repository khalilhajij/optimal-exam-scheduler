import React from 'react';
import { BrowserRouter as Router, Routes, Route, useLocation } from 'react-router-dom';
import Login from './components/Login';
import Generate from './components/Generate';
import SchedulePage from './components/SchedulePage';
import CoursesPage from './components/CoursesPage';
import TeachersPage from './components/TeachersPage';
import SettingsPage from './components/SettingsPage'; 
import HelpPage from './components/HelpPage';
import useDarkMode from './hooks/useDarkMode';

function App() {
    useDarkMode();
    return (
        <Router>
            <AppRoutes />
        </Router>
    );
}

function AppRoutes() {
    const location = useLocation();
    const isLoginPage = location.pathname === '/login' || location.pathname === '/';

    React.useEffect(() => {
        if (isLoginPage) {
            document.documentElement.classList.remove('dark');
        } else {
            const darkMode = localStorage.getItem('darkMode') === 'true';
            if (darkMode) {
                document.documentElement.classList.add('dark');
            } else {
                document.documentElement.classList.remove('dark');
            }
        }
    }, [isLoginPage]);

    return (
        <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/generate" element={<Generate />} />
            <Route path="/login" element={<Login />} />
            <Route path="/schedule" element={<SchedulePage />} />
            <Route path="/courses" element={<CoursesPage />} />
            <Route path="/teachers" element={<TeachersPage />} />
            <Route path="/settings" element={<SettingsPage />} /> 
            <Route path="/help" element={<HelpPage />} />
        </Routes>
    );
}

export default App;