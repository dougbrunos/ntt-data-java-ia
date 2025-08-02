package intarfaces;

public record MusicBox(String music, boolean isPaused) implements MusicPlayer {
    @Override
    public void playMusic() {
        System.out.println("Playing music: " + music);
    }

    @Override
    public void pauseMusic() {
        System.out.println("Music paused: " + music);
    }

    @Override
    public void stopMusic() {
        System.out.println("Music stopped: " + music);
    }
}
