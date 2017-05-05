package gui;

import java.awt.Dimension;

import guiPractice8.GUIApplication;

@SuppressWarnings("serial")
public class FractalMaker extends GUIApplication {

	FractScreen gameScreen;
	public static FractalMaker game;;
	
	public static void main(String[] args){
		game = new FractalMaker();
		Thread app = new Thread(game);
		app.start();
	}
	
	@Override
	protected void initScreen() {
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		gameScreen = new FractScreen((int)screenSize.getWidth(),(int)screenSize.getHeight());
		setScreen(gameScreen);
	}
}
