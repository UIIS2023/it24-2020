package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawings extends JPanel{

	public static void main(String[] args) {
		JFrame frame=new JFrame("Drawings");
		frame.setSize(800, 600);
		frame.setVisible(true);
		
		Drawings drawing=new Drawings();
		frame.getContentPane().add(drawing);
	}

	@Override
	public void paint(Graphics g) {
		Point p = new Point(50,50);
		//p.draw(g);
		
		g.setColor(Color.RED);
		
		Line l1 = new Line(new Point (100,100), new Point (200,200));
		//l1.draw(g);
		
		Rectangle r1 = new Rectangle(l1.getEndPoint(), 100, 50);
		//r1.draw(g);
		
		Circle c1 = new Circle(new Point(500, 100), 80);
		//c1.draw(g);
		
		g.setColor(Color.GREEN);

		Donut d1 = new Donut(new Point(800, 100), 50, 25);
		//d1.draw(g);

		Rectangle k1 = new Rectangle(new Point(500, 500), 50, 50);
		//k1.draw(g);
		
		g.setColor(Color.BLACK);
		
		
		int innerR=(int)(k1.getHeight()*Math.sqrt(2)/2);
		Donut d2=new Donut(new Point(k1.getUpperLeftPoint().getX()+k1.getHeight()/2, k1.getUpperLeftPoint().getY()+k1.getHeight()/2), 
				80, innerR);
		//d2.draw(g);
		
		//Vezbe 8.
		//Zadatak 1.
		ArrayList<Shape> shapes=new ArrayList<Shape>();
		shapes.add(p);
		shapes.add(l1);
		shapes.add(c1);
		shapes.add(d1);
		shapes.add(k1);
		
		Iterator<Shape> it=shapes.iterator();
		while(it.hasNext()) {
			it.next().moveBy(10, 0);
		}
		
		//Zadatak 2.
		/*shapes.get(3).draw(g);
		shapes.get(shapes.size()-1).draw(g);
		shapes.remove(1);
		shapes.get(1).draw(g);
		shapes.get(3).draw(g);
		shapes.add(3, l1);
		
		it=shapes.iterator();
		while(it.hasNext()) {
			
			Shape s=it.next();
			if(s instanceof Circle || s instanceof Rectangle) {
				s.draw(g);
			}
		}*/
		
		//Zadatak 3.
		try {
			c1.setRadius(-10);
			System.out.println("Testiranje vracanja u try blok");
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Testiranje daljeg izvrsavanja");
		
		//Zadatak 4.
		it = shapes.iterator();
		while(it.hasNext()) {
			Shape s = it.next();
			s.setSelected(true);
			g.setColor(Color.BLACK);
			s.draw(g);
		}
		
		//Zadatak 5.
		HashMap<String, Shape> hmShapes = new HashMap<String, Shape>();
		hmShapes.put("point1", p);
		hmShapes.put("line1", l1);
		System.out.println(hmShapes.get("line1"));
	}
	
	

}