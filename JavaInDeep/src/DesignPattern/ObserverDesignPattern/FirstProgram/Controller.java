package DesignPattern.ObserverDesignPattern.FirstProgram;

public class Controller {
    public static void main(String[] args) {
        Subject channel = new YoutubeChannel("youtube channel - lets code");
        Observer ajit = new Subscriber("ajit");
        Observer shivam = new Subscriber("shivam");

        channel.subscribe(ajit);
        channel.subscribe(shivam);

        channel.newVideoUploaded("java basic");
        channel.newVideoUploaded("java advanced");

    }
}
