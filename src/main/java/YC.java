import java.util.Scanner;
public class YC {
    public static void main(String[] args) {
        String bot_Name = "YC";
        Scanner scanner = new Scanner(System.in);
        String userCommand;
        String[] commandList = new String[100];
        int totalCommands = 0;

        System.out.println("\t" + "____________________________________________________________");
        System.out.println("\t" + "Hello! I'm " + bot_Name);
        System.out.println("\t" + "What can I do for you?");
        System.out.println("\t" + "____________________________________________________________" + "\n");

        while (true) {
            userCommand = scanner.nextLine();
            if (userCommand.equalsIgnoreCase("bye")) {
                System.out.println("\t" + "____________________________________________________________");
                System.out.println("\t" + "Bye. Hope to see you again soon!");
                System.out.println("\t" + "____________________________________________________________" + "\n");
                break;
            }
            if (userCommand.equalsIgnoreCase("list")) {
                System.out.println("\t" + "____________________________________________________________");
                for  (int i = 0; i < totalCommands; i++) {
                    System.out.println("\t" + (i+1) + ". "+ commandList[i]);
                }
                System.out.println("\t" + "____________________________________________________________" + "\n");
            }
            else {
                commandList[totalCommands] = userCommand;
                totalCommands++;
                System.out.println("\t" + "____________________________________________________________");
                System.out.println("\t" + "added: " + userCommand + "\n");
                System.out.println("\t" + "____________________________________________________________" + "\n");
            }

        }
    }
}
