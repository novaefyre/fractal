package fractals;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

public class Tree extends Fractal {

	private ArrayList<int[]> lineCoords;
	
	public Tree(int iter, int x, int y, int w, int h) {
		super(x, y, w, h);
		lineCoords = new ArrayList<int[]>();
		draw(iter);
	}

	@Override
	public void draw(int iter) {
		int[] firstLine = {getX()/2,getY()+getHeight(),getX()/2,getY()+(getHeight()*2/3)};
//		[X1,Y1,X2,Y2]
		lineCoords.add(firstLine);
		draw(iter-1,firstLine,20.0);
		draw(iter-1,firstLine,-20.0);
	}

	private void draw(int iter, int[] oldCoords, double angle) {
		if(iter > 0){
			int[] newCoords = new int[4];
			newCoords[0] = oldCoords[2];
			newCoords[1] = oldCoords[3];
			newCoords[2] = newCoords[0] + (int) (Math.cos(Math.toRadians(angle)) * iter * 10);
			newCoords[3] = newCoords[1] + (int) (Math.sin(Math.toRadians(angle)) * iter * 10);
//			double tangentX = Math.tan(Math.toRadians(angle));
//			if(tangentX != 0)
//				newCoords[2] += (int)(newCoords[1]-newCoords[3])*Math.round(tangentX);
			lineCoords.add(newCoords);
//			System.out.println(angle + ", " + Math.toRadians(angle) + ", " + tangentX);
			draw(iter-1, newCoords,angle+20);
			draw(iter-1, newCoords,angle-20);
		}
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(this.color);
		for(int[] line:lineCoords){
			System.out.println(line[0] + ", " + line[1] + ", " + line[2] + ", " + line[3]);
			g.drawLine(line[0], line[1], line[2], line[3]);
		}
	}

}
