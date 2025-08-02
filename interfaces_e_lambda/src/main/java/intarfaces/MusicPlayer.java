package intarfaces;

public interface MusicPlayer {

    // Todas as propriedades da Intarface são implicitamente públicas, estáticas e finais
    // Portanto, não é necessário declarar o modificador de acesso
    // String music = "Parabéns pra você"; //

    void playMusic();

    void pauseMusic();

    void stopMusic();

}
