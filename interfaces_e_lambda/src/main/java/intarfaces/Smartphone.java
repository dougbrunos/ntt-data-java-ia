package intarfaces;

public class Smartphone implements MusicPlayer, VideoPlayer {

    @Override
    public void playMusic() {
        System.out.println("Smartphone playing music");
    }

    @Override
    public void pauseMusic() {
        System.out.println("Smartphone pausing music");
    }

    @Override
    public void stopMusic() {
        System.out.println("Smartphone stopping music");
    }

    @Override
    public void playVideo() {
        System.out.println("Smartphone playing video");
    }

    @Override
    public void pauseVideo() {
        System.out.println("Smartphone pausing video");
    }

    @Override
    public void stopVideo() {
        System.out.println("Smartphone stopping video");
    }
    
}
