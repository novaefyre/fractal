package fractals;

import java.awt.Color;

import guiTeacher.components.Component;

public abstract class Fractal extends Component{
	
	Color color;

	public Fractal(int x, int y, int w, int h) {
		super(x,y,w,h);
		color = Color.black;
	}
	
	public Fractal(int x, int y, int w, int h, Color c) {
		super(x,y,w,h);
		color = c;
	}
	
	public abstract void draw(int iter);

	public void setColor(Color c) {
		color = c;
	}

}
