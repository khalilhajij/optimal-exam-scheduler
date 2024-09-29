from ortools.sat.python import cp_model

# Define the model
model = cp_model.CpModel()

# Courses per semester (updated study plan)
courses_per_semester = {
    "1st Semester": ["CS101", "CHM101", "MATH111", "ENG101", "ISC101", "ARAB101"],
    "2nd Semester": ["CS102", "CS175", "MATH113", "STAT101", "ENG103", "ISC103"],
    "3rd Semester": ["CS285", "SE201", "PHY105", "COM201", "ISC105", "CS210"],
    "4th Semester": ["SE365", "SE311", "CS330", "PHY205", "PSY101", "MATH223"],
    "5th Semester": ["CS340", "CS331", "SE322", "CYS401", "ISC203", "ARAB103"],
    "6th Semester": ["MATH221", "SE371", "ETHC303", "SE401"],
    "7th Semester": ["SE423", "SE411", "ARAB203"],
}

# Prerequisites (course dependencies)
prerequisites = {
    "CS102": "CS101",
    "CS285": "CS101",
    "CS210": "CS102",
    "SE201": "CS102",
    "CS331": "CS175",
    "SE365": "CS210",
    "CS330": "CS210",
    "CS340": "CS210",
    "SE371": "CS210",
    "SE311": "SE201",
    "SE322": "SE311",
    "SE423": "CYS401",
    "ETHC303": "CYS401",
    "SE411": "SE401",
    "ARAB203": "ARAB101",
    "ISC203": "ISC103",
    "ENG103": "ENG101",
    "COM201": "ENG101",
    "STAT101": "MATH111",
    "MATH113": "MATH111",
    "MATH223": "MATH113",
    "MATH221": "MATH113",
    "PHY205": "PHY105",
}

# Days and time slots
exam_dates = list(range(12))  # 12 days
time_slots = [0, 1, 2]  # 0: 8:30, 1: 12:30, 2: 16:00

# Create a variable for each course's exam slot (date and time period)
exam_slot_vars = {}
for semester, courses in courses_per_semester.items():
    for course in courses:
        exam_slot_vars[course] = model.NewIntVar(0, len(exam_dates) * len(time_slots) - 1, course)

# Add constraints for exam slots per semester (no same-day exams within the same semester)
for semester, courses in courses_per_semester.items():
    for i in range(len(courses)):
        for j in range(i + 1, len(courses)):
            course_1 = courses[i]
            course_2 = courses[j]
            # Ensure exams aren't on the same day (with flexibility for time slots)
            exam_day_1 = model.NewIntVar(0, len(exam_dates) - 1, f'{course_1}_day')
            exam_day_2 = model.NewIntVar(0, len(exam_dates) - 1, f'{course_2}_day')
            exam_time_slot_1 = model.NewIntVar(0, len(time_slots) - 1, f'{course_1}_time_slot')
            exam_time_slot_2 = model.NewIntVar(0, len(time_slots) - 1, f'{course_2}_time_slot')

            model.AddDivisionEquality(exam_day_1, exam_slot_vars[course_1], len(time_slots))
            model.AddModuloEquality(exam_time_slot_1, exam_slot_vars[course_1], len(time_slots))
            model.AddDivisionEquality(exam_day_2, exam_slot_vars[course_2], len(time_slots))
            model.AddModuloEquality(exam_time_slot_2, exam_slot_vars[course_2], len(time_slots))

            # Add constraints for exam slots per semester (no same-day exams within the same semester)
for semester, courses in courses_per_semester.items():
    for i in range(len(courses)):
        for j in range(i + 1, len(courses)):
            course_1 = courses[i]
            course_2 = courses[j]
            # Ensure exams aren't on the same day (with flexibility for time slots)
            exam_day_1 = model.NewIntVar(0, len(exam_dates) - 1, f'{course_1}_day')
            exam_day_2 = model.NewIntVar(0, len(exam_dates) - 1, f'{course_2}_day')
            exam_time_slot_1 = model.NewIntVar(0, len(time_slots) - 1, f'{course_1}_time_slot')
            exam_time_slot_2 = model.NewIntVar(0, len(time_slots) - 1, f'{course_2}_time_slot')

            model.AddDivisionEquality(exam_day_1, exam_slot_vars[course_1], len(time_slots))
            model.AddModuloEquality(exam_time_slot_1, exam_slot_vars[course_1], len(time_slots))
            model.AddDivisionEquality(exam_day_2, exam_slot_vars[course_2], len(time_slots))
            model.AddModuloEquality(exam_time_slot_2, exam_slot_vars[course_2], len(time_slots))

            # Create boolean variables for the conditions
            day1_gt_day2 = model.NewBoolVar(f'{course_1}_gt_{course_2}')
            day2_gt_day1 = model.NewBoolVar(f'{course_2}_gt_{course_1}')

            # Enforce the conditions
            model.Add(exam_day_1 >= exam_day_2 + 2).OnlyEnforceIf(day1_gt_day2)
            model.Add(exam_day_2 >= exam_day_1 + 2).OnlyEnforceIf(day2_gt_day1)

            # Ensure at least one of the conditions is true
            model.Add(day1_gt_day2 + day2_gt_day1 >= 1)


# Add prerequisite constraints (prerequisite exams must occur before the dependent course exams)
for req, prereq in prerequisites.items():
    if req in exam_slot_vars and prereq in exam_slot_vars:
        model.Add(exam_slot_vars[prereq] < exam_slot_vars[req])

# Flexible same-day exams for different semesters or prerequisites
for semester, courses in courses_per_semester.items():
    for course in courses:
        course_day = model.NewIntVar(0, len(exam_dates) - 1, f'{course}_day')
        model.AddDivisionEquality(course_day, exam_slot_vars[course], len(time_slots))


# Ensure PSY101 is scheduled near the end
model.Add(exam_slot_vars['PSY101'] >= 9 * len(time_slots))

# Solving the model
solver = cp_model.CpSolver()
status = solver.Solve(model)

# Check the result
if status == cp_model.OPTIMAL or status == cp_model.FEASIBLE:
    for course, var in exam_slot_vars.items():
        exam_day = solver.Value(var) // len(time_slots)  # Correct usage of integer division
        exam_time_slot = solver.Value(var) % len(time_slots)  # Correct usage of modulo
        print(f"{course}: Day {exam_day + 1}, Time Slot {['08:30', '12:30', '16:00'][exam_time_slot]}")
else:
    print("No solution found.")
