import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PortalAluno{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> alunos= new TreeSet<Integer>();
        String courses[] = {"A","B", "C"};
        for (String course:courses) {
            System.out.println("How many students for course " + course + ": ");
            Integer amount = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < amount; i++) {
                System.out.println("Type an students number");
                alunos.add(Integer.parseInt(scanner.nextLine()));
            }
        }
        System.out.println("Total de estudantes: " + alunos.size());
    }

}