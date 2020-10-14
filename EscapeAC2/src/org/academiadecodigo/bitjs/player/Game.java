package org.academiadecodigo.bitjs.player;

import org.academiadecodigo.bitjs.enemy.MCS;
import org.academiadecodigo.bitjs.enemy.Question;
import org.academiadecodigo.bitjs.enemy.Ricardo;
import org.academiadecodigo.bitjs.rooms.MacRoom;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game implements KeyboardHandler {

        private Picture movable;
        private Player player;
        private MacRoom macRoom;
        public boolean areCollided;
        private Picture quiz;
        private Question question;
        private Ricardo ricardo;

        KeyboardEvent left = new KeyboardEvent();
        KeyboardEvent right = new KeyboardEvent();
        KeyboardEvent down = new KeyboardEvent();
        KeyboardEvent up = new KeyboardEvent();
        KeyboardEvent one = new KeyboardEvent();
        KeyboardEvent two = new KeyboardEvent();
        KeyboardEvent three = new KeyboardEvent();

        public Game() {

        }

        public void startLevel1(){
            macRoom = new MacRoom();
            macRoom.getPicture().draw();
            player = new Player(200,200);
            player.getFace().draw();
            player.getRectangle().draw();
            ricardo = new Ricardo();
            ricardo.getRectangle().draw();
            ricardo.getFace().draw();
            movable = player.getFace();
            moves();
            ricardo.makeQuestion(Question.QUESTION1);

            while (true){




                if (collide(player.getRectangle(),ricardo.getRectangle())){




                    return;
                }

    if(player.getRectangle().getX()+player.getRectangle().getWidth() > 435 && player.getRectangle().getY()+player.getRectangle().getWidth() == 180){
        Rectangle quiz = new Rectangle(300,300,150,150);

        quiz.fill();
        return;
    }

}
        }

        public void startLevel2(){
            macRoom.getPicture().delete();

        }

        public void chooseAnswer(){
            Keyboard keyboard = new Keyboard(this);

            one.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            one.setKey(KeyboardEvent.KEY_1);
            keyboard.addEventListener(one);

            two.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            two.setKey(KeyboardEvent.KEY_2);
            keyboard.addEventListener(two);

            three.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            three.setKey(KeyboardEvent.KEY_3);
            keyboard.addEventListener(three);

        }

        public void moves(){
            Keyboard keyboard = new Keyboard(this);

            down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            down.setKey(KeyboardEvent.KEY_DOWN);
            keyboard.addEventListener(down);

            up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            up.setKey(KeyboardEvent.KEY_UP);
            keyboard.addEventListener(up);

            right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            right.setKey(KeyboardEvent.KEY_RIGHT);
            keyboard.addEventListener(right);

            left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            left.setKey(KeyboardEvent.KEY_LEFT);
            keyboard.addEventListener(left);

        }

        public void moving(KeyboardEvent keyboardEvent) {

                if (keyboardEvent == down && movable.getY() < 435) {

                    if (collide(player.getRectangle(),ricardo.getRectangle())){
                        player.moveUp();
                        player.moveUp();
                    }
                    player.moveDown();
                }
                if (keyboardEvent == up && movable.getY() > 30) {
                    if (collide(player.getRectangle(),ricardo.getRectangle())){
                        player.moveDown();
                        player.moveDown();
                    }
                    player.moveUp();
                }
                if (keyboardEvent == right && movable.getX() < 435) {
                    if (collide(player.getRectangle(),ricardo.getRectangle())){
                       player.moveRight();
                        return;
                    }
                    player.moveRight();
                }
                if (keyboardEvent == left && movable.getX() > 30){

                    if (collide(player.getRectangle(),ricardo.getRectangle())){
                        player.moveRight();
                        return;
                    }
                    player.moveLeft();
                }

            }


        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {
            moving(keyboardEvent);
        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {}


        public boolean collide(Rectangle r1, Rectangle r2){
            if(r1.getX() > r2.getX()+ r2.getWidth() || r1.getX()+ r1.getWidth() < r2.getX() || r1.getY() > r2.getY() + r2.getHeight() || r1.getY()+ r1.getHeight() < r2.getY()){
                return false;
            }
                return true;
        }


}
