package fractals;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class PythTree extends Fractal {

	private int start;
	
	private ArrayList<Shape> fractal = new ArrayList<Shape>();
	
	public PythTree(int i, int x, int y, int w) {
		super(x, y, w, 2*w);
		draw(i);
		update();
	}
	
	public void setColor(Color c){
		color = c;
	}

	public void draw(int iter) {
		start = iter;
		draw(iter,0.0,getWidth());
	}
	
	public void draw(int iter, double angle, int b){
		if(iter > 0){
			int rectX = getX();
			int rectY = getY();
			if(angle >= 0){
				rectX = (start-iter+1)*rectX;
				rectY = (start-iter+1)*rectY;
			}else{
				rectX = (start-iter+1)*rectX*-1;
				rectY = (start-iter+1)*rectY;
			}
			Shape r = new Rectangle(getX(),getY(),b-1,b-1);
			if(angle != 0){
				AffineTransform transform = new AffineTransform();
				transform.rotate(Math.toRadians(angle),rectX + b/2, rectY + b/2);
				r = transform.createTransformedShape(r);
			}
			fractal.add(r);
//			Graphics2D g = getImage().createGraphics();
//			g.draw(r);
			draw(iter-1,angle-25,(int)(b*0.5*Math.sqrt(2.0)));
			draw(iter-1,angle+25,(int)(b*0.5*Math.sqrt(2.0)));
		}
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(color != null)g.setColor(color);
		if(fractal != null){
			for(Shape s:fractal){
				g.draw(s);
			}
		}
	}

}
