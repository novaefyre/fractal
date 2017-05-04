package gui;

import java.awt.Dimension;

import guiPractice8.GUIApplication;

@SuppressWarnings("serial")
public class FractalMaker extends GUIApplication {

	FractScreen gameScreen;
	
	@Override
	protected void initScreen() {
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		gameScreen = new FractScreen((int)screenSize.getWidth(),(int)screenSize.getHeight());
		setScreen(gameScreen);
	}
}
