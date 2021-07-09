package com.game.main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject{

    Random r = new Random();

    public Player(int x, int y, ID id) {
        super(x, y, id);

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        y = Game.clamp(y, 0, Game.HEIGHT - 72);
        x = Game.clamp(x, 0, Game.WIDTH - 48);

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }
}
