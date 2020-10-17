package org.academiadecodigo.bitjs.enemy;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Mari extends MCS {
    int correctAnswer;

    public Mari(){
        super(new Picture(330,360, "resources/mari_face.png"), new Rectangle(330,360,50,50));
        this.correctAnswer = 1;
    }
    public void makeQuestion() {
        super.makeQuestion((new Picture(10,10,"resources/MARIBATTLEFINAL.png")));
    }
    public int getCorrectAnswer() {
        return 2;
    }
}

