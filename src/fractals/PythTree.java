package fractals;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class PythTree extends Fractal {

	private int start;
	private int rx;
	private int ry;
	private int rb;
	
	public PythTree(int i, int x, int y, int w) {
		super(x, y, w, 2*w);
		draw(i);
	}
	
	public void setColor(Color c){
		color = c;
	}

	public void draw(int iter) {
		start = iter;
		draw(iter,0.0,super.getWidth(),super.getHeight());
	}
	
	public void draw(int iter, double angle, int w, int h){
		if(iter > 0){
			rx = getX();
			ry = getY();
			rb = getWidth();
			if(angle > 0){
				rx = (start-iter)*rx;
				ry = (start-iter)*ry;
			}else{
				rx = (start-iter)*rx*-1;
				ry = (start-iter)*ry;
			}
			update();
			draw(iter-1,angle-25,(int)(w*0.5*Math.sqrt(2.0)),(int)(h*0.5*Math.sqrt(2.0)));
			draw(iter-1,angle+25,(int)(w*0.5*Math.sqrt(2.0)),(int)(h*0.5*Math.sqrt(2.0)));
		}
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(color != null)g.setColor(color);
		g.drawRect(rx, ry, rb, rb);
	}

}
