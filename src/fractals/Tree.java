package fractals;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

public class Tree extends Fractal {

	private ArrayList<int[]> coords;
	
	public Tree(int iter, int x, int y, int w, int h) {
		super(x, y, w, h);
		coords = new ArrayList<int[]>();
		draw(iter);
	}

	@Override
	public void draw(int iter) {
		int[] firstLine = {getX()/2,getY()+getHeight(),getX()/2,getY()+(getHeight()*2/3)};
		coords.add(firstLine);
		draw(iter-1,firstLine,25.0);
		draw(iter-1,firstLine,-25.0);
	}

	private void draw(int iter, int[] LineCoords, double angle) {
		if(iter > 0){
			int[] newCoords = new int[4];
			newCoords[0] = LineCoords[2];
			newCoords[1] = LineCoords[3];
			newCoords[2] = newCoords[0]*2/3;
			newCoords[3] = newCoords[1]*2/3;
			coords.add(newCoords);
			draw(iter, newCoords,angle+25);
			draw(iter, newCoords,angle-25);
		}
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

}
