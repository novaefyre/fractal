package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import fractals.Fractal;
import fractals.SerpCarpet;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class FractScreen extends FullFunctionScreen {

	@SuppressWarnings("unused")
	private Button testButton;
	private Fractal fract;
	
	public FractScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		testButton = new Button(100,200,80,40,"Test",new Color(0,76,153), new Action(){
			public void act(){
				
			}
		});
		fract = new SerpCarpet(6,30,40,500);
		fract.setColor(Color.blue);
		fract.update();
		viewObjects.add(new TextField(400,200,100,25,"Enter Text Here","text"));
		viewObjects.add(fract);
//		viewObjects.add(testButton);
	}

}
