import java.util.*;
import java.time.*;
import java.time.format.*;
import java.text.DecimalFormat;

public class PayrollSystemDemo {
    
    private static List<Employee> employees = new ArrayList<>();
    private static List<PayrollRecord> payrollRecords = new ArrayList<>();
    private static int nextEmpId = 1001;
    private static int nextPayrollId = 5001;
    private static DecimalFormat moneyFormat = new DecimalFormat("Rs #,##0.00");
    
    public static void main(String[] args) {
        System.out.println("================================================================");
        System.out.println("     EMPLOYEE PAYROLL SYSTEM - COMPLETE DEMO EXECUTION          ");
        System.out.println("              (All Features Will Be Demonstrated)               ");
        System.out.println("================================================================");
        
        // Load sample data
        loadSampleData();
        
        // DEMONSTRATION 1: View All Employees
        System.out.println("\n\n[DEMO 1] VIEWING ALL EMPLOYEES");
        System.out.println("----------------------------------------------------------------");
        viewAllEmployees();
        pressAnyKey();
        
        // DEMONSTRATION 2: Add New Employee
        System.out.println("\n\n[DEMO 2] ADDING A NEW EMPLOYEE");
        System.out.println("----------------------------------------------------------------");
        addDemoEmployee();
        viewAllEmployees();
        pressAnyKey();
        
        // DEMONSTRATION 3: Search Employee
        System.out.println("\n\n[DEMO 3] SEARCHING EMPLOYEES");
        System.out.println("----------------------------------------------------------------");
        searchByID(1001);
        searchByName("Priya");
        searchByDepartment("IT");
        pressAnyKey();
        
        // DEMONSTRATION 4: Department Statistics
        System.out.println("\n\n[DEMO 4] DEPARTMENT STATISTICS");
        System.out.println("----------------------------------------------------------------");
        calculateDepartmentStats();
        pressAnyKey();
        
        // DEMONSTRATION 5: Process Payroll
        System.out.println("\n\n[DEMO 5] PROCESSING PAYROLL");
        System.out.println("----------------------------------------------------------------");
        processPayrollDemo();
        pressAnyKey();
        
        // DEMONSTRATION 6: View Payroll Records
        System.out.println("\n\n[DEMO 6] VIEWING PAYROLL RECORDS");
        System.out.println("----------------------------------------------------------------");
        viewAllPayrollRecords();
        pressAnyKey();
        
        // DEMONSTRATION 7: Update Employee
        System.out.println("\n\n[DEMO 7] UPDATING EMPLOYEE INFORMATION");
        System.out.println("----------------------------------------------------------------");
        updateEmployeeDemo();
        viewAllEmployees();
        pressAnyKey();
        
        // DEMONSTRATION 8: Generate Full Report
        System.out.println("\n\n[DEMO 8] GENERATING COMPLETE SYSTEM REPORT");
        System.out.println("----------------------------------------------------------------");
        generateFullReport();
        pressAnyKey();
        
        // DEMONSTRATION 9: Delete Employee
        System.out.println("\n\n[DEMO 9] DELETING AN EMPLOYEE");
        System.out.println("----------------------------------------------------------------");
        deleteEmployeeDemo();
        viewAllEmployees();
        pressAnyKey();
        
        // DEMONSTRATION 10: Payroll by Month Filter
        System.out.println("\n\n[DEMO 10] FILTERING PAYROLL BY MONTH");
        System.out.println("----------------------------------------------------------------");
        viewPayrollByMonth();
        
        // FINAL SUMMARY
        System.out.println("\n\n================================================================");
        System.out.println("                    DEMO COMPLETED SUCCESSFULLY                  ");
        System.out.println("================================================================");
        System.out.println("  All 10 Features Demonstrated:                                 ");
        System.out.println("  1. View All Employees                                         ");
        System.out.println("  2. Add New Employee                                           ");
        System.out.println("  3. Search Employees                                           ");
        System.out.println("  4. Department Statistics                                      ");
        System.out.println("  5. Process Payroll                                            ");
        System.out.println("  6. View Payroll Records                                       ");
        System.out.println("  7. Update Employee                                            ");
        System.out.println("  8. Generate Full Report                                       ");
        System.out.println("  9. Delete Employee                                            ");
        System.out.println(" 10. Filter Payroll by Month                                    ");
        System.out.println("                                                                ");
        System.out.println("  Total Employees: " + employees.size());
        System.out.println("  Total Payroll Records: " + payrollRecords.size());
        System.out.println("================================================================");
    }
    
    private static void pressAnyKey() {
        System.out.println("\nPress Enter to continue...");
        try {
            System.in.read();
            System.in.skip(System.in.available());
        } catch (Exception e) {}
    }
    
    private static void loadSampleData() {
        Employee e1 = new Employee(nextEmpId++, "Rahul Sharma", "rahul.sharma@company.com", 
                                   "9876543210", "IT", "Senior Developer", 75000, 15000, 10000, 12000, 5000, 
                                   LocalDate.of(2020, 1, 15));
        employees.add(e1);
        
        Employee e2 = new Employee(nextEmpId++, "Priya Patel", "priya.patel@company.com", 
                                   "9876543211", "HR", "HR Manager", 65000, 13000, 8000, 10000, 4000, 
                                   LocalDate.of(2019, 3, 10));
        employees.add(e2);
        
        Employee e3 = new Employee(nextEmpId++, "Amit Kumar", "amit.kumar@company.com", 
                                   "9876543212", "SALES", "Sales Executive", 50000, 10000, 6000, 8000, 3000, 
                                   LocalDate.of(2021, 6, 20));
        employees.add(e3);
        
        Employee e4 = new Employee(nextEmpId++, "Neha Gupta", "neha.gupta@company.com", 
                                   "9876543213", "FINANCE", "Accountant", 55000, 11000, 7000, 9000, 3500, 
                                   LocalDate.of(2020, 8, 5));
        employees.add(e4);
        
        Employee e5 = new Employee(nextEmpId++, "Vikram Singh", "vikram.singh@company.com", 
                                   "9876543214", "OPERATIONS", "Operations Manager", 70000, 14000, 9000, 11000, 4500, 
                                   LocalDate.of(2018, 11, 12));
        employees.add(e5);
    }
    
    private static void addDemoEmployee() {
        System.out.println("Adding new employee: John Doe");
        Employee emp = new Employee(nextEmpId++, "John Doe", "john.doe@company.com", 
                                   "9999999999", "IT", "Software Engineer", 60000, 12000, 8000, 10000, 4000, 
                                   LocalDate.now());
        employees.add(emp);
        System.out.println("Employee added successfully");
        System.out.println("Employee ID: " + emp.getId());
        System.out.println("Net Salary: " + moneyFormat.format(emp.calculateNetSalary()));
    }
    
    private static void searchByID(int id) {
        System.out.println("\nSearching for employee with ID: " + id);
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.println("Employee Found:");
                System.out.println("  Name: " + emp.getName());
                System.out.println("  Department: " + emp.getDepartment());
                System.out.println("  Position: " + emp.getPosition());
                System.out.println("  Net Salary: " + moneyFormat.format(emp.calculateNetSalary()));
                return;
            }
        }
        System.out.println("Employee not found");
    }
    
    private static void searchByName(String name) {
        System.out.println("\nSearching for employee with name containing: " + name);
        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println("  Found: " + emp.getName() + " - " + emp.getDepartment());
                found = true;
            }
        }
        if (!found) System.out.println("No employees found");
    }
    
    private static void searchByDepartment(String dept) {
        System.out.println("\nSearching for employees in department: " + dept);
        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getDepartment().equalsIgnoreCase(dept)) {
                System.out.println("  " + emp.getName() + " - " + emp.getPosition());
                found = true;
            }
        }
        if (!found) System.out.println("No employees found in " + dept);
    }
    
    private static void processPayrollDemo() {
        System.out.println("Processing payroll for current month: " + YearMonth.now());
        
        for (Employee emp : employees) {
            PayrollRecord record = new PayrollRecord(nextPayrollId++, emp, YearMonth.now(), LocalDate.now());
            payrollRecords.add(record);
            System.out.println("\nProcessed payroll for: " + emp.getName());
            System.out.println("  Gross Salary: " + moneyFormat.format(record.getGrossSalary()));
            System.out.println("  Deductions: " + moneyFormat.format(record.getTotalDeductions()));
            System.out.println("  Net Salary: " + moneyFormat.format(record.getNetSalary()));
        }
        System.out.println("\nPayroll processed successfully for " + employees.size() + " employees");
    }
    
    private static void updateEmployeeDemo() {
        System.out.println("Updating employee with ID 1002 (Priya Patel)");
        for (Employee emp : employees) {
            if (emp.getId() == 1002) {
                System.out.println("Before update:");
                System.out.println("  Position: " + emp.getPosition());
                System.out.println("  Basic Salary: " + moneyFormat.format(emp.getBasicSalary()));
                
                emp.setPosition("Senior HR Manager");
                emp.setBasicSalary(75000);
                emp.setHra(15000);
                
                System.out.println("\nAfter update:");
                System.out.println("  Position: " + emp.getPosition());
                System.out.println("  Basic Salary: " + moneyFormat.format(emp.getBasicSalary()));
                System.out.println("  Net Salary: " + moneyFormat.format(emp.calculateNetSalary()));
                break;
            }
        }
    }
    
    private static void deleteEmployeeDemo() {
        System.out.println("Deleting employee with ID 1003 (Amit Kumar)");
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.getId() == 1003) {
                System.out.println("Removing employee: " + emp.getName());
                iterator.remove();
                System.out.println("Employee deleted successfully");
                break;
            }
        }
    }
    
    private static void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found");
            return;
        }
        
        System.out.println("\nEMPLOYEE DIRECTORY");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("%-8s %-20s %-12s %-18s %-15s %-15s%n", 
                         "ID", "Name", "Department", "Position", "Basic Salary", "Net Salary");
        System.out.println("----------------------------------------------------------------------------------------");
        
        for (Employee emp : employees) {
            System.out.printf("%-8d %-20s %-12s %-18s %-15s %-15s%n",
                             emp.getId(), 
                             truncate(emp.getName(), 20),
                             emp.getDepartment(),
                             truncate(emp.getPosition(), 18),
                             moneyFormat.format(emp.getBasicSalary()),
                             moneyFormat.format(emp.calculateNetSalary()));
        }
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Total Employees: " + employees.size());
    }
    
    private static void viewAllPayrollRecords() {
        if (payrollRecords.isEmpty()) {
            System.out.println("No payroll records found");
            return;
        }
        
        System.out.println("\nALL PAYROLL RECORDS");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("%-8s %-8s %-20s %-12s %-15s %-15s %-12s%n",
                         "Rec ID", "Emp ID", "Employee", "Month", "Gross", "Deductions", "Net Salary");
        System.out.println("----------------------------------------------------------------------------------------");
        
        for (PayrollRecord record : payrollRecords) {
            System.out.printf("%-8d %-8d %-20s %-12s %-15s %-15s %-12s%n",
                             record.getId(),
                             record.getEmployee().getId(),
                             truncate(record.getEmployee().getName(), 20),
                             record.getPayrollMonth().getMonth(),
                             moneyFormat.format(record.getGrossSalary()),
                             moneyFormat.format(record.getTotalDeductions()),
                             moneyFormat.format(record.getNetSalary()));
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }
    
    private static void calculateDepartmentStats() {
        System.out.println("\nDEPARTMENT STATISTICS");
        System.out.println("----------------------------------------------------------------------------------------");
        
        Map<String, DepartmentStats> stats = new HashMap<>();
        
        for (Employee emp : employees) {
            String dept = emp.getDepartment();
            stats.putIfAbsent(dept, new DepartmentStats(dept));
            stats.get(dept).addEmployee(emp);
        }
        
        System.out.printf("%-15s %-10s %-20s %-20s %-20s%n",
                         "Department", "Count", "Total Salary", "Average Salary", "Highest Salary");
        System.out.println("----------------------------------------------------------------------------------------");
        
        for (DepartmentStats stat : stats.values()) {
            System.out.printf("%-15s %-10d %-20s %-20s %-20s%n",
                             stat.getName(),
                             stat.getCount(),
                             moneyFormat.format(stat.getTotalSalary()),
                             moneyFormat.format(stat.getAverageSalary()),
                             moneyFormat.format(stat.getHighestSalary()));
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }
    
    private static void generateFullReport() {
        System.out.println("\nCOMPLETE PAYROLL SYSTEM REPORT");
        System.out.println("Generated on: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("----------------------------------------------------------------------------------------");
        
        System.out.println("\nCOMPANY OVERVIEW");
        System.out.println("--------------------------------------------------");
        System.out.println("Total Employees: " + employees.size());
        System.out.println("Total Payroll Processed: " + payrollRecords.size() + " records");
        
        double totalGrossPaid = 0;
        double totalDeductions = 0;
        for (PayrollRecord record : payrollRecords) {
            totalGrossPaid += record.getGrossSalary();
            totalDeductions += record.getTotalDeductions();
        }
        
        System.out.println("Total Gross Salary Paid: " + moneyFormat.format(totalGrossPaid));
        System.out.println("Total Deductions: " + moneyFormat.format(totalDeductions));
        System.out.println("Total Net Salary Paid: " + moneyFormat.format(totalGrossPaid - totalDeductions));
        
        viewAllEmployees();
        calculateDepartmentStats();
        
        System.out.println("\nSYSTEM SUMMARY");
        System.out.println("--------------------------------------------------");
        System.out.println("Employee Management: Active");
        System.out.println("Payroll Processing: Active");
        System.out.println("Report Generation: Active");
        System.out.println("\nEnd of Report");
    }
    
    private static void viewPayrollByMonth() {
        YearMonth lastMonth = YearMonth.now().minusMonths(1);
        System.out.println("\nPayroll records for: " + lastMonth.getMonth() + " " + lastMonth.getYear());
        
        boolean found = false;
        for (PayrollRecord record : payrollRecords) {
            if (record.getPayrollMonth().equals(lastMonth)) {
                System.out.println("  Employee: " + record.getEmployee().getName());
                System.out.println("  Net Salary: " + moneyFormat.format(record.getNetSalary()));
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No payroll records found for " + lastMonth.getMonth() + " " + lastMonth.getYear());
            System.out.println("Showing current month payroll instead:");
            for (PayrollRecord record : payrollRecords) {
                if (record.getPayrollMonth().equals(YearMonth.now())) {
                    System.out.println("  Employee: " + record.getEmployee().getName());
                    System.out.println("  Net Salary: " + moneyFormat.format(record.getNetSalary()));
                }
            }
        }
    }
    
    private static String truncate(String str, int length) {
        if (str == null) return "";
        if (str.length() <= length) return str;
        return str.substring(0, length - 3) + "...";
    }
}

// ==================== EMPLOYEE CLASS ====================
class Employee {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String department;
    private String position;
    private double basicSalary;
    private double hra;
    private double da;
    private double tax;
    private double otherDeductions;
    private LocalDate joiningDate;
    private boolean isActive;
    
    public Employee(int id, String name, String email, String phone, String department, 
                   String position, double basicSalary, double hra, double da, 
                   double tax, double otherDeductions, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.position = position;
        this.basicSalary = basicSalary;
        this.hra = hra;
        this.da = da;
        this.tax = tax;
        this.otherDeductions = otherDeductions;
        this.joiningDate = joiningDate;
        this.isActive = true;
    }
    
    public double calculateGrossSalary() {
        return basicSalary + hra + da;
    }
    
    public double calculateTotalDeductions() {
        return tax + otherDeductions;
    }
    
    public double calculateNetSalary() {
        return calculateGrossSalary() - calculateTotalDeductions();
    }
    
    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }
    public double getHra() { return hra; }
    public void setHra(double hra) { this.hra = hra; }
    public double getDa() { return da; }
    public void setDa(double da) { this.da = da; }
    public double getTax() { return tax; }
    public void setTax(double tax) { this.tax = tax; }
    public double getOtherDeductions() { return otherDeductions; }
    public void setOtherDeductions(double otherDeductions) { this.otherDeductions = otherDeductions; }
    public LocalDate getJoiningDate() { return joiningDate; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}

// ==================== PAYROLL RECORD CLASS ====================
class PayrollRecord {
    private int id;
    private Employee employee;
    private YearMonth payrollMonth;
    private LocalDate processedDate;
    private double grossSalary;
    private double totalDeductions;
    private double netSalary;
    
    public PayrollRecord(int id, Employee employee, YearMonth payrollMonth, LocalDate processedDate) {
        this.id = id;
        this.employee = employee;
        this.payrollMonth = payrollMonth;
        this.processedDate = processedDate;
        this.grossSalary = employee.calculateGrossSalary();
        this.totalDeductions = employee.calculateTotalDeductions();
        this.netSalary = employee.calculateNetSalary();
    }
    
    public int getId() { return id; }
    public Employee getEmployee() { return employee; }
    public YearMonth getPayrollMonth() { return payrollMonth; }
    public double getGrossSalary() { return grossSalary; }
    public double getTotalDeductions() { return totalDeductions; }
    public double getNetSalary() { return netSalary; }
}

// ==================== DEPARTMENT STATISTICS CLASS ====================
class DepartmentStats {
    private String name;
    private int count;
    private double totalSalary;
    private double highestSalary;
    
    public DepartmentStats(String name) {
        this.name = name;
        this.count = 0;
        this.totalSalary = 0;
        this.highestSalary = 0;
    }
    
    public void addEmployee(Employee emp) {
        count++;
        double salary = emp.calculateNetSalary();
        totalSalary += salary;
        if (salary > highestSalary) {
            highestSalary = salary;
        }
    }
    
    public String getName() { return name; }
    public int getCount() { return count; }
    public double getTotalSalary() { return totalSalary; }
    public double getAverageSalary() { return count > 0 ? totalSalary / count : 0; }
    public double getHighestSalary() { return highestSalary; }
}