package lifegame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Gamelogic extends JPanel {

    private static final long serialVersionUID = -336975817478756636L;

    private final int width = 30;

    private final int height = 30;

    private final char died = 'N';

    private final char alive = 'A';

    private final char[][] world = {
            { 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A', 'N', 'N', 'N', 'N',
                    'N' },
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N' },
            { 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A',
                    'A', 'N', 'N', 'N', 'A', 'A', 'N', 'A', 'N', 'A', 'A', 'N',
                    'N' },
            { 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A',
                    'A', 'N', 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A', 'A', 'N',
                    'N' },
            { 'A', 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',
                    'A', 'N', 'N', 'N', 'A', 'N', 'A', 'N', 'N', 'N', 'N', 'N',
                    'N' },
            { 'N', 'A', 'A', 'N', 'N', 'N', 'A', 'N', 'N', 'A', 'N', 'N', 'N',
                    'A', 'N', 'A', 'N', 'N', 'A', 'N', 'N', 'A', 'N', 'A', 'N',
                    'N' },
            { 'N', 'A', 'A', 'A', 'N', 'A', 'A', 'A', 'A', 'A', 'N', 'N', 'N',
                    'A', 'A', 'N', 'N', 'N', 'A', 'N', 'A', 'A', 'A', 'A', 'A',
                    'N' },
            { 'N', 'N', 'A', 'N', 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N' },
            { 'N', 'N', 'A', 'N', 'N', 'N', 'A', 'N', 'N', 'N', 'A', 'N', 'A',
                    'N', 'N', 'A', 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'A', 'N',
                    'N' },
            { 'N', 'N', 'A', 'A', 'A', 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N', 'N', 'N', 'N', 'A', 'A', 'N', 'A', 'N', 'A', 'A', 'A',
                    'A' },
            { 'N', 'N', 'A', 'N', 'A', 'A', 'A', 'N', 'N', 'N', 'N', 'A', 'N',
                    'N', 'N', 'N', 'A', 'N', 'A', 'A', 'A', 'A', 'A', 'N', 'N',
                    'N' },
            { 'N', 'N', 'A', 'N', 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'A', 'N',
                    'N', 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N' },
            { 'N', 'N', 'A', 'N', 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'A', 'N', 'N', 'N',
                    'N' },
            { 'N', 'N', 'A', 'N', 'N', 'N', 'A', 'N', 'N', 'N', 'A', 'N', 'A',
                    'N', 'N', 'A', 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N' },
            { 'N', 'N', 'A', 'N', 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'A', 'N', 'N', 'N', 'N',
                    'N' },
            { 'N', 'A', 'A', 'A', 'N', 'N', 'A', 'N', 'N', 'A', 'N', 'N', 'N',
                    'A', 'A', 'N', 'N', 'N', 'A', 'N', 'A', 'A', 'A', 'A', 'A',
                    'N' },
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N' },
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N' },
            { 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A',
                    'A', 'N', 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A', 'A', 'N',
                    'N' },
            { 'A', 'A', 'A', 'A', 'N', 'N', 'N', 'A', 'A', 'N', 'N', 'N', 'A',
                    'A', 'N', 'A', 'N', 'A', 'A', 'N', 'N', 'N', 'A', 'A', 'N',
                    'N' },
            { 'N', 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N' },
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N' },
            { 'N', 'N', 'N', 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N' },
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N',
                    'N' },

    };

    private final char[][] world2 = {
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },
            { 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N' },
            { 'N', 'A', 'A', 'A', 'N', 'N', 'N', 'N' },
            { 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N' },
            { 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N' },
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' }

    };

    private char[][] nextStatus = new char[world.length][world[0].length];

    private char[][] tempStatus = new char[world.length][world[0].length];

    private Timer timer;


    private final int DELAY_TIME = 2000;

    public Gamelogic() {
        this.startAnimation();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < nextStatus.length; i++) {
            for (int j = 0; j < nextStatus[i].length; j++) {
                if (nextStatus[i][j] == alive) {
                    g.setColor(Color.blue);
                    g.fillRect( j * width, i * height, width, height);

                } else {
                    g.setColor(Color.ORANGE);
                    g.drawRect( j * width, i * height, width, height);
       /*
                    g.fillRect( j * width, i * height, width, height);
         */       }
            }
        }
    }


    private void changestatus() {
        for (int row = 0; row < nextStatus.length; row++) {
            for (int col = 0; col < nextStatus[row].length; col++) {

                switch (nearbycnt(row, col)) {
                    case 0:
                    case 1:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        nextStatus[row][col] = died;
                        break;
                    case 2:
                        nextStatus[row][col] = tempStatus[row][col];
                        break;
                    case 3:
                        nextStatus[row][col] = alive;
                        break;
                }
            }
        }
        copy();
    }


    private int nearbycnt(int row, int col) {
        int count = 0, r = 0, c = 0;

        for (r = row - 1; r <= row + 1; r++) {
            for (c = col - 1; c <= col + 1; c++) {
                if (r < 0 || r >= tempStatus.length || c < 0
                        || c >= tempStatus[0].length) {
                    continue;
                }
                if (tempStatus[r][c] == alive) {
                    count++;
                }
            }
        }
        if (tempStatus[row][col] == alive) {
            count--;
        }
        return count;
    }

    private void startAnimation() {
        for (int row = 0; row < world.length; row++) {
            for (int col = 0; col < world[0].length; col++) {
                nextStatus[row][col] = world[row][col];
                tempStatus[row][col] = world[row][col];
            }
        }

        timer = new Timer(DELAY_TIME, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                changestatus();
                repaint();
            }
        });

        timer.start();
    }

    private void copy() {
        for (int row = 0; row < nextStatus.length; row++) {
            for (int col = 0; col < nextStatus[row].length; col++) {
                tempStatus[row][col] = nextStatus[row][col];
            }
        }
    }
}