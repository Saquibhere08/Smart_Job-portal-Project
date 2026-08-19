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


# Step 4 - View All Employees
def view_employees():
    """Displays all employee details in a table-like format."""
    print("\n--- All Employees ---")

    if not employees:
        print("No employees available.")
        return

    # Print table header
    print(f"{'ID':<10}{'Name':<15}{'Age':<10}{'Department':<15}{'Salary':<10}")
    print("-" * 60)

    # Print each employee's details
    for emp_id, details in employees.items():
        print(f"{emp_id:<10}{details['name']:<15}{details['age']:<10}{details['department']:<15}{details['salary']:<10}")


# Step 5 - Search for an Employee by ID
def search_employee():
    """Searches for an employee by their ID."""
    print("\n--- Search Employee ---")

    emp_id = int(input("Enter Employee ID to search: "))

    if emp_id in employees:
        details = employees[emp_id]
        print(f"\nEmployee Found:")
        print(f"  ID        : {emp_id}")
        print(f"  Name      : {details['name']}")
        print(f"  Age       : {details['age']}")
        print(f"  Department: {details['department']}")
        print(f"  Salary    : {details['salary']}")
    else:
        print("Employee not found.")


# Step 2 & 6 - Menu System with Exit
def main_menu():
    """Displays the main menu and calls the appropriate function based on user input."""
    while True:
        print("\n===== Employee Management System =====")
        print("1. Add Employee")
        print("2. View All Employees")
        print("3. Search for Employee")
        print("4. Exit")

        choice = input("Enter your choice (1-4): ")

        if choice == '1':
            add_employee()
        elif choice == '2':
            view_employees()
        elif choice == '3':
            search_employee()
        elif choice == '4':
            print("Thank you for using the Employee Management System. Goodbye!")
            break
        else:
            print("Invalid choice. Please enter a number between 1 and 4.")


# Run the program
main_menu()
