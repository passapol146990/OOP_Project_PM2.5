public class Run {
    public static void main(String[] args){
        App app = new App("PM2.5");

        MenuPage menu = new MenuPage(app);
        StartPage startPage = new StartPage(app);
        app.addPanel(menu,"menu");
        app.addPanel(startPage,"start");
    }
}
