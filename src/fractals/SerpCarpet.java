package fractals;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.ArrayList;

public class SerpCarpet extends Fractal {

	private int start = -1;
	private Rectangle startSquare = new Rectangle();
	private ArrayList<Rectangle> subSquares = new ArrayList<Rectangle>();
	
	public SerpCarpet(int x, int y, int w) {
		super(x, y, w, w);
		startSquare = new Rectangle(x,y,w,w);
		update();
	}
	
	public SerpCarpet(int i, int x, int y, int w) {
		super(x, y, w, w);
		startSquare = new Rectangle(x,y,w,w);
		start = i;
		draw(i);
		update();
	}

	@Override
	public void draw(int iter) {
		if(iter > 0){
			if(start == -1)
				start = iter;
			Rectangle center = new Rectangle(startSquare.width/3+startSquare.x-10, startSquare.width/3+startSquare.y-10, startSquare.width/3, startSquare.width/3);
			subSquares.add(center);
			for(int i = 0; i < 9; i++){
				if(i != 5){
					Rectangle base = new Rectangle(startSquare.x+(i%3*startSquare.width/3), startSquare.y+((i/3)*startSquare.width), startSquare.width/3, startSquare.width/3);
					draw(iter-1,base);
				}
			}
		}
	}
	
	public void draw(int iter, Rectangle base){
		if(iter > 0){
			Rectangle center = new Rectangle(base.width/3+base.x, base.width/3+base.y, base.width/3, base.width/3);
			subSquares.add(center);
			for(int i = 0; i < 9; i++){
				if(i != 5){
					Rectangle b = new Rectangle(base.x+(i%3*base.width/3), base.y+(i/3*base.width), base.width/3, base.width/3);
					draw(iter-1,b);
				}
			}
		}
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(this.color);
		if(startSquare != null){
			g.fill(startSquare);
			g.setColor(Color.white);
			for(Rectangle s : subSquares){
				System.out.println(s.toString());
				g.fill(s);
			}
		}
	}

}
