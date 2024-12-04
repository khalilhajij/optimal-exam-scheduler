import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import axios from 'axios';
import Sidebar from './Sidebar';
import '../styles/styles.css';

const CoursesPage = () => {
    const navigate = useNavigate();
    const location = useLocation();
    const { startDate: initialStartDate, endDate: initialEndDate, courses: initialCourses } = location.state || {};

    const handleLogout = () => {
        navigate('/login');  // Assuming '/login' is your login route
    };

    const [courses, setCourses] = useState(initialCourses || []);
    const [selectedCollege, setSelectedCollege] = useState('College of Computer & Information Sciences');
    const [selectedMajor, setSelectedMajor] = useState('All'); // State for selected major
    const [isLoading, setIsLoading] = useState(false);
    const [isTableVisible, setIsTableVisible] = useState(false); // State to manage table visibility

    useEffect(() => {
        if (!initialCourses) {
            // Check if the schedule already exists
            axios.get('http://localhost:8082/api/schedule/exist')
                .then(response => {
                    if (response.data) {
                        // Fetch the saved schedule
                        axios.get('http://localhost:8082/api/schedule')
                            .then(response => {
                                console.log('Fetched courses:', response.data); // Log the fetched data
                                const fetchedCourses = response.data.map(exam => ({
                                    id: exam.id,
                                    name: exam.course.name,
                                    majorToSemester: exam.course.majorToSemester,
                                    prerequisites: exam.course.prerequisites,
                                    majors: exam.course.majors
                                }));
                                console.log('Processed courses data:', fetchedCourses);
                                setCourses(fetchedCourses);
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

    const handleMajorChange = (event) => {
        setSelectedMajor(event.target.value);
    };

    const filteredCourses = courses.filter(course => {
        console.log('Filtering course:', course);
        if (!course.majors) return false; // Ensure majors property exists
        console.log('Course majors:', course.majors);
        console.log('Selected college:', selectedCollege);
        console.log('Selected major:', selectedMajor);
        if (selectedMajor === 'All') {
            return true; // Show all courses if "All" is selected
        }
        return course.majors.includes(selectedMajor);
    });

    const sortedCourses = filteredCourses.sort((a, b) => {
        const semesterA = a.majorToSemester[selectedCollege] || ''; // Provide default value if undefined
        const semesterB = b.majorToSemester[selectedCollege] || ''; // Provide default value if undefined
        return semesterA.localeCompare(semesterB);
    });

    console.log('Filtered and sorted courses:', sortedCourses);

    return (
        <div className="flex h-auto min-h-screen">
            <Sidebar handleLogout={handleLogout} />
            <main className="flex-1 p-6 bg-gray-200">
                <header className="flex justify-between items-center mb-6 w-full">
                    <h1 className="text-3xl font-bold text-[#3272d9] mt-5 hidden md:block">Courses</h1>
                    <div className="flex items-center">
                        <select 
                            className="border border-gray-300 rounded-lg p-2 mr-2"
                            value={selectedCollege}
                            onChange={handleCollegeChange}
                        >
                            <option>College of Computer & Information Sciences</option>
                        </select>
                        <select 
                            className="border border-gray-300 rounded-lg p-2"
                            value={selectedMajor}
                            onChange={handleMajorChange}
                        >
                            <option value="All">All Majors</option>
                            <option value="CS">Computer Science</option>
                            <option value="SE">Software Engineering</option>
                            <option value="IS">Information Systems</option>
                        </select>
                    </div>
                </header>

                <div className="bg-white rounded-lg shadow p-4">
                    <div className="flex justify-between items-center mb-4">
                        <button className="text-gray-500"></button>
                        <h2 className="text-xl font-bold">{selectedCollege}</h2>
                        <button className="text-gray-500"></button>
                    </div>
                    {isLoading ? (
                        <div className="text-center p-4">
                            <i className="fas fa-spinner fa-spin text-3xl text-gray-500"></i>
                        </div>
                    ) : (
                        <div className={`table-responsive transition-opacity duration-500 ${isTableVisible ? 'opacity-100' : 'opacity-0'}`}>
                            <table className="table-auto w-full">
                                <thead>
                                    <tr className="bg-gray-200">
                                        <th className="text-center p-2">Course</th>
                                        <th className="text-center p-2">Semesters</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {sortedCourses.map(course => (
                                        <tr key={course.id} className="border-b">
                                            <td className="text-center p-2">{course.name}</td>
                                            <td className="text-center p-2">
                                                {Object.entries(course.majorToSemester).map(([major, semester]) => (
                                                    selectedMajor === 'All' ? (
                                                        <div key={major}>{major}: {semester}</div>
                                                    ) : (
                                                        major === selectedMajor && <div key={major}>{semester}</div>
                                                    )
                                                ))}
                                            </td>
                                        </tr>
                                    ))}
                                </tbody>
                            </table>
                        </div>
                    )}
                </div>
            </main>
        </div>
    );
};

export default CoursesPage;