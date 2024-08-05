public class EmployeeBook {

    private Employee[] employees = new Employee[10];

    public boolean addEmployee(Employee employee) {
        boolean isDone = false;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null || employees[i].getId() == 0) {
                employees[i] = employee;
                isDone = true;
                break;
            }
        }
        return isDone;
    }

    public boolean deleteEmployee(int id) {
        boolean isDone = false;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
                isDone = true;
            }
        }
        return isDone;
    }

    public Employee getEmployee(int id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void viewAll() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.toString());
            }
        }
        System.out.println();
    }

    public double monthSum() {
        double sum = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public Employee minSalaryEmployee() {
        double min = Double.MAX_VALUE;
        Employee minSalaryEmployee = null;

        for (Employee employee : employees) {
            if (employee != null && min > employee.getSalary()) {
                min = employee.getSalary();
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public Employee maxSalaryEmployee() {
        double max = Double.MIN_VALUE;
        Employee maxSalaryEmployee = null;

        for (Employee employee : employees) {
            if (employee != null && max < employee.getSalary()) {
                max = employee.getSalary();
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public double averageSalary() {
        return monthSum() / employees.length;
    }

    public void printFullName() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getLastName() + " " + employee.getLastName() + " " + employee.getLastName());
            }
        }
    }

    public void indexTheSalary(int arg) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * (1 + (double) arg / 100));
            }
        }
    }

    public Employee minSalaryDepartment(int departmentNumber) {
        double min = Double.MAX_VALUE;
        Employee minSalaryInDep = null;

        for (Employee employee : employees) {
            if (employee != null && departmentNumber == employee.getDepartment() && min > employee.getSalary()) {
                min = employee.getSalary();
                minSalaryInDep = employee;
            }
        }
        return minSalaryInDep;
    }

    public Employee maxSalaryDepartment(int departmentNumber) {
        double max = Double.MIN_VALUE;
        Employee maxSalaryInDep = null;

        for (Employee employee : employees) {
            if (employee != null && departmentNumber == employee.getDepartment() && max < employee.getSalary()) {
                max = employee.getSalary();
                maxSalaryInDep = employee;
            }
        }
        return maxSalaryInDep;
    }

    public double sumSalaryDepartment(int departmentNumber) {
        double sum = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                sum += departmentNumber == employee.getDepartment() ? employee.getSalary() : 0;
            }
        }
        return sum;
    }

    public double averageSalaryDepartment(int departmentNumber) {
        int count = 0;

        for (Employee employee : employees) {
            if (employee != null) {
                count += departmentNumber == employee.getDepartment() ? 1 : 0;
            }
        }
        return sumSalaryDepartment(departmentNumber) / count;
    }

    public void indexTheSalaryDepartment(int departmentNumber, int arg) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (departmentNumber == employee.getDepartment()) {
                    employee.setSalary(employee.getSalary() * (1 + (double) arg / 100));
                }
            }
        }
    }

    public void printEmployeesDeportment(int departmentNumber) {
        System.out.println("Сотрудники отдела №" + departmentNumber + ":");

        for (Employee employee : employees) {
            if (employee != null && departmentNumber == employee.getDepartment()) {
                System.out.printf("    " + employee.getId() + " " + employee.getLastName() + " " + employee.getFirstName() +
                        " " + employee.getPatronymic() + ", ЗП= %.2f%n", employee.getSalary());
            }
        }
        System.out.println();
    }

    public void printSalaryIsLess(int parameter) {
        boolean isNone = true;
        System.out.println("Сотрудники с ЗП меньше " + parameter + ":");

        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < parameter) {
                System.out.printf("    " + employee.getId() + " " + employee.getLastName() + " " + employee.getFirstName() +
                        " " + employee.getPatronymic() + ", ЗП= %.2f%n", employee.getSalary());
                isNone = false;
            }
        }
        if (isNone) {
            System.out.println("    Таких сотрудников нет");
        }
        System.out.println();
    }

    public void printSalaryIsMore(int parameter) {
        boolean isNone = true;
        System.out.println("Сотрудники с ЗП больше " + parameter + ":");

        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= parameter) {
                System.out.printf("    " + employee.getId() + " " + employee.getLastName() + " " + employee.getFirstName() +
                        " " + employee.getPatronymic() + ", ЗП= %.2f%n", employee.getSalary());
                isNone = false;
            }
        }
        if (isNone) {
            System.out.println("    Таких сотрудников нет");
        }
        System.out.println();
    }
}

