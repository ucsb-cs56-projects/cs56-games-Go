import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

class MyButton extends JButton
{
    private Color color;
    private boolean oval=false;
    public void drawSomething(Color color) {
        oval = true;
        this.color = color;
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g)
    {
        if (getModel().isPressed()) {
         // disable color button background/foreground change when mouse pressed
        }
        else if (oval) {
            g.setColor(color);
            g.fillOval(getHorizontalAlignment(), getVerticalAlignment(), getWidth(), getHeight());
            System.out.println("OK3");
        }
        else {
            super.paintComponent(g);
        }
    }
}
