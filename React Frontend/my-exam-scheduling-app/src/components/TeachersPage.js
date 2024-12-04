import React from 'react';
import { useNavigate } from 'react-router-dom';
import { useState } from 'react';
import Sidebar from './Sidebar';
import '../styles/styles.css';

const TeacherCard = ({ teacher }) => {
    return (
        <div className="bg-white rounded-lg shadow p-4 text-center m-4">
            <img src={teacher.profilePicture} alt={`${teacher.name}'s profile`} className="w-24 h-24 rounded-full mx-auto mb-4" />
            <div className="font-bold">{teacher.name}</div>
            <div className="text-sm text-gray-600">{teacher.email}</div>
            <div className="text-sm text-blue-500 mt-2">{teacher.subjects.join(", ")}</div>
        </div>
    );
};

const TeachersPage = () => {
    const navigate = useNavigate();

    const handleLogout = () => {
        // Add any logout logic here, such as clearing user data
        navigate('/login');  // Assuming '/login' is your login route
    };
    
    const [teachers] = useState([
        { name: "Josh Homme", email: "jhomme@psu.edu.sa", subjects: ["Science", "Chemistry 101"], profilePicture: "/Screenshot 2024-11-28 213317.png" },
        { name: "Jeanette Horse", email: "jhorse@psu.edu.sa", subjects: ["Art", "History 101"], profilePicture: "/Screenshot 2024-11-28 212937.png" },
        // Add more teacher data here
    ]);

    return (
        <div className="flex h-auto min-h-screen bg-gray-200">
            <Sidebar handleLogout={handleLogout} />
            <main className="flex-1 p-8">
                <h1 className="text-3xl font-bold text-[#3272d9] mb-8">Teachers</h1>
                <div className="flex mb-8">
                    <button className="bg-white text-black py-2 px-4 rounded-full mr-2">All Teachers</button>
                    <button className="bg-gray-200 text-black py-2 px-4 rounded-full mr-2">CCIS</button>
                    <button className="bg-gray-200 text-black py-2 px-4 rounded-full mr-2">CE</button>
                    <button className="bg-gray-200 text-black py-2 px-4 rounded-full mr-2">CL</button>
                </div>
                <div className="grid grid-cols-3 gap-8">
                    {teachers.map((teacher, index) => (
                        <TeacherCard key={index} teacher={teacher} />
                    ))}
                </div>
            </main>
        </div>
    );
};

export default TeachersPage;