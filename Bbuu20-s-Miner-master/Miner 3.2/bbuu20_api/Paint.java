package scripts.bbuu20_api;

import org.tribot.api2007.Skills;
import org.tribot.api2007.Skills.SKILLS;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Paint {
    private static Color completeColor = new Color(0,155,0,75);
    private static Color incompleteColor = new Color(155,0,0,75);
    private static Color fontColor = Color.BLACK;
    private static Font font = new Font("Arial",12,12);
    public static BufferedImage getProgressBar(SKILLS skill, int width, int height, boolean vertical) {
        final BufferedImage i = new BufferedImage(width,height,BufferedImage.TYPE_4BYTE_ABGR);
        //Create graphics from the bufferedImage
        Graphics g = i.getGraphics();
        float complete = 0;
        if(vertical) {
            complete = getPercentAsFloat(skill, height);
        }
        else {
            complete = getPercentAsFloat(skill, width);
        }		//Fill in the completed part of the bar
        g.setColor(completeColor);
        if(vertical) {
            g.fillRect(0, (int) (height - complete), width, (int) complete);
        }
        else {
            g.fillRect(0, 0, (int) complete, height);
        }
        //Fill in incomplete part of the bar
        g.setColor(incompleteColor);
        if(vertical) {
            g.fillRect(0, 0, width, (int) (height-complete));
        }
        else {
            g.fillRect((int) complete + 1, 0, (int) (width-complete), height);
        }
        //Surround in black bars
        g.setColor(Color.black);
        if(vertical) {
            g.drawLine(0,(int) (height-complete),width,(int) (height-complete));
        }
        else {
            g.drawLine((int)complete, 0, (int)complete,height);
        }
        g.drawRect(0, 0, width-1,height-1);
        return i;
    }
    public static BufferedImage getProgressBar(SKILLS skill, int startXP, int width, int height, boolean vertical){
        final BufferedImage i = new BufferedImage(width,height,BufferedImage.TYPE_4BYTE_ABGR);
        //Create graphics from the bufferedImage
        Graphics g = i.getGraphics();
        float complete = 0;
        if(vertical) {
            complete = getPercentAsFloat(skill, height);
        }
        else {
            complete = getPercentAsFloat(skill, width);
        }
        //Fill in the completed part of the bar
        g.setColor(completeColor);
        if(vertical) {
            g.fillRect(0, (int) (height - complete), width, (int) complete);
        }
        else {
            g.fillRect(0, 0, (int) complete, height);
        }
        //Fill in incomplete part of the bar
        g.setColor(incompleteColor);
        if(vertical) {
            g.fillRect(0, 0, width, (int) (height-complete));
        }
        else {
            g.fillRect((int) complete + 1, 0, (int) (width-complete), height);
        }
        //Surround in black bars
        g.setColor(Color.black);
        if(vertical) {
            g.drawLine(0,(int) (height-complete),width,(int) (height-complete));
        }
        else {
            g.drawLine((int)complete, 0, (int)complete,height);
        }
        g.drawRect(0, 0, width-1,height-1);
        //Draw Text
        g.setFont(font);
        g.setColor(fontColor);
        String text = null;
        if(vertical) {
            text = getPercentAsInteger(skill) + "% to level " + (Skills.getActualLevel(skill) + 1);
            int textSize = (g.getFontMetrics().getHeight())*text.length();
            int y = (height/2)-(textSize/2);
            for(String s : text.split("")) {
                g.drawString(s, (width/2)-(g.getFontMetrics().stringWidth(s)/2), y);
                y+=g.getFontMetrics().getHeight();
            }
        }
        else {
            text = getPercentAsInteger(skill) + "% to level " + (Skills.getActualLevel(skill) + 1) + "(+" + (Skills.getActualLevel(skill) - Skills.getLevelByXP(startXP) + ")");
            g.drawString(text, (width/2)-(g.getFontMetrics().stringWidth(text)/2), (height/2)+(g.getFontMetrics().getHeight()/3));
        }
        return i;
    }
    private static float getPercentAsFloat(SKILLS skill, int size) {
        float low, mid, high;
        if(Skills.getActualLevel(skill) >=99) {
            return size;
        }
        low = Skills.getXPByLevel(Skills.getActualLevel(skill));
        mid = Skills.getXP(skill);
        high = Skills.getXPByLevel(Skills.getActualLevel(skill) + 1);
        return size*((mid - low)/(high-low));
    }
    private static int getPercentAsInteger(SKILLS skill) {
        float low, mid, high;
        low = Skills.getXPByLevel(Skills.getActualLevel(skill));
        mid = Skills.getXP(skill);
        high = Skills.getXPByLevel(Skills.getActualLevel(skill) + 1);
        return (int) (100*((mid - low)/(high-low)));
    }
    public void setCompleteColor(Color col) {
        completeColor = col;
    }
    public void setIncompleteColor(Color col) {
        incompleteColor = col;
    }
    public void setFontColor(Color col) {
        fontColor = col;
    }
    public void setFont(Font f) {
        font = f;
    }
}