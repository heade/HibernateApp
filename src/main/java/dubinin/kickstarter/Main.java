package dubinin.kickstarter;

import dubinin.kickstarter.Menu.Menu;

import java.sql.SQLException;

/**
 * Created by Daniel on 28.02.2016.
 */
public class Main {
    public static void main(String[] args) throws SQLException{
        Menu menu = new Menu();
        menu.run();
    }
}
