package com.game.main;

import java.awt.*;

public class Trail extends GameObject{

    private float alpha = 1;
    private Handler handler;
    private Color color;
    private int width;
    private int height;
    private double life;

    public Trail(int x, int y, ID id, Color color, Handler handler, int width, int height, double life) {
        super(x, y, id);
        this.color = color;
        this.width = width;
        this.handler = handler;
        this.height = height;
        this.life = life;
    }

    @Override
    public void tick() {
        if(alpha > life) {
            alpha -= life - 0.001;
        } else {
            handler.removeObject(this);
        }
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g2d.setComposite(makeTransparent(1));
    }

    private AlphaComposite makeTransparent(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
