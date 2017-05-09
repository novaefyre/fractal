package gui;

import java.awt.Color;
import java.util.ArrayList;

import fractals.Fractal;
import fractals.PythTree;
import guiPractice8.components.Action;
import guiPractice8.components.Button;
import guiPractice8.Screen;
import guiPractice8.components.Visible;

public class FractScreen extends Screen {

	private Button testButton;
	private Fractal fract;
	
	public FractScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		testButton = new Button(100,200,80,40,"Test",new Color(0,76,153), new Action(){
			public void act(){
				
			}
		});
		fract = new PythTree(1,20,100,40);
		fract.setColor(Color.blue);
		viewObjects.add(fract);
//		viewObjects.add(testButton);
	}

}
