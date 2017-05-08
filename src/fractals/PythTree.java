package fractals;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

public class PythTree extends Fractal {

	private int start;
	private int rectX;
	private int rectY;
	private int rectB;
	
	private Shape fractal;//How to fuse multiple rectangles???
	
	public PythTree(int i, int x, int y, int w) {
		super(x, y, w, 2*w);
		rectX = x;
		rectY = y;
		rectB = w;
		draw(i);
	}
	
	public void setColor(Color c){
		color = c;
	}

	public void draw(int iter) {
		start = iter;
		draw(iter,0.0,getWidth());
	}
	
	public void draw(int iter, double angle, int w){
		if(iter > 0){
			rectX = getX();
			rectY = getY();
			rectB = w;
			if(angle >= 0){
				rectX = (start-iter)*rectX;
				rectY = (start-iter)*rectY;
			}else{
				rectX = (start-iter)*rectX*-1;
				rectY = (start-iter)*rectY;
			}
//			Rectangle r = new Rectangle(rectX,rectY,rectB,rectB);
//			if(angle != 0){
//				AffineTransform transform = new AffineTransform();
//				transform.rotate(Math.toRadians(angle),r.getX() + r.width/2, r.getY() + r.height/2);
//				r = (Rectangle) transform.createTransformedShape(r);
//			}
			update();
			draw(iter-1,angle-25,(int)(w*0.5*Math.sqrt(2.0)));
			draw(iter-1,angle+25,(int)(w*0.5*Math.sqrt(2.0)));
		}
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(color != null)g.setColor(color);
		g.drawRect(rectX, rectY, rectB, rectB);
	}

}
