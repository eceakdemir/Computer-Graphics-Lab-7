

package lab7;


import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.*; 

public class Transformation2 extends Frame implements ActionListener, MouseListener
{
	private static final long serialVersionUID = 1L;
	static final int windowWidth = 800;
	static final int windowHeight = 800;
	int[] x = {400,600,600,400};
	int[] y = {400,400,200,200};
	int size = 20;
	
	Transformation2()
	{
		MenuBar menu_bar = new MenuBar();
			
		Menu def = new Menu("File");
		def.add(new MenuItem("Set Default"));
		def.addActionListener(this);
		menu_bar.add(def);
		setMenuBar(menu_bar);
		
		Panel panel=new Panel();  
		panel.setBounds(0,60,windowWidth,30);  
		
		Button button_u = new Button();
		button_u.setLabel("Shear in X");
		button_u.addActionListener(this);
		Button button_d = new Button();
		button_d.setLabel("Shear in Y");
		button_d.addActionListener(this);
		Button button_r = new Button();
		button_r.setLabel("Stretch in X");
		button_r.addActionListener(this);
		Button button_l = new Button();
		button_l.setLabel("Stretch in Y");
		button_l.addActionListener(this);
		Button button_x = new Button();
		button_x.setLabel("Scale Up");
		button_x.addActionListener(this);
		Button button_y = new Button();
		button_y.setLabel("Scale Down");
		button_y.addActionListener(this);
		
		panel.add(button_u);
		panel.add(button_d);
		panel.add(button_r);
		panel.add(button_l);
		panel.add(button_x);
		panel.add(button_y);
		
		panel.setBackground(Color.black); 
		add(panel);
		setLayout(null);
		addWindowListener(new MyFinishWindow());
		addMouseListener(this);
		Color turquoise = new Color(48, 214, 200);
		setBackground(turquoise);
		
	}
	
	public class MyFinishWindow extends WindowAdapter
	   {
	     public void windowClosing(WindowEvent e)
	     {
	       System.exit(0);
	     }
	   }
	
	public void paint(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawLine(0, 400, 800, 400);
		g2d.drawLine(400, 0, 400, 800);
     g2d.setColor(Color.black);
     drawQuadrangle(g2d, x, y);

	}
	
	public void drawTriangle(Graphics2D g2d, int[] x, int[] y) {
		g2d.drawPolygon(x, y, 3);
		g2d.setColor(Color.gray);
		g2d.fillPolygon(x, y, 3);
	}
	
	public void drawQuadrangle(Graphics2D g2d, int[] x, int[] y) {
		g2d.drawPolygon(x, y, 4);
		g2d.setColor(Color.gray);
		g2d.fillPolygon(x, y, 4);
	}
	
	public static void main(String[] argv)
	{
		Transformation2 f = new Transformation2();
		f.setTitle("Transformation 2");
		
		f.setSize(windowWidth, windowHeight);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String str = arg0.getActionCommand();
		if(str.equals("Set Default")) {
			int[] a = {400,600,600,400};
			int[] b = {400,400,200,200};
			x = a;
			y = b;
		}
		else if(str.equals("Shear in X")) {
			x[2] += size;
			x[3] += size;
		}
		else if(str.equals("Shear in Y")) {
			y[1] -= size;
			y[2] -= size;
		}
		else if(str.equals("Stretch in X")) {
			x[1] += size;
			x[2] += size;
		}
		else if(str.equals("Stretch in Y")) {
			y[2] -= size;
			y[3] -= size;
		}
		else if(str.equals("Scale Up")) {
			x[1] += size;
			x[2] += size;
			y[2] -= size;
			y[3] -= size;
		}
		else if(str.equals("Scale Down")) {
			x[1] -= size;
			x[2] -= size;
			y[2] += size;
			y[3] += size;
			
		}
		repaint();
	}
	public void mouseClicked(MouseEvent arg0) {
		//x = arg0.getX();
		//y = arg0.getY();

		repaint();
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}