import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CheckSalaryFunctions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat formatDouble = new DecimalFormat("#.00");
        String path = "C:\\Users\\Jose\\Desktop\\aulas_gubee\\Funcional_e_Lambda_Secao20\\src\\salaryInput.txt";
        List<People> peopleList = new ArrayList<>();


        System.out.println("Type the desired salary");
        String salaryString = scan.nextLine();
        Double salary = Double.parseDouble(salaryString);

        // Turn input file into a list
        try {

            BufferedReader br = new BufferedReader(new FileReader(path));

            String line = br.readLine();
            do {
                String[] splitedLine = line.split(",");
                peopleList.add(
                        new People(
                                splitedLine[0],
                                splitedLine[1].trim(),
                                Integer.parseInt(splitedLine[2].trim()
                                )));
                line = br.readLine();
            } while (line != null);


        } catch (Exception e) {
            System.out.println("ERROR---------ERROR\n" + e + "ERROR---------ERROR\n");
        }


        //print people whose salary is more the the salary informed by the user
        System.out.println("People whose salary is more then " + formatDouble.format(salary) +": ");
        peopleList.stream()
                .filter(i -> i.getSalary() > salary)
                .forEach(person -> System.out.println(person.getEmail()));

        //print sum of the salary of the people whose name starts with the letter 'M'
        Double sumOfSalaries = peopleList.stream()
                .filter(person -> person.getNome().charAt(0) == 'M')
                .collect(Collectors.summingDouble(person -> person.getSalary()));
        System.out.println("Sum of the salary of the people whose name starts with the letter 'M' :" + formatDouble.format(sumOfSalaries) );

    }
}
