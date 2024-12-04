import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import axios from 'axios';
import Sidebar from './Sidebar';
import '../styles/styles.css';

const Generate = () => {
    const navigate = useNavigate();

    const isFriday = (date) => {
        return date.getDay() === 5;
    };

    const calculateEndDate = (startDate) => {
        let endDate = new Date(startDate);
        let daysAdded = 0;
        while (daysAdded < 12) {
            endDate.setDate(endDate.getDate() + 1);
            if (endDate.getDay() !== 5) { // Exclude Fridays
                daysAdded++;
            }
        }
        return endDate;
    };

    const [startDate, setStartDate] = useState(new Date());
    const [endDate, setEndDate] = useState(calculateEndDate(new Date()));
    const [isLoading, setIsLoading] = useState(false); // State to track loading status

    useEffect(() => {
        const savedStartDate = localStorage.getItem('startDate');
        const savedEndDate = localStorage.getItem('endDate');
        if (savedStartDate && savedEndDate) {
            setStartDate(new Date(savedStartDate));
            setEndDate(new Date(savedEndDate));
        }
    }, []);

    const handleLogout = () => {
        navigate('/login');
    };

    const handleStartDateChange = (date) => {
        if (!isFriday(date)) {
            setStartDate(date);
            setEndDate(calculateEndDate(date));
        } else {
            alert("Start date cannot be a Friday.");
        }
    };

    const handleGenerateSchedule = () => {
        setIsLoading(true); // Set loading state to true
        axios.post('http://localhost:8082/api/schedule/generate', { startDate, endDate })
            .then(response => {
                console.log('Generated courses:', response.data); // Log the generated data
                localStorage.setItem('startDate', startDate);
                localStorage.setItem('endDate', endDate);
                localStorage.setItem('courses', JSON.stringify(response.data));
                navigate('/schedule', { state: { startDate, endDate, courses: response.data } });
                setIsLoading(false); // Set loading state to false
            })
            .catch(error => {
                console.error('There was an error generating the schedule!', error);
                setIsLoading(false); // Set loading state to false
            });
    };

    return (
        <div className="flex h-screen">
            <Sidebar handleLogout={handleLogout} />
            <main className="flex-1 flex flex-col items-center justify-center p-6 bg-gray-200">
                <h1 className="text-3xl font-bold text-[#3272d9] mb-4">Choose a 12-day period to generate schedule</h1>
                <div className="flex flex-col items-center bg-white rounded-lg shadow-lg p-8 w-full max-w-md">
                    <div className="mb-4 w-full">
                        <label className="block text-gray-700 text-sm font-bold mb-2">Start Date</label>
                        <DatePicker
                            selected={startDate}
                            onChange={handleStartDateChange}
                            selectsStart
                            startDate={startDate}
                            endDate={endDate}
                            className="w-full p-2 border border-gray-300 rounded-lg"
                        />
                    </div>
                    <div className="mb-4 w-full">
                        <label className="block text-gray-700 text-sm font-bold mb-2">End Date</label>
                        <DatePicker
                            selected={endDate}
                            onChange={(date) => setEndDate(date)}
                            selectsEnd
                            startDate={startDate}
                            endDate={endDate}
                            minDate={startDate}
                            className="w-full p-2 border border-gray-300 rounded-lg"
                            disabled
                        />
                    </div>
                    <button 
                        className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded w-full"
                        onClick={handleGenerateSchedule}
                        disabled={isLoading} // Disable button when loading
                    >
                        {isLoading ? (
                            <i className="fas fa-spinner fa-spin"></i> // Show spinner when loading
                        ) : (
                            'Generate'
                        )}
                    </button>
                </div>
            </main>
        </div>
    );
};

export default Generate;