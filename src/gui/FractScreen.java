package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import fractals.Fractal;
import fractals.SierpCarpet;
import fractals.Tree;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ProgressBar;
import guiTeacher.components.TextBox;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Task;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

@SuppressWarnings("serial")
public class FractScreen extends FullFunctionScreen {

	private Button treeButton;
	private Button sierpButton;
	private TextField iterations;
	private Fractal fract;
	private ProgressBar loading;
	
	public FractScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		iterations = new TextField(50,50,200,25,"Fractal Depth Here","Iterations");
		TextBox errorBox = new TextBox(260,50,1000,25,"Error: Iterations must be an integer.");
		loading = new ProgressBar(150, 100, 200, 50);
		treeButton = new Button(50,100,80,40,"Tree",new Color(0,76,153), new Action(){
			public void act(){
				String iterS = iterations.getText();
				int iter = 0;
				try{
					iter = Math.abs(Integer.parseInt(iterS));
				}catch(Exception e){
					viewObjects.add(errorBox);
				}
				if(iter!=0)setFract(new Tree(iter,30,120,1000,400),viewObjects,null);
			}
		});
		sierpButton = new Button(50,150,120,40,"Sierpinski Square",new Color(0,76,153), new Action(){
			public void act(){
				String iterS = iterations.getText();
				int iter = 0;
				try{
					iter = Math.abs(Integer.parseInt(iterS));
				}catch(Exception e){
					viewObjects.add(errorBox);
				}
				if(iter!=0){
					final int i = iter;
					Fractal fractal = new SierpCarpet(iter,30,120,500);
					loading.setTask(fractal);
					loading.startTask(new Action() {
						
						@Override
						public void act() {
							System.out.println("Successful");
							setFract(fractal,viewObjects,null);
						}
					});
				}
			}
		});
		viewObjects.remove(errorBox);
		viewObjects.add(iterations);
		viewObjects.add(treeButton);
		viewObjects.add(sierpButton);
		viewObjects.add(loading);
	}
	
	public void setFract(Fractal fractal, List<Visible> viewObjects, Color c){
		viewObjects.remove(fract);
		fract = fractal;
		if(c!=null)fract.setColor(c);
		fract.update();
		viewObjects.add(fract);
	}

}
