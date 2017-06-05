package gui;

import java.awt.Dimension;

import guiTeacher.GUIApplication;

@SuppressWarnings("serial")
public class FractalMaker extends GUIApplication {

	FractScreen gameScreen;
	public static FractalMaker game;;
	
	public FractalMaker(){
		super((int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight());
	}
	
	public static void main(String[] args){
		game = new FractalMaker();
		Thread app = new Thread(game);
		app.start();
		game.setVisible(true);
	}
	
	@Override
	public void initScreen() {
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		gameScreen = new FractScreen((int)screenSize.getWidth(),(int)screenSize.getHeight());
		setScreen(gameScreen);
	}
}
