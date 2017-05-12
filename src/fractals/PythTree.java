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
	
	public PythTree(int i, int x, int y) {
		super(x, y, 6*x, 4*y);
		draw(i);
//		for(Shape s:fractal){
//			System.out.println(s.toString());
//		}
		update();
	}
	
	public void setColor(Color c){
		color = c;
	}

	public void draw(int iter) {
		if(iter < 0){
			iter = Math.abs(iter);
		}
		start = iter;
		draw(iter,0.0,getX()/2,getY(),50);
	}
	
	public void draw(int iter, double angle, double rectX, double rectY, int b){
		if(iter > 0){
			Shape r = new Rectangle((int)rectX,(int)rectY,b,b);
			if(iter != start){
				AffineTransform transform = new AffineTransform();
				transform.rotate(Math.toRadians(angle));
				r = transform.createTransformedShape(r);
				transform = new AffineTransform();
				if(angle < 0){
					transform.translate((rectX-r.getBounds().getX()-r.getBounds().getWidth()*0.5)*(start-iter), (rectY-r.getBounds().getY()-r.getBounds().getHeight()));
				}else{
					transform.translate((rectX-r.getBounds().getX()+r.getBounds().getWidth()*0.5)*(start-iter), (rectY-r.getBounds().getY()-r.getBounds().getHeight()));
				}
				r = transform.createTransformedShape(r);
			}
			fractal.add(r);
			draw(iter-1,angle-45,r.getBounds().getX(),r.getBounds().getY(),(int)(b*0.5*Math.sqrt(2.0)));
			draw(iter-1,angle+45,r.getBounds().getX(),r.getBounds().getY(),(int)(b*0.5*Math.sqrt(2.0)));
		}
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(color != null)
			g.setColor(color);
		else
			g.setColor(Color.black);
//		g.drawRect(0, 0, 100, 100);
//		g.setColor(color.black);
		if(fractal != null){
			for(Shape s:fractal){
				System.out.println(s.getBounds().getX()+", "+s.getBounds().getY()+", "+s.getBounds().getWidth()+", "+s.getBounds().getHeight());
				g.draw(s);
			}
		}
	}

}
