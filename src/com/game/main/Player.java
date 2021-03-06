package com.game.main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject{

    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        y = Game.clamp(y, 0, Game.HEIGHT - 72);
        x = Game.clamp(x, 0, Game.WIDTH - 48);

        collision();
    }

    public void collision() {
        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.BasicEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.HEALTH -= 2;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {

//        Graphics2D g2d = (Graphics2D) g;
//        g.setColor(Color.red);
//        g2d.draw(getBounds());

        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y,32,32);
    }
}
