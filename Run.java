// class รันโปรแกรม จะใช้งานต้องรันผ่านไฟล์นี้เท่านั้น เพื่อไม่ให้เกิน error
public class Run {
    public static void main(String[] args){
        App app = new App("PM2.5");

        PageMenu menu = new PageMenu(app);
        PageStart startPage = new PageStart(app);
        PageAbout aboutPage = new PageAbout(app);   
        app.addPanel(menu,"menu");
        app.addPanel(startPage,"start");
        app.addPanel(aboutPage,"about");
    }
}
