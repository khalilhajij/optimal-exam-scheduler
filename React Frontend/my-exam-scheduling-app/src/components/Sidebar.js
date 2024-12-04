// src/components/Sidebar.js
import React from 'react';
import { NavLink } from 'react-router-dom';
import '../styles/Sidebar.css';
import '../styles/styles.css';

const Sidebar = ({ handleLogout }) => {
  return (
    <aside id='sidebar' className="w-64 bg-gradient-to-b from-blue-400 to-blue-800 text-white p-4 flex flex-col h-screen justify-between shadow-lg">
      <div>
        <div className="profile-div flex flex-col items-center mb-8 bg-[#5a91e8] rounded-lg p-4 transition-custom transform hover:scale-105">
          <img src="/Prince_Sultan_University_coat_of_arms.png" alt="Profile" className="w-20 h-12 rounded-full mr-3 mb-3 mt-3 ml-0" />
          <div>
            <div className="font-bold text-lg">Ibrahim Baninaser</div>
            <div className="text-sm text-gray-200">221110468@psu.edu.sa</div>
          </div>
        </div>
        <nav className="flex-grow">
          <ul>
            <li className="mb-4">
              <NavLink to="/schedule" className={({ isActive }) =>
                "flex items-center text-white p-2 " +
                (isActive ? "bg-[#3272d9]" : "hover:bg-[#3272d9]") +
                " transition-colors duration-150 ease-in-out rounded-lg transform hover:scale-105 transition-custom"}
              >
                <i className="fas fa-calendar-alt mr-3 w-6"></i> Schedule
              </NavLink>
            </li>
            <li className="mb-4">
              <NavLink to="/courses" className={({ isActive }) =>
                "flex items-center text-white p-2 " +
                (isActive ? "bg-[#3272d9]" : "hover:bg-[#3272d9]") +
                " transition-colors duration-150 ease-in-out rounded-lg transform hover:scale-105 transition-custom"}
              >
                <i className="fas fa-book mr-3 w-6"></i> Courses
              </NavLink>
            </li>
            <li className="mb-4">
              <NavLink to="/teachers" className={({ isActive }) =>
                "flex items-center text-white p-2 " +
                (isActive ? "bg-[#3272d9]" : "hover:bg-[#3272d9]") +
                " transition-colors duration-150 ease-in-out rounded-lg transform hover:scale-105 transition-custom"}
              >
                <i className="fas fa-chalkboard-teacher mr-3 w-6"></i> Teachers
              </NavLink>
            </li>
            <li className="mb-4">
              <NavLink to="/settings" className={({ isActive }) =>
                "flex items-center text-white p-2 " +
                (isActive ? "bg-[#3272d9]" : "hover:bg-[#3272d9]") +
                " transition-colors duration-150 ease-in-out rounded-lg transform hover:scale-105 transition-custom"}
              >
                <i className="fas fa-cog mr-3 w-6"></i> Settings
              </NavLink>
            </li>
            <li className="mb-4">
              <NavLink to="/help" className={({ isActive }) =>
                "flex items-center text-white p-2 " +
                (isActive ? "bg-[#3272d9]" : "hover:bg-[#3272d9]") +
                " transition-colors duration-150 ease-in-out rounded-lg transform hover:scale-105 transition-custom"}
              >
                <i className="fas fa-question-circle mr-3 w-6"></i> Help
              </NavLink>
            </li>
          </ul>
        </nav>
      </div>
      <div id="logout-button" className="fixed bottom-5">
      <NavLink to="/login" className={({ isActive }) =>
                "flex items-center text-white p-2 " +
                (isActive ? "bg-[#3272d9]" : "hover:bg-[#3272d9]") +
                " transition-colors duration-150 ease-in-out rounded-lg transform hover:scale-105 transition-custom"}
              >
                <i className="fas fa-sign-out-alt mr-3 w-6"></i> Log Out
              </NavLink>
      </div>
    </aside>
  );
};

export default Sidebar;