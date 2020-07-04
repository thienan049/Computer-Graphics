package clock;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Grid2D {
	private JFrame _area;
	private Image _gridBackGround;
	private Image _oldBackGround;

	public Grid2D(JFrame area, Graphics2D g) {
		_area = area;
		_gridBackGround = new BufferedImage(area.getWidth(), area.getHeight(), BufferedImage.TYPE_INT_ARGB);
		_oldBackGround = new BufferedImage(area.getWidth(), area.getHeight(), BufferedImage.TYPE_INT_ARGB);
		g.setColor(Color.red);
		int temp = area.getWidth() / 2;
		temp = CommonExtensions.Round5(temp);
		g.drawLine(temp, 0, temp, area.getHeight());
		temp = area.getHeight() / 2;
		temp = CommonExtensions.Round5(temp);
		g.drawLine(0, temp, area.getWidth(), temp);

		_area.setIconImage(_oldBackGround);
	}

	public void Draw(Graphics2D g) {
		int width = _area.getWidth();
		int height = _area.getHeight();

		g.setColor(Color.black);
		for (int col = 0; col < width; col += 5) {

			g.drawLine(col, 0, col, height);
		}
		for (int row = 0; row <= height; row += 5) {

			g.drawLine(0, row, width, row);
		}

		g.setColor(Color.red);
		int temp = width / 2;
		temp = CommonExtensions.Round5(temp);
		g.drawLine(temp, 0, temp, height);
		temp = height / 2;
		temp = CommonExtensions.Round5(temp);
		g.drawLine(0, temp, width, temp);

		_area.setIconImage(_gridBackGround);
	}

	public void Clear() {
		_area.setIconImage(_oldBackGround);
	}
}
