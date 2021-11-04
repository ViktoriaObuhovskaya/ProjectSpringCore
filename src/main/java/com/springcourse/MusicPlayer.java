package com.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {

    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    private Music rockMusic;
    private Music classicalMusic;
    private Music popMusic;

    @Autowired
    public MusicPlayer(Music rockMusic, Music classicalMusic, Music popMusic) {
        this.rockMusic = rockMusic;
        this.classicalMusic = classicalMusic;
        this.popMusic = popMusic;
    }

    public void playMusic() {
        int play = (int) (Math.random() * 3 + 1);
        if (play == 1) {
            System.out.println("Playing: " + classicalMusic.getSong());
        } else if (play == 2) {
            System.out.println("Playing: " + rockMusic.getSong());
        } else if (play == 3) {
            System.out.println("Playing: " + popMusic.getSong());
        }
    }
}
