import React from 'react';
import { useNavigate } from 'react-router-dom';
import Sidebar from './Sidebar';
import '../styles/styles.css';

const HelpPage = () => {
    const navigate = useNavigate();

    const handleLogout = () => {
        navigate('/login');  // Assuming '/login' is your login route
    };

    return (
        <div className="flex h-auto min-h-screen">
            <Sidebar handleLogout={handleLogout} />
            <main className="flex-1 p-6 bg-gray-200">
                <header className="flex justify-between items-center mb-6 w-full">
                    <h1 className="text-3xl font-bold text-[#3272d9] mt-5 hidden md:block">Help</h1>
                </header>

                <div className="bg-white rounded-lg shadow p-4">
                    <div className="mb-4">
                        <h2 className="text-xl font-bold">Frequently Asked Questions</h2>
                        <div className="mt-2">
                            <h3 className="font-semibold">How do I generate a schedule?</h3>
                            <p className="mt-1">To generate a schedule, navigate to the "Schedule" page, select the specify date, select start date, and click the "Generate" button. The system will automatically calculate the end date and generate the schedule for you.</p>
                        </div>
                        <div className="mt-2">
                            <h3 className="font-semibold">How can I view courses?</h3>
                            <p className="mt-1">To view courses, go to the "Courses" page. You will see a list of all the available courses, along with their details.</p>
                        </div>
                        <div className="mt-2">
                            <h3 className="font-semibold">How do I log out?</h3>
                            <p className="mt-1">To log out, click the "Log out" button located at the bottom of the sidebar. This will log you out and redirect you to the login page.</p>
                        </div>
                    </div>
                    <div className="mb-4">
                        <h2 className="text-xl font-bold">Contact Support</h2>
                        <p className="mt-2">If you need further assistance, please contact our support team at support@psu.edu.sa.</p>
                    </div>
                </div>
            </main>
        </div>
    );
};

export default HelpPage;