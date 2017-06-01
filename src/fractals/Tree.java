package fractals;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

public class Tree extends Fractal {

	private ArrayList<int[]> lineCoords;
	
	public Tree(int iter, int x, int y, int w, int h) {
		super(iter, x, y, w, h);
		lineCoords = new ArrayList<int[]>();
		draw(iter);
		int maxX = maxCoord(2);
		int maxY = maxCoord(3);
		if(x+w<maxX){
			setWidth(maxX-x);
		}
		if(y+h<maxY){
			setHeight(maxY-y);
		}
	}

	@Override
	public void draw(int iter) {
		int[] firstLine = {getX(),getY()+(getHeight()/3),getX()*2,getY()+(getHeight()/3)};
//		[X1,Y1,X2,Y2]
		lineCoords.add(firstLine);
		draw(iter-1,firstLine,15.0);
		draw(iter-1,firstLine,-15.0);
	}

	private void draw(int iter, int[] oldCoords, double angle) {
		if(iter > 0){
			int[] newCoords = new int[4];
			newCoords[0] = oldCoords[2];
			newCoords[1] = oldCoords[3];
			newCoords[2] = newCoords[0] + (int) (Math.cos(Math.toRadians(angle)) * iter * 5);
			newCoords[3] = newCoords[1] + (int) (Math.sin(Math.toRadians(angle)) * iter * 5);
			lineCoords.add(newCoords);
			draw(iter-1, newCoords,angle+15);
			draw(iter-1, newCoords,angle-15);
		}
	}
	
	public int maxCoord(int coordIdx){
		int max = Integer.MIN_VALUE;
		for(int[] line:lineCoords){
			int coord = line[coordIdx];
			if(coord > max){
				max = coord;
			}
		}
		return max;
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(this.color);
		for(int[] line:lineCoords){
//			System.out.println(line[0] + ", " + line[1] + ", " + line[2] + ", " + line[3]);
			g.drawLine(line[0], line[1], line[2], line[3]);
		}
	}

}
