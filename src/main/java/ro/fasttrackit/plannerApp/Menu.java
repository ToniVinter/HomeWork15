package ro.fasttrackit.plannerApp;
import com.github.lalyos.jfiglet.FigletFont;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private final DailyPlanner dailyPlanner;

    public Menu(DailyPlanner dailyPlanner) {
        this.dailyPlanner = dailyPlanner;

    }

    public void run() throws IOException {
        int input = 0;
        do{
            printMainMenu();
            input = getInput();
            executeInput(input);
        }while(input!=0);
    }

    private void printMainMenu() throws IOException {
        System.out.println(FigletFont.convertOneLine("Planner App"));
        System.out.println("1. List all current activities for a day \n" );
        System.out.println("2. Add Activity \n");
        System.out.println("3. Remove Activity \n");
        System.out.println("4. End planning \n");
        System.out.println("0. Exit \n");
    }

    private int getInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your option: ");
        return scanner.nextInt();
    }

    private void executeInput(int input){
        switch (input){
            case 1:
                GetAllActivities();
                break;
            case 2:
                addActivity();
                break;
            case 3:
                removeActivity();
                break;
            case 4:
                endPlanning();
                break;
            default:
        }
    }

    private void endPlanning() {
        System.out.println(dailyPlanner.endPlanning());
    }

    private void addActivity() {
        System.out.println("Choose your day: ");
        Days day = Days.valueOf(new Scanner(System.in).nextLine());
        System.out.println("Choose your activity: ");
        String activity = new Scanner(System.in).nextLine();
        dailyPlanner.addActivity(day,activity);
    }

    private void removeActivity() {
        System.out.println("Choose your day: ");
        Days day = Days.valueOf(new Scanner(System.in).nextLine());
        System.out.println("Choose your activity: ");
        String activity = new Scanner(System.in).nextLine();
        dailyPlanner.removeActivity(day,activity);
    }

    private void GetAllActivities() {
        System.out.println("Choose your day to see activities: ");
        Days day = Days.valueOf(new Scanner(System.in).nextLine());

        System.out.println(dailyPlanner.getActivities(day));
    }



}
