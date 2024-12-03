
						--First Input
						-- Insert courses
INSERT INTO course (name) VALUES ('CS101');
INSERT INTO course (name) VALUES ('MATH111');
INSERT INTO course (name) VALUES ('CS102');

-- Insert course details
INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS101', 'SE', '1st Semester');
INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS101', 'CS', '1st Semester');
INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS101', 'IS', '1st Semester');
INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('MATH111', 'SE', '1st Semester');
INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('MATH111', 'CS', '1st Semester');
INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('MATH111', 'IS', '1st Semester');
INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS102', 'SE', '2nd Semester');
INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS102', 'CS', '2nd Semester');
INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS102', 'IS', '2nd Semester');

INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('CS101', 'None');
INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('MATH111', 'None');
INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('CS102', 'CS101');

INSERT INTO course_majors (course_name, majors) VALUES ('CS101', 'SE');
INSERT INTO course_majors (course_name, majors) VALUES ('CS101', 'CS');
INSERT INTO course_majors (course_name, majors) VALUES ('CS101', 'IS');
INSERT INTO course_majors (course_name, majors) VALUES ('MATH111', 'SE');
INSERT INTO course_majors (course_name, majors) VALUES ('MATH111', 'CS');
INSERT INTO course_majors (course_name, majors) VALUES ('MATH111', 'IS');
INSERT INTO course_majors (course_name, majors) VALUES ('CS102', 'SE');
INSERT INTO course_majors (course_name, majors) VALUES ('CS102', 'CS');
INSERT INTO course_majors (course_name, majors) VALUES ('CS102', 'IS');

-- Insert time slots
INSERT INTO time_slot (day, time) VALUES (0, '08:30');
INSERT INTO time_slot (day, time) VALUES (1, '12:30');
INSERT INTO time_slot (day, time) VALUES (3, '08:30');
INSERT INTO time_slot (day, time) VALUES (4, '12:30');
INSERT INTO time_slot (day, time) VALUES (5, '16:00');
INSERT INTO time_slot (day, time) VALUES (6, '08:30');
INSERT INTO time_slot (day, time) VALUES (7, '12:30');
INSERT INTO time_slot (day, time) VALUES (8, '16:00');
INSERT INTO time_slot (day, time) VALUES (9, '08:30');
INSERT INTO time_slot (day, time) VALUES (10, '12:30');
INSERT INTO time_slot (day, time) VALUES (11, '16:00')

-- Insert exams
INSERT INTO exam (course_name) VALUES ('CS101');
INSERT INTO exam (course_name) VALUES ('MATH111');
INSERT INTO exam (course_name) VALUES ('CS102')
						
						
						-- SE, CS, and IS Shared Courses
						-- Insert courses
						INSERT INTO course (name) VALUES ('ENG101');
						INSERT INTO course (name) VALUES ('ISC101');
						INSERT INTO course (name) VALUES ('ARAB101');

						INSERT INTO course (name) VALUES ('CS175');
						INSERT INTO course (name) VALUES ('STAT101');
						INSERT INTO course (name) VALUES ('ENG103');
						INSERT INTO course (name) VALUES ('ISC103');

						INSERT INTO course (name) VALUES ('CS285');
						INSERT INTO course (name) VALUES ('CS210');
						INSERT INTO course (name) VALUES ('COM201');

						INSERT INTO course (name) VALUES ('CS330');
						INSERT INTO course (name) VALUES ('PSY101');
						INSERT INTO course (name) VALUES ('ARAB103');

						INSERT INTO course (name) VALUES ('CS331');
						INSERT INTO course (name) VALUES ('CYS401');
						INSERT INTO course (name) VALUES ('ISC203');
						INSERT INTO course (name) VALUES ('ETHC303');

						INSERT INTO course (name) VALUES ('ARAB203');

						-- Insert course detail
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ENG101', 'SE', '1st Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ENG101', 'CS', '1st Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ENG101', 'IS', '1st Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ISC101', 'SE', '1st Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ISC101', 'CS', '1st Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ISC101', 'IS', '1st Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ARAB101', 'SE', '1st Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ARAB101', 'CS', '1st Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ARAB101', 'IS', '1st Semester');

						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS175', 'SE', '2nd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS175', 'CS', '2nd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS175', 'IS', '2nd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('STAT101', 'SE', '2nd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('STAT101', 'CS', '2nd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('STAT101', 'IS', '2nd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ENG103', 'SE', '2nd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ENG103', 'CS', '2nd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ENG103', 'IS', '2nd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ISC103', 'SE', '2nd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ISC103', 'CS', '2nd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ISC103', 'IS', '2nd Semester');

						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS285', 'SE', '3rd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS285', 'CS', '3rd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS285', 'IS', '3rd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS210', 'SE', '3rd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS210', 'CS', '3rd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS210', 'IS', '3rd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('COM201', 'SE', '3rd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('COM201', 'CS', '3rd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('COM201', 'IS', '3rd Semester');

						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS330', 'SE', '4th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS330', 'CS', '4th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS330', 'IS', '4th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('PSY101', 'SE', '4th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('PSY101', 'CS', '4th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('PSY101', 'IS', '4th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ARAB103', 'SE', '4th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ARAB103', 'CS', '4th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ARAB103', 'IS', '4th Semester');

						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS331', 'SE', '5th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS331', 'CS', '5th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS331', 'IS', '5th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CYS401', 'SE', '5th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CYS401', 'CS', '5th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CYS401', 'IS', '5th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ISC203', 'SE', '5th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ISC203', 'CS', '5th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ISC203', 'IS', '5th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ETHC303', 'SE', '6th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ETHC303', 'CS', '6th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ETHC303', 'IS', '6th Semester');

						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ARAB203', 'SE', '7th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ARAB203', 'CS', '7th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ARAB203', 'IS', '7th Semester');

						-- Insert course prerequisites
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('ENG101', 'None');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('ISC101', 'None');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('ARAB101', 'None');

						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('CS175', 'None');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('STAT101', 'MATH111');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('ENG103', 'ENG101');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('ISC103', 'ISC101');

						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('CS285', 'CS101');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('CS210', 'CS102');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('COM201', 'ENG101');

						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('CS330', 'CS210');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('PSY101', 'None');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('ARAB103', 'None');

						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('CS331', 'CS175');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('CYS401', 'None');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('ISC203', 'ISC103');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('ETHC303', 'None');

						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('ARAB203', 'ARAB101');

						-- Insert course majors
						INSERT INTO course_majors (course_name, majors) VALUES ('ENG101', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('ENG101', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('ENG101', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('ISC101', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('ISC101', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('ISC101', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('ARAB101', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('ARAB101', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('ARAB101', 'IS');

						INSERT INTO course_majors (course_name, majors) VALUES ('CS175', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('CS175', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('CS175', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('STAT101', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('STAT101', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('STAT101', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('ENG103', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('ENG103', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('ENG103', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('ISC103', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('ISC103', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('ISC103', 'IS');

						INSERT INTO course_majors (course_name, majors) VALUES ('CS285', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('CS285', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('CS285', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('CS210', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('CS210', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('CS210', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('COM201', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('COM201', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('COM201', 'IS');

						INSERT INTO course_majors (course_name, majors) VALUES ('CS331', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('CS331', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('CS331', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('CYS401', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('CYS401', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('CYS401', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('ISC203', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('ISC203', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('ISC203', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('ETHC303', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('ETHC303', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('ETHC303', 'IS');

						INSERT INTO course_majors (course_name, majors) VALUES ('ARAB203', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('ARAB203', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('ARAB203', 'IS');

						-- Insert course exams
						INSERT INTO exam (course_name) VALUES ('ENG101');
						INSERT INTO exam (course_name) VALUES ('ISC101');
						INSERT INTO exam (course_name) VALUES ('ARAB101');

						INSERT INTO exam (course_name) VALUES ('CS175');
						INSERT INTO exam (course_name) VALUES ('STAT101');
						INSERT INTO exam (course_name) VALUES ('ENG103');
						INSERT INTO exam (course_name) VALUES ('ISC103');

						INSERT INTO exam (course_name) VALUES ('CS285');
						INSERT INTO exam (course_name) VALUES ('CS210');
						INSERT INTO exam (course_name) VALUES ('COM201');

						INSERT INTO exam (course_name) VALUES ('CS331');
						INSERT INTO exam (course_name) VALUES ('CYS401');
						INSERT INTO exam (course_name) VALUES ('ISC203');
						INSERT INTO exam (course_name) VALUES ('ETHC303');

						INSERT INTO exam (course_name) VALUES ('ARAB203');


                        -- SE, CS Shared Courses
						-- Insert courses
                        INSERT INTO course (name) VALUES ('SE201');
						INSERT INTO course (name) VALUES ('SE371');
						INSERT INTO course (name) VALUES ('MATH113');
						INSERT INTO course (name) VALUES ('CS340');

                        -- Insert course detail
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('SE201', 'SE', '3rd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('SE201', 'CS', '4th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('SE371', 'SE', '6th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('SE371', 'CS', '6th Semester');						
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('MATH113', 'SE', '2nd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('MATH113', 'CS', '2nd Semester');						
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS340', 'SE', '5th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS340', 'CS', '5th Semester');
						

                        -- Insert course prerequisites
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('SE201', 'CS102');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('SE201', 'ENG103');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('SE371', 'CS210');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('MATH113', 'MATH111');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('CS340', 'CS210');

						-- Insert course majors
						INSERT INTO course_majors (course_name, majors) VALUES ('SE201', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('SE201', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('SE371', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('SE371', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('MATH113', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('MATH113', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('CS340', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('CS340', 'CS');


						-- Insert course exams
						INSERT INTO exam (course_name) VALUES ('SE201');
						INSERT INTO exam (course_name) VALUES ('SE371');
						INSERT INTO exam (course_name) VALUES ('MATH113');
						INSERT INTO exam (course_name) VALUES ('CS340');


                        --// IS, CS Shared Courses
						-- Insert courses
						INSERT INTO course (name) VALUES ('SCI101');

                        -- Insert course detail
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('SCI101', 'IS', '1st Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('SCI101', 'CS', '1st Semester');

                        -- Insert course prerequisites
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('SCI101', 'None');

						-- Insert course majors
						INSERT INTO course_majors (course_name, majors) VALUES ('SCI101', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('SCI101', 'CS');

						-- Insert course exams
						INSERT INTO exam (course_name) VALUES ('SCI101');



                        --// SE-only Courses
						-- Insert courses
                        INSERT INTO course (name) VALUES ('CHM101');
						INSERT INTO course (name) VALUES ('SE365');
						INSERT INTO course (name) VALUES ('SE311');
						INSERT INTO course (name) VALUES ('SE322');
						INSERT INTO course (name) VALUES ('SE401');
						INSERT INTO course (name) VALUES ('SE423');
						INSERT INTO course (name) VALUES ('SE411');
						INSERT INTO course (name) VALUES ('MATH223');

                        -- Insert course detail
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CHM101', 'SE', '1st Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('SE365', 'SE', '4th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('SE311', 'SE', '4th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('SE322', 'SE', '5th Semester');						
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('SE401', 'SE', '6th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('SE423', 'SE', '7th Semester');						
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('SE411', 'SE', '7th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('MATH223', 'SE', '4th Semester');
						
                        -- Insert course prerequisites
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('CHM101', 'None');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('SE365', 'CS210');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('SE311', 'SE201');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('SE322', 'SE311');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('SE401', 'None');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('SE423', 'CYS401');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('SE411', 'SE401');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('MATH223', 'MATH113');

						-- Insert course majors
						INSERT INTO course_majors (course_name, majors) VALUES ('CHM101', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('SE365', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('SE311', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('SE322', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('SE401', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('SE423', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('SE411', 'SE');
						INSERT INTO course_majors (course_name, majors) VALUES ('MATH223', 'SE');

						-- Insert course exams
						INSERT INTO exam (course_name) VALUES ('CHM101');
						INSERT INTO exam (course_name) VALUES ('SE365');
						INSERT INTO exam (course_name) VALUES ('SE311');
						INSERT INTO exam (course_name) VALUES ('SE322');
						INSERT INTO exam (course_name) VALUES ('SE401');
						INSERT INTO exam (course_name) VALUES ('SE423');
						INSERT INTO exam (course_name) VALUES ('SE411');
						INSERT INTO exam (course_name) VALUES ('MATH223');



                        
                        --// CS-only Courses
						-- Insert courses
                        INSERT INTO course (name) VALUES ('CS223');
						INSERT INTO course (name) VALUES ('CS320');
						INSERT INTO course (name) VALUES ('CS311');
						INSERT INTO course (name) VALUES ('CS435');


                        -- Insert course detail
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS223', 'CS', '3rd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS320', 'CS', '4th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS311', 'CS', '5th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('CS435', 'CS', '6th Semester');						

                        -- Insert course prerequisites
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('CS223', 'CS101');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('CS223', 'MATH113');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('CS320', 'CS210');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('CS311', 'CS285');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('CS435', 'CS330');


						-- Insert course majors
						INSERT INTO course_majors (course_name, majors) VALUES ('CS223', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('CS320', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('CS311', 'CS');
						INSERT INTO course_majors (course_name, majors) VALUES ('CS435', 'CS');

						-- Insert course exams
						INSERT INTO exam (course_name) VALUES ('CS223');
						INSERT INTO exam (course_name) VALUES ('CS320');
						INSERT INTO exam (course_name) VALUES ('CS311');
						INSERT INTO exam (course_name) VALUES ('CS435');

                        
                        --// IS-only Courses
						-- Insert courses
                        INSERT INTO course (name) VALUES ('BUS101');
						INSERT INTO course (name) VALUES ('ACC111');
						INSERT INTO course (name) VALUES ('IS201');
						INSERT INTO course (name) VALUES ('IS205');
						INSERT INTO course (name) VALUES ('IS231');
						INSERT INTO course (name) VALUES ('IS241');
						INSERT INTO course (name) VALUES ('IS321');
						INSERT INTO course (name) VALUES ('MKT301');
						INSERT INTO course (name) VALUES ('ECON101');
						INSERT INTO course (name) VALUES ('IS311');
						INSERT INTO course (name) VALUES ('IS361');
						INSERT INTO course (name) VALUES ('IS371');
						INSERT INTO course (name) VALUES ('COM301');
						INSERT INTO course (name) VALUES ('FIN210');

                        -- Insert course detail
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('BUS101', 'IS', '2nd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ACC111', 'IS', '3rd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('IS201', 'IS', '3rd Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('IS205', 'IS', '4th Semester');						
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('IS231', 'IS', '4th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('IS241', 'IS', '4th Semester');						
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('IS321', 'IS', '5th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('MKT301', 'IS', '5th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('ECON101', 'IS', '5th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('IS311', 'IS', '6th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('IS361', 'IS', '6th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('IS371', 'IS', '6th Semester');						
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('COM301', 'IS', '7th Semester');
						INSERT INTO course_major_to_semester (course_name, major_to_semester_key, major_to_semester) VALUES ('FIN210', 'IS', '7th Semester');						
						
                        -- Insert course prerequisites
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('BUS101', 'None');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('ACC111', 'None');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('IS201', 'None');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('IS205', 'None');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('IS231', 'None');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('IS241', 'None');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('IS321', 'None');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('MKT301', 'None');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('ECON101', 'None');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('IS311', 'None');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('IS361', 'None');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('IS371', 'None');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('COM301', 'None');
						INSERT INTO course_prerequisites (course_name, prerequisites) VALUES ('FIN210', 'None');

						-- Insert course majors
						INSERT INTO course_majors (course_name, majors) VALUES ('BUS101', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('ACC111', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('IS201', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('IS205', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('IS231', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('IS241', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('IS321', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('MKT301', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('ECON101', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('IS311', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('IS361', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('IS371', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('COM301', 'IS');
						INSERT INTO course_majors (course_name, majors) VALUES ('FIN210', 'IS');

						-- Insert course exams
						INSERT INTO exam (course_name) VALUES ('BUS101');
						INSERT INTO exam (course_name) VALUES ('ACC111');
						INSERT INTO exam (course_name) VALUES ('IS201');
						INSERT INTO exam (course_name) VALUES ('IS205');
						INSERT INTO exam (course_name) VALUES ('IS231');
						INSERT INTO exam (course_name) VALUES ('IS241');
						INSERT INTO exam (course_name) VALUES ('IS321');
						INSERT INTO exam (course_name) VALUES ('MKT301');
						INSERT INTO exam (course_name) VALUES ('ECON101');
						INSERT INTO exam (course_name) VALUES ('IS311');
						INSERT INTO exam (course_name) VALUES ('IS361');
						INSERT INTO exam (course_name) VALUES ('IS371');
						INSERT INTO exam (course_name) VALUES ('COM301');
						INSERT INTO exam (course_name) VALUES ('FIN210');
