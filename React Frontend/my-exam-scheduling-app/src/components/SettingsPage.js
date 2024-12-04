import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import Sidebar from './Sidebar';
import '../styles/styles.css';

const SettingsPage = () => {
    const navigate = useNavigate();

    const handleLogout = () => {
        navigate('/login');  // Assuming '/login' is your login route
    };

    const [settings, setSettings] = useState({
        notification: true,
        darkMode: false,
        language: 'English',
        solverTerminationLimit: '8s (Default Value)',
    });

    useEffect(() => {
        // Fetch dark mode preference from localStorage
        const darkMode = localStorage.getItem('darkMode') === 'true';
        setSettings(prevSettings => ({
            ...prevSettings,
            darkMode
        }));
        if (darkMode) {
            document.documentElement.classList.add('dark');
        } else {
            document.documentElement.classList.remove('dark');
        }
    }, []);

    const handleToggle = (setting) => {
        setSettings(prevSettings => ({
            ...prevSettings,
            [setting]: !prevSettings[setting]
        }));
        if (setting === 'darkMode') {
            const newDarkMode = !settings.darkMode;
            localStorage.setItem('darkMode', newDarkMode);
            if (newDarkMode) {
                document.documentElement.classList.add('dark');
            } else {
                document.documentElement.classList.remove('dark');
            }
        }
    };

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setSettings(prevSettings => ({
            ...prevSettings,
            [name]: value
        }));
    };

    const handleLanguageChange = (event) => {
        setSettings(prevSettings => ({
            ...prevSettings,
            language: event.target.value
        }));
    };

    return (
        <div className="flex h-auto min-h-screen">
            <Sidebar handleLogout={handleLogout} />
            <main className="flex-1 p-6 bg-gray-200">
                <header className="flex justify-between items-center mb-6 w-full">
                    <h1 className="text-3xl font-bold text-[#3272d9] mt-5 hidden md:block">Settings</h1>
                </header>

                <div className="bg-white rounded-lg shadow p-4">
                    <div className="mb-4">
                        <h2 className="text-xl font-bold">Preferences</h2>
                    </div>
                    <div className="mb-4">
                    <label className="custom-checkbox">
              <input
                type="checkbox"
                checked={settings.notification}
                onChange={() => handleToggle('notification')}
              />
              <span className="checkmark"></span>
              Enable Notifications
            </label>
          </div>
          <div className="mb-4">
            <label className="custom-checkbox">
              <input
                type="checkbox"
                checked={settings.darkMode}
                onChange={() => handleToggle('darkMode')}
              />
              <span className="checkmark"></span>
              Dark Mode
            </label>
                    </div>
                    <div className="mb-4">
                        <label className="block mb-2 ">Language</label>
                        <select
                            value={settings.language}
                            onChange={handleLanguageChange}
                            className="border border-gray-300 rounded-lg p-2 "
                        >
                            <option value="English">English</option>
                            <option value="Arabic">Arabic (To be implemented)</option>
                        </select>
                    </div>
                    <div className="mb-4">
                        <h2 className="text-xl font-bold ">Solver Settings</h2>
                    </div>
                    <div className="mb-4">
                        <label className="block mb-2 ">Solver Termination Limit (The more time you give the solver, the more precise it is)</label>
                        <input
                            type="text"
                            name="solverTerminationLimit"
                            value={settings.solverTerminationLimit}
                            onChange={handleInputChange}
                            className="border border-gray-300 rounded-lg p-2 w-full"
                        />
                    </div>
                </div>
            </main>
        </div>
    );
};

export default SettingsPage;