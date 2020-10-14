package org.academiadecodigo.bitjs.enemy;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

abstract public class MCS {

    private Picture face;
    private Rectangle rectangle;
    private Picture picture;


    public MCS(Picture face, Rectangle rectangle){
        this.face = face;
        this.rectangle = rectangle;

    }


    public void makeQuestion(Question question,Text ans1,Text ans2,Text ans3,Picture picture) {
            this.picture = picture;
            picture.draw();
            Text questionMc = new Text(10, 10, question.getQuestion());
            questionMc.setColor(Color.WHITE);
            questionMc.draw();

            ans1.setColor(Color.WHITE);
            ans2.setColor(Color.WHITE);
            ans3.setColor(Color.WHITE);
            ans1.grow(10,10);

            ans1.draw();
            ans2.draw();
            ans3.draw();

}



    public Picture getFace() {
        return face;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }




}
