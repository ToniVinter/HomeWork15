package ro.fasttrackit.plannerApp;
import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DailyPlanner dailyPlanner = new DailyPlanner();
        Menu menu = new Menu(dailyPlanner);
        menu.run();

//        String asciiArt = FigletFont.convertOneLine("Hello Mave");
//        System.out.println(asciiArt);

    }

}
