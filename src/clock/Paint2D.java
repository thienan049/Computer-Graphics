package clock;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paint2D extends JPanel {

    private static final long serialVersionUID = 1L;
    public static JFrame window = new JFrame();
    private Grid2D grid;
    private BorderClock borderClock;
    private Clock analogClock;
    private int counter = 0;
    private boolean isDraw = false;

    private CommonExtensions commonExtensions;

    public Paint2D(JTextArea textAreaLogInfo) {

        setPreferredSize(new Dimension(window.getWidth(), window.getHeight()));
        Cons.WIDTH = 1101;
        Cons.HEIGHT = 500;

        // add here
        borderClock = new BorderClock(new Rectangle(-40, 40, 80, 120), Color.BLACK);
        analogClock = new Clock(new Rectangle(-35, 35, 70, 70), Color.black);

        Timer timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.repaint();
                isDraw = true;
                counter++;

                // Object Clock
                Point centerClock = commonExtensions.ToWorldCoordinates(new Point(analogClock.getSeconsLine().A.x, analogClock.getSeconsLine().A.y));
                Point tempSecondsLine = commonExtensions.ToWorldCoordinates(new Point(analogClock.getSeconsLine().B.x, analogClock.getSeconsLine().B.y));
                Point tempMinutesLine = commonExtensions.ToWorldCoordinates(new Point(analogClock.getMinutesLine().B.x, analogClock.getMinutesLine().B.y));
                Point tempHoursLine = commonExtensions.ToWorldCoordinates(new Point(analogClock.getHoursLine().B.x, analogClock.getHoursLine().B.y));

                // add here
//                textAreaLogInfo.setText("Center Clock : " + "(" + centerClock.x + ";" + centerClock.x + ")" + "\n"
//                        + "Secons Line : " + "(" + tempSecondsLine.x + ";" + tempSecondsLine.y + ")" + "\n"
//                        + "Minutes Line : " + "(" + tempMinutesLine.x + ";" + tempMinutesLine.y + ")" + "\n"
//                        + "Hours Line : " + "(" + tempHoursLine.x + ";" + tempHoursLine.y + ")" + "\n"
//                );
            }
        });
        timer.start();

    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        clockRun(g2d);
        analogClock.Draw(g2d, Dashes.Solid);
        analogClock.seconsLine.end = CommonExtensions.ToComputerCoordinates(new Point(0, 28));
        analogClock.minutesLine.end = CommonExtensions.ToComputerCoordinates(new Point(0, 25));
        analogClock.hoursLine.end = CommonExtensions.ToComputerCoordinates(new Point(0, 20));

        grid = new Grid2D(window, g2d);
        grid.Draw(g2d);
        borderClock.Draw(g2d, Dashes.Solid);

    }

    private void clockRun(Graphics2D g2d) {

        LocalTime now = LocalTime.now();
        int secondsNow = now.getSecond();
        int minutesNow = now.getMinute();
        int hoursNow = now.getHour();

        double seconds = secondsNow * 6;
        double minutes = minutesNow * 6;
        double hours = hoursNow * 30;

        analogClock.RotateTransformSecons(seconds);
        analogClock.RotateTransformMinutes(minutes);
        analogClock.RotateTransformHours(hours);
    }

    public JFrame doWork(JTextArea textAreaLogInfo) {

        window.setResizable(true);
//		window.setUndecorated(true);
        window.setSize(1080, 900);
        window.setContentPane(new Paint2D(textAreaLogInfo));
        window.pack();
        window.setVisible(true);
        window.setLocation(55, 80);
        return window;
    }

}
