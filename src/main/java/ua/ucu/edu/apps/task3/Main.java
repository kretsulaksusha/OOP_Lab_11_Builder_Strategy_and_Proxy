package ua.ucu.edu.apps.task3;

public class Main {
    public static void main(String[] args) {
        MyImage myImage = new ProxyImage("src/main/java/ua/ucu/edu/apps/task3/japan_fuji.jpg");
        myImage.display();
    }
}
