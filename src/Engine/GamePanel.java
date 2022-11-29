package Engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

import Game.GameState;
import GameObject.Rectangle;
import Screens.PlayLevelScreen;
import SpriteFont.SpriteFont;
import Utils.Colors;

/*
 * This is where the game loop starts
 * The JPanel uses a timer to continually call cycles of update and draw
 */
public class GamePanel extends JPanel {
	// loads Screens on to the JPanel
	// each screen has its own update and draw methods defined to handle a "section"
	// of the game.
	private ScreenManager screenManager;
	
	// used to create the game loop and cycle between update and draw calls
	private Timer timer;
	// used to draw graphics to the panel
	private GraphicsHandler graphicsHandler;
	private boolean doPaint = false;
	private boolean isGamePaused = false;
	private boolean isInvOpen = false;
	private SpriteFont pauseLabel;
	private SpriteFont invLabel;
	private KeyLocker keyLocker = new KeyLocker();
	private final Key pauseKey = Key.P;
<<<<<<< HEAD
	// Music
	Music m = new Music();
	// Full Screen
	int ScreenH = Config.GAME_WINDOW_HEIGHT;
	int ScreenW = Config.GAME_WINDOW_WIDTH;
	public static boolean fullScreen = false;
	BufferedImage tempScreen;
	Graphics2D g2;

	// Game time
	private int time;

	// Opacity for Day/Night Cycle
	private int shade = 0;
	// Changing to night or day
	private boolean fading = true;
	// Day or night is happening
	private boolean changeDay = true;
	// Length of day/night
	private static final int dayLength = 500;
	// Configurations
	public Configurations config = new Configurations(this);

=======
	
	//Initialize sound
	public Sound sound = new Sound();
	
	//Game time 
	private int time; 
	
>>>>>>> 5993a5ab8d8bdf256323b20be68b5febb1089efc
	/*
	 * The JPanel and various important class instances are setup here
	 */
	public GamePanel() {
		super();
		this.setDoubleBuffered(true);

		// attaches Keyboard class's keyListener to this JPanel
		this.addKeyListener(Keyboard.getKeyListener());

		graphicsHandler = new GraphicsHandler();

		screenManager = new ScreenManager();

		pauseLabel = new SpriteFont("PAUSE", 365, 280, "Comic Sans", 24, Color.white);
		pauseLabel.setOutlineColor(Color.black);
		pauseLabel.setOutlineThickness(2.0f);

		// Every timer "tick" will call the update method as well as tell the JPanel to
		// repaint
		// Remember that repaint "schedules" a paint rather than carries it out
		// immediately
		// If the game is really laggy/slow, I would consider upping the FPS in the
		// Config file.
		timer = new Timer(1000 / Config.FPS, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
				// repaint();
				// Full screen purpose
				drawToTempScreen();
				drawToScreen();
				time++;
			}
		});
		timer.setRepeats(true); 
	}

	// this is called later after instantiation, and will initialize screenManager
	// this had to be done outside of the constructor because it needed to know the
	// JPanel's width and height, which aren't available in the constructor
	public void setupGame() {
		setBackground(Colors.CORNFLOWER_BLUE);
		screenManager.initialize(new Rectangle(getX(), getY(), getWidth(), getHeight()));
		doPaint = true;

		// Full Screen -- creates blank buffered image as large as our screen
		tempScreen = new BufferedImage(ScreenW, ScreenH, BufferedImage.TYPE_INT_ARGB);
		g2 = (Graphics2D) tempScreen.getGraphics();

		// Play background music
		m.playMusic();
		if (fullScreen == true) {
			fullScreen();
		}
	}

	// this starts the timer (the game loop is started here
	public void startGame() {
		timer.start();
	}

	public ScreenManager getScreenManager() {
		return screenManager;
	}

	public void update() {

		if (Keyboard.isKeyDown(pauseKey) && !keyLocker.isKeyLocked(pauseKey)) {
			isGamePaused = !isGamePaused;
			keyLocker.lockKey(pauseKey);
		}

		if (Keyboard.isKeyUp(pauseKey)) {
			keyLocker.unlockKey(pauseKey);
		}

		if (!isGamePaused) {
			screenManager.update();
		}

		if (time % 200 == 0) {
			System.out.println("Time: " + time);
<<<<<<< HEAD
		}
		// If day/night time has ended commence fade
		if (time % dayLength == 0) {
			changeDay = true;
		}
		// If day/night is changing call the day/night fade
		if (changeDay == true) {
			if (time % 5 == 0) {
				cycleDay();
			}
		}
		if (fullScreen == true) {
			fullScreen();
		}
	}

	// Fade to day/night
	public void cycleDay() {
		if (fading == true) {
			// System.out.println("Turning Night");
			if (shade < 125) {
				shade = shade + 5;
			} else {
				fading = false;
				changeDay = false;
			}
		} else {
			// System.out.println("Turning Day");
			if (shade > 0) {
				shade = shade - 5;
			} else {
				fading = true;
				changeDay = false;
			}
		}
	}
=======
		} 
		
	}
	
	public void playMusic(int i) {
			sound.setFile(i);
			sound.play();
			sound.loop();
		}
		public void stopMusic() {
			sound.stop();
		}
		public void playSE(int i) {
			sound.setFile(i);
			sound.play();
		}
>>>>>>> 5993a5ab8d8bdf256323b20be68b5febb1089efc

	public void draw() {
		screenManager.draw(graphicsHandler);

		// if game is paused, draw pause gfx over Screen gfx
		if (isInvOpen) {
			invLabel.draw(graphicsHandler);
			graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(),
					new Color(0, 0, 0, 100));
		}
		if (isGamePaused) {
			pauseLabel.draw(graphicsHandler);
			graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(),
					new Color(0, 0, 0, 100));
		}
<<<<<<< HEAD

		// Shade for Day Night Cycle
		graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(),
				new Color(0, 0, 0, shade));
=======
		
>>>>>>> 5993a5ab8d8bdf256323b20be68b5febb1089efc
	}

	@Override

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// every repaint call will schedule this method to be called
		// when called, it will setup the graphics handler and then call this class's
		// draw method
		graphicsHandler.setGraphics((Graphics2D) g);
		if (doPaint) {
			// draw();
			// full screen
			// drawToTempScreen();
			// drawToScreen();
		}
	}

	public void fullScreen() {
		// Get local screen device
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		gd.setFullScreenWindow(GameWindow.gameWindow);

		// Get full screen width and height
		ScreenW = GameWindow.gameWindow.getWidth();
		ScreenH = GameWindow.gameWindow.getHeight();

	}

	public void drawToTempScreen() {
		super.paintComponent(g2);
		// every repaint call will schedule this method to be called
		// when called, it will setup the graphics handler and then call this class's
		// draw method
		graphicsHandler.setGraphics((Graphics2D) g2);
		if (doPaint) {
			draw();
		}
	}

	public void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(tempScreen, 0, 0, ScreenW, ScreenH, null);
		g2.dispose();
	}
}
