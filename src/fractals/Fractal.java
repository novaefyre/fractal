package fractals;

import java.awt.Shape;

import guiPractice8.components.Component;

public abstract class Fractal extends Component{

	Shape base;
	int iter;
	
	public Fractal(Shape base, int iterations,int x,int y,int w, int h) {
		super(x,y,w,h);
		this.base = base;
		iter = iterations;
	}
	
	public abstract void draw();

}
