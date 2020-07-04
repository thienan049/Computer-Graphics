package clock;
import java.awt.Point;

public class Cons
	{
		public static int WIDTH = 0;
		public static int HEIGHT = 0;

		public static int DISTANCE_THOR_MJOLNIR = 100;
		public static int HUMAN_WIDTH = 30;
		public static int HUMAN_HEIGHT = 47;
		public static Point HUMAN_LOCATION = new Point(80, HUMAN_HEIGHT);
		public static int MJOLNIR_WIDTH = 10;
		public static int MJOLNIR_HEIGHT = 18;
		
		public static Point MJOLNIR_LOCATION = new Point(HUMAN_LOCATION.x - DISTANCE_THOR_MJOLNIR, MJOLNIR_HEIGHT);
	}
