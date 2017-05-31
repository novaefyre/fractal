package fractals;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;
import guiTeacher.interfaces.Task;

public abstract class Fractal extends Component implements Task{
	
	Color color;
	protected long currentIteration;
	protected long totalIterations;
	protected int depth;

	public Fractal(int i, int x, int y, int w, int h) {
		super(x,y,w,h);
		color = Color.black;
		depth = i;
	}
	
	public abstract void draw(int iter);

	public void setColor(Color c) {
		color = c;
	}

	@Override
	public double getProgress() {
		// TODO Auto-generated method stub
		return currentIteration;
	}

	@Override
	public long getTotal() {
		// TODO Auto-generated method stub
		return totalIterations;
	}

	@Override
	public void start() {
		Thread builder = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				draw(depth);
				
			}
		});
		builder.start();
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return currentIteration>=totalIterations;
	}

	@Override
	public String getDescriptionOfCurrentTask() {
		// TODO Auto-generated method stub
		return "Iteration number "+currentIteration;
	}



}
