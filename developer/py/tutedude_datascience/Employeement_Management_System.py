
# Employee Management System (EMS)
# Step 1 - Initialize employee data dictionary with sample data
employees = {
    101: {'name': 'Satya', 'age': 27, 'department': 'HR', 'salary': 50000},
    102: {'name': 'Priya', 'age': 30, 'department': 'Finance', 'salary': 60000},
    103: {'name': 'Rahul', 'age': 25, 'department': 'IT', 'salary': 55000}
}
# Step 3 - Add Employee Functionality
def add_employee():
    """Adds a new employee to the dictionary."""
    print("\n--- Add Employee ---")
    # Prompt for Employee ID and validate uniqueness
    while True:
        emp_id = int(input("Enter Employee ID: "))
        if emp_id in employees:
            print("Employee ID already exists. Please enter a unique ID.")
        else:
            break
    name = input("Enter Employee Name: ")
    age = int(input("Enter Employee Age: "))
    department = input("Enter Employee Department: ")
    salary = float(input("Enter Employee Salary: "))
    # Store the employee data
    employees[emp_id] = {
        'name': name,
        'age': age,
        'department': department,
        'salary': salary
    }
    print(f"Employee '{name}' added successfully!")
