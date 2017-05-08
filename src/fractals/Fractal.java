package fractals;

import java.awt.Color;

import guiPractice8.components.Component;

public abstract class Fractal extends Component{
	
	Color color;

	public Fractal(int x, int y, int w, int h) {
		super(x,y,w,h);
		color = Color.black;
		update();
	}
	
	public abstract void draw(int iter);

	public void setColor(Color c) {
		color = c;
	}

}
