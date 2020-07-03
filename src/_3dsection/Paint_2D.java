package _3dsection;

import static _3dsection.GUI.paint3D;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Paint_2D extends JComponent {

    public Point startDrag, endDrag;
    public Paint ptemp;
    private Point mouseCoords = null;
    private final Cursor rotate;
    private final Cursor brush;
    private final Cursor delele;

    public Paint_2D() {
        Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
        Image rotateCursor = toolkit.getImage("Image/rotate.png");
        this.rotate = toolkit.createCustomCursor(rotateCursor, new Point(15, 15), "");
        Image brushCursor = toolkit.getImage("Image/brushCursor2.png");
        this.brush = toolkit.createCustomCursor(brushCursor, new Point(0, 0), "");
        Image delCursor = toolkit.getImage("Image/delete.png");
        this.delele = toolkit.createCustomCursor(delCursor, new Point(16, 16), "");

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startDrag = new Point(e.getX(), e.getY());
                endDrag = startDrag;
                if ("Move".equals(GUI.selectButton)) {
                    for (int i = GUI.paint2D.size() - 1; i >= 0; i = i - 1) {
                        Paint pt = GUI.paint2D.get(i);
                        if (pt.contains(startDrag)) {
                            ptemp = pt;
                            GUI.paint2D.remove(pt);
                            break;
                        }
                    }
                } else if ("Delete".equals(GUI.selectButton)) {
                    for (int i = GUI.paint2D.size() - 1; i >= 0; i = i - 1) {
                        Paint pt = GUI.paint2D.get(i);
                        if (pt.contains(startDrag)) {
                            ptemp = null;
                            GUI.paint2D.remove(pt);
                            break;
                        }
                    }
                } else if ("Scale".equals(GUI.selectButton)) {
                    for (int i = GUI.paint2D.size() - 1; i >= 0; i = i - 1) {
                        Paint pt = GUI.paint2D.get(i);
                        if (pt.contains(startDrag)) {
                            ptemp = pt;
                            GUI.paint2D.remove(pt);
                            break;
                        }
                    }
                } else if ("Rotate".equals(GUI.selectButton)) {
                    for (int i = GUI.paint2D.size() - 1; i >= 0; i = i - 1) {
                        Paint pt = GUI.paint2D.get(i);
                        if (pt.contains(startDrag)) {
                            ptemp = pt;
                            GUI.paint2D.remove(pt);
                            break;
                        }
                    }
                } else if ("SymmetryH".equals(GUI.selectButton)) {
                    for (int i = GUI.paint2D.size() - 1; i >= 0; i = i - 1) {
                        Paint pt = GUI.paint2D.get(i);
                        if (pt.contains(startDrag)) {
                            ptemp = pt;
                            break;
                        }
                    }
                } else if ("SymmetryV".equals(GUI.selectButton)) {
                    for (int i = GUI.paint2D.size() - 1; i >= 0; i = i - 1) {
                        Paint pt = GUI.paint2D.get(i);
                        if (pt.contains(startDrag)) {
                            ptemp = pt;
                            break;
                        }
                    }
                } else if ("Information".equals(GUI.selectButton)) {
                    for (int i = GUI.paint2D.size() - 1; i >= 0; i = i - 1) {
                        Paint pt = GUI.paint2D.get(i);
                        if (pt.contains(startDrag)) {
                            ptemp = pt;
                            break;
                        }
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Point p = new Point(e.getX(), e.getY());
                if ("Line".equals(GUI.selectButton)) {
                    MyLine obj = new MyLine(startDrag, p);
                    obj.makeObject(startDrag, p);
                    GUI.paint2D.add(obj);
                } else if ("Move".equals(GUI.selectButton)) {
                    if (ptemp.contains(startDrag)) {
                        ptemp.move(startDrag, p);
                        GUI.paint2D.add(ptemp);
                    }
                } else if ("Rotate".equals(GUI.selectButton)) {
                    if (ptemp.contains(startDrag)) {
                        ptemp.rotate(startDrag, p);
                        GUI.paint2D.add(ptemp);
                    }
                } else if ("Scale".equals(GUI.selectButton)) {
                    if (ptemp.contains(startDrag)) {
                        ptemp.scale(startDrag, p);
                        GUI.paint2D.add(ptemp);
                    }
                }

                startDrag = null;
                endDrag = null;
                repaint();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                endDrag = new Point(e.getX(), e.getY() );
                mouseCoords = new Point(e.getX(), e.getY());
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                mouseCoords = new Point(e.getX(), e.getY());
                repaint();
            }

        });

    }

    @Override
    public void paint(Graphics g) {
        if ("Information".equals(GUI.selectButton)) {
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else if ("Move".equals(GUI.selectButton)) {
            setCursor(new Cursor(Cursor.MOVE_CURSOR));
        } else if ("Delete".equals(GUI.selectButton)) {
            setCursor(delele);
        } else if ("Rotate".equals(GUI.selectButton)) {
            setCursor(rotate);
        } else if ("SymmetryH".equals(GUI.selectButton)) {
            setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));
        } else if ("SymmetryV".equals(GUI.selectButton)) {
            setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
        } else if ("Scale".equals(GUI.selectButton)) {
            setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        } else {
            setCursor(brush);
        }
        
        GraphicAdapter g2 = new GraphicAdapter() {
        };
        g2.setGraphicAdapter(g);
        Point p1, p2, p3, p4;

        if (GUI.Draw3d == false) {
           Khung3D(g);
        } else {
            Khung3D(g);
        }
        //---------------------------------------------------------
    }
    public void Khung3D(Graphics g) {
        GraphicAdapter g2 = new GraphicAdapter() {
        };
        g2.setGraphicAdapter(g);
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0, a = 0; i < 240; i++, a += 5) {
            g.drawLine(a, 0, a, 800);
            g.drawLine(0, a, 1150, a);
        }
        GUI.paint3D.forEach((pt) -> {
            pt.draw(g2);
        });
        g.setColor(Color.BLACK);
        g.drawString("X", 1110, 295);
        g.drawString("Y", 100, 590);
        g.drawString("Z", 405, 10);

        for (int i = 0, a = 0; i < 8; i++, a += 100) {
            g.drawLine(400 + a, 298, 400 + a, 302);
            g.drawLine(398, 300 - a, 402, 300 - a);
            g.drawLine(348 - a / 2, 348 + a / 2, 352 - a / 2, 352 + a / 2);
        }

        MyLine dt1 = new MyLine();
        MyLine dt2 = new MyLine();
        MyLine dt3 = new MyLine();
        if (GUI.paint3D.isEmpty()) {
            GUI.selectColor = Color.BLACK;
            dt1.makeLine(400, 300, 400, 0);
            dt1.draw(g2);
            dt1.makeLine(400, 300, 1250, 300);
            dt1.draw(g2);
            dt1.makeLine(400, 300, 0, 700);
            dt1.draw(g2);
        }
        if (!"".equals(GUI.selectButton)) {
            if ("Cube".equals(GUI.selectButton)) {
                GUI.paint3D.clear();
                GUI.paint3D.removeAll(paint3D);
                MyCube obj = new MyCube();
                obj.makeCube(GUI.X, GUI.Y, GUI.Z);
                GUI.paint3D.add(obj);

                dt1.makeLine(obj.getDt1().getB().x, obj.getDt1().getB().y, 400, 0);
                dt1.draw(g2);
                GUI.paint3D.add(dt1);
                dt2.makeLine(obj.getDt4().getB().x, obj.getDt4().getB().y, 1250, 300);
                GUI.paint3D.add(dt2);
                dt2.draw(g2);
                dt3.makeLine(obj.getDt5().getA().x, obj.getDt5().getA().y, 0, 700);
                GUI.paint3D.add(dt3);
            } else if ("Pyramid".equals(GUI.selectButton)) {
                GUI.paint3D.clear();
                GUI.paint3D.removeAll(paint3D);
                MyPyramid obj = new MyPyramid();
                obj.makePyramid(GUI.X, GUI.Y, GUI.Z);
                GUI.paint3D.add(obj);

                dt1.makeLine(obj.getDt12().getB().x, obj.getDt12().getB().y, 400, 0);
                GUI.paint3D.add(dt1);
                dt2.makeLine(obj.getDt1().getB().x, obj.getDt1().getB().y, 1250, 300);
                GUI.paint3D.add(dt2);
                dt3.makeLine(obj.getDt2().getA().x, obj.getDt2().getA().y, 0, 700);
                GUI.paint3D.add(dt3);
            }
        }

        GUI.selectButton = "";
        repaint();
        validate();
    }

}
