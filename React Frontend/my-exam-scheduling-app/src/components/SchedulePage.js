import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import axios from 'axios';
import Sidebar from './Sidebar';
import * as XLSX from 'xlsx';
import '../styles/styles.css'; // Ensure this path is correct

const SchedulePage = () => {
    const navigate = useNavigate();
    const location = useLocation();
    const { startDate: initialStartDate, endDate: initialEndDate, courses: initialCourses } = location.state || {};

    const handleLogout = () => {
        navigate('/login');  // Assuming '/login' is your login route
    };

    const [courses, setCourses] = useState(initialCourses || []);
    const [selectedCollege, setSelectedCollege] = useState('College of Computer & Information Sciences');
    const [isLoading, setIsLoading] = useState(false);
    const [showDeleteConfirm, setShowDeleteConfirm] = useState(false);
    const [startDate, setStartDate] = useState(initialStartDate ? new Date(initialStartDate) : new Date());
    const [endDate, setEndDate] = useState(initialEndDate ? new Date(initialEndDate) : new Date());
    const [isTableVisible, setIsTableVisible] = useState(false); // State to manage table visibility

    useEffect(() => {
        const savedStartDate = localStorage.getItem('startDate');
        const savedEndDate = localStorage.getItem('endDate');
        const savedCourses = localStorage.getItem('courses');
        if (savedStartDate && savedEndDate && savedCourses) {
            setStartDate(new Date(savedStartDate));
            setEndDate(new Date(savedEndDate));
            setCourses(JSON.parse(savedCourses));
            setIsTableVisible(true); // Show the table
        } else if (!initialCourses) {
            // Check if the schedule already exists
            axios.get('http://localhost:8082/api/schedule/exist')
                .then(response => {
                    if (response.data) {
                        // Fetch the saved schedule
                        axios.get('http://localhost:8082/api/schedule')
                            .then(response => {
                                console.log('Fetched courses:', response.data); // Log the fetched data
                                setCourses(response.data);
                                setIsTableVisible(true); // Show the table
                            })
                            .catch(error => {
                                console.error('There was an error fetching the courses!', error);
                            });
                    }
                })
                .catch(error => {
                    console.error('There was an error checking the schedule existence!', error);
                });
        }
    }, [initialCourses]);

    const handleCollegeChange = (event) => {
        setSelectedCollege(event.target.value);
    };

    const handleDeleteSchedule = () => {
        axios.delete('http://localhost:8082/api/schedule/delete')
            .then(response => {
                console.log('Schedule deleted:', response.data);
                setCourses([]); // Clear the courses state
                setShowDeleteConfirm(false); // Close the confirmation dialog
                setIsTableVisible(false); // Hide the table
            })
            .catch(error => {
                console.error('There was an error deleting the schedule!', error);
            });
    };

    const handleGenerateSchedule = () => {
        setIsLoading(true);
        axios.post('http://localhost:8082/api/schedule/generate')
            .then(response => {
                console.log('Generated courses:', response.data); // Log the generated data
                setCourses(response.data);
                setIsLoading(false);
                setIsTableVisible(true); // Show the table
            })
            .catch(error => {
                console.error('There was an error generating the schedule!', error);
                setIsLoading(false);
            });
    };

    const handleExtractToExcel = () => {
        const worksheet = XLSX.utils.json_to_sheet(courses.map(course => ({
            Day: getDayName(course.timeSlot.day),
            Date: getDateForDay(course.timeSlot.day),
            Time: course.timeSlot.time,
            Course: course.course.name,
            Location: 'To be assigned'
        })));
        const workbook = XLSX.utils.book_new();
        XLSX.utils.book_append_sheet(workbook, worksheet, 'Schedule');
        XLSX.writeFile(workbook, 'FinalExamSchedule.xlsx');
    };

    const getDateForDay = (day) => {
        let date = new Date(startDate);
        let daysAdded = 0;
        while (daysAdded < day) {
            date.setDate(date.getDate() + 1);
            if (date.getDay() !== 5) { // Exclude Fridays
                daysAdded++;
            }
        }
        return date.toLocaleDateString();
    };

    const getDayName = (day) => {
        let date = new Date(startDate);
        let daysAdded = 0;
        while (daysAdded < day) {
            date.setDate(date.getDate() + 1);
            if (date.getDay() !== 5) { // Exclude Fridays
                daysAdded++;
            }
        }
        return date.toLocaleDateString('en-US', { weekday: 'long' });
    };

    const handleRespecifyDates = () => {
        navigate('/generate');
    };

    return (
        <div className="flex h-auto min-h-screen">
            <Sidebar handleLogout={handleLogout} />
            <main className="flex-1 p-6 bg-gray-200">
                <header className="flex justify-between items-center mb-6 w-full">
                    <h1 className="text-3xl font-bold text-[#3272d9] mt-5 hidden md:block">Schedule</h1>
                    <div className="flex items-center gap-4">
                        <select 
                            className="border border-gray-300 rounded-lg p-2"
                            value={selectedCollege}
                            onChange={handleCollegeChange}
                        >
                            <option>College of Computer & Information Sciences</option>
                            <option>College of Law</option>
                            <option>College of Engineering</option>
                        </select>
                        <button 
                            className="delete-btn"
                            onClick={() => setShowDeleteConfirm(true)}
                        >
                            <span className="text">Delete</span>
                        </button>
                        <button 
                            className="btn"
                            onClick={handleGenerateSchedule}
                        >
                            <span className="text">Generate</span>
                        </button>
                        <button 
                            className="btn"
                            onClick={handleRespecifyDates}
                        >
                            <span className="text">Specify Dates</span>
                        </button>
                        <button 
                            class='excel-btn'
                            onClick={handleExtractToExcel}
                        >
                            <span className="text">Extract to Excel</span>
                        </button>
                    </div>
                </header>

                <div className="bg-white rounded-lg shadow p-4">
                    <div className="flex justify-between items-center mb-4">
                        <button className="text-gray-500"></button>
                        <h2 className="text-xl font-bold">{selectedCollege}</h2>
                        <button className="text-gray-500"></button>
                    </div>
                    {isLoading ? (
                        <div className="flex justify-center items-center p-4">
                            <div className="custom-loader"></div>
                        </div>
                    ) : selectedCollege === 'College of Computer & Information Sciences' ? (
                        <div className={`table-responsive transition-opacity duration-500 ${isTableVisible ? 'opacity-100' : 'opacity-0'}`}>
                            <table className="table-auto w-full">
                                <thead>
                                    <tr className="bg-gray-200">
                                        <th className="text-center p-2">Day</th>
                                        <th className="text-center p-2">Date</th>
                                        <th className="text-center p-2">Time</th>
                                        <th className="text-center p-2">Course</th>
                                        <th className="text-center p-2">Location</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {courses.map(course => (
                                        <tr key={course.id} className="border-b">
                                            <td className="text-center p-2">{getDayName(course.timeSlot.day)}</td>
                                            <td className="text-center p-2">{getDateForDay(course.timeSlot.day)}</td>
                                            <td className="text-center p-2">{course.timeSlot.time}</td>
                                            <td className="text-center p-2">{course.course.name}</td>
                                            <td className="text-center p-2">To be assigned</td>
                                        </tr>
                                    ))}
                                </tbody>
                            </table>
                        </div>
                    ) : (
                        <div className="text-center p-4 text-gray-500">
                            No schedule has been assigned yet for {selectedCollege}.
                        </div>
                    )}
                </div>

                {showDeleteConfirm && (
                    <div className="fixed inset-0 bg-gray-600 bg-opacity-50 flex justify-center items-center">
                        <div className="bg-white p-6 rounded-lg shadow-lg">
                            <h2 className="text-xl font-bold mb-4">Confirm Deletion</h2>
                            <p className="mb-4">Are you sure you want to delete the schedule?</p>
                            <div className="flex justify-end">
                                <button 
                                    className="bg-gray-300 text-gray-700 p-2 rounded-lg mr-2 hover:bg-gray-400 transition duration-150"
                                    onClick={() => setShowDeleteConfirm(false)}
                                >
                                    Cancel
                                </button>
                                <button 
                                    className="bg-red-600 text-white p-2 rounded-lg hover:bg-red-700 transition duration-150"
                                    onClick={handleDeleteSchedule}
                                >
                                    Delete
                                </button>
                            </div>
                        </div>
                    </div>
                )}
            </main>
        </div>
    );
};

export default SchedulePage;