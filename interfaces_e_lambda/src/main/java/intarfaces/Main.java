package intarfaces;

public class Main {
    public static void main(String[] args) {
        /* 
        String music = MusicPlayer.music;
        System.out.println(music);
        
        var musicPlayer = new MusicPlayer() {
            @Override
            public void playMusic() {
                System.out.println("Playing music");
            }

            @Override
            public void pauseMusic() {
                System.out.println("Music paused");
            }

            @Override
            public void stopMusic() {
                System.out.println("Music stopped");
            }
        };
        musicPlayer.playMusic();
        musicPlayer.pauseMusic();
        musicPlayer.stopMusic();
        */
        var smartphone = new Smartphone();
        smartphone.playMusic();
        smartphone.pauseMusic();
        smartphone.stopMusic();
        smartphone.playVideo();
        smartphone.pauseVideo();
        smartphone.stopVideo();
    }
}