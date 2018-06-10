import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;


    class b {
      int x , y ;

       void getx (int a)
      {
      	x = a;

      }
      void gety(int b)
      {
      	y = b;

      }


    }
public class Proyecto2 implements ActionListener
	{
      int c = 240, d = 280;
	  JFrame ventana;
      JButton btn_boton, btn_tmp, btn_iniciar,btn_boton2,btn_shufle,btn_comprobar;

      JLabel lbl_x, lbl_y;
      JTextField tf_x, tf_y;
      JButton[] btn_2boton;
      int dirx = 0;
      int[]nums = { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

      int distanciax, distanciay;



      //shuffle

      b bob = new b();

      /*Timer timer = new Timer(500, new ActionListener()
   		{
      	  public void actionPerformed(ActionEvent e)
      	{

            int x;
            x = btn_.getLocation().x;
            btn_temp[.setLocation( x + dirx, 40);

      	 }
      });
      */







       public void crear()
   {

      int a;
      //System.out.println("crear");
      for ( int i = 0  ; i < 15 ; i++)
      {
         a = i + 1;
         btn_2boton[i] = new JButton(Integer.toString(a));
         btn_2boton[i].setBounds(60+ 60 *( i % 4), 70+70*( i / 4),60,70);
         btn_2boton[i].addActionListener(this);
         ventana.add(btn_2boton[i]);


      }

        btn_boton2 = new JButton();
        btn_boton2.setBounds(240 , 280, 60,70);
        btn_boton2.setBackground(Color.lightGray);
        btn_boton2.addActionListener(this);
        ventana.add(btn_boton2);
        bob.getx(c);
        bob.gety(d);
        ventana.repaint();



   }


   public static void main(String[] args)
   {
      new Proyecto2();
   }

   Proyecto2()
   {

	  btn_2boton = new JButton[15];

      ventana = new JFrame("botones");
      ventana.setBounds(100,100,500,500);
      ventana.setLayout(null);
      ventana.getContentPane().setBackground(Color.lightGray);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      btn_iniciar = new JButton("Iniciar");
      btn_iniciar.setBounds(300,40,80,20);
      btn_iniciar.addActionListener(this);
      ventana.add(btn_iniciar);

      btn_shufle = new JButton("Desordenar");
      btn_shufle.setBounds(300,80,120,20);
      btn_shufle.addActionListener(this);
      ventana.add(btn_shufle);

      tf_x = new JTextField();
      tf_x.setBounds(320,205,30,20);
      ventana.add(tf_x);


      tf_y = new JTextField();
      tf_y.setBounds(320,230,30,20);
      ventana.add(tf_y);



      ventana.setVisible(true);

   }

   public void actionPerformed(ActionEvent e)
   {
      // System.out.println("actionPerformed");

      if (e.getSource() == btn_iniciar)
      {

         crear();

      }
       if (e.getSource() == btn_shufle)
      {

         shuffle();

      }
      else
      {
      	 //timer.start();
      	 btn_tmp = (JButton)e.getSource();
         int x1, y1,o;

         x1 = btn_tmp.getLocation().x;
         y1 = btn_tmp.getLocation().y;

         tf_x.setText(String.valueOf(x1));
         tf_y.setText(String.valueOf(y1));

         distanciax = Math.abs(bob.x - x1);
         distanciay = Math.abs(bob.y - y1);


        if ( distanciax  == 0 & distanciay == 70 )  {
        	System.out.println("moverse en y");
        	movery( x1, y1, distanciax);

        }
        if ( distanciay  == 0  & distanciax == 60)  {
        	System.out.println("moverse en x" );
        	moverx( x1, y1, distanciax);

        	//dirx++;



	     	}

	     	System.out.println(x1);

      	}




   	}

     void moverx ( int x1, int y1, int distancia) {

       int temp = x1;
       x1 = bob.x;
       bob.x = temp;

	    btn_tmp.setLocation(x1  , y1);
	  btn_boton2.setLocation(bob.x  , bob.y);



   };

    void movery ( int x1, int y1, int distanciax) {

             int temp = y1;
             y1 = bob.y;
             bob.y = temp;

	         btn_tmp.setLocation(x1  , y1);
	         btn_boton2.setLocation(bob.x  , bob.y);




   };

      void shuffle()
    {

     int tmp,random;
     int tmp2;
     int x2;
     int y2;
     int x3,y3;

      //System.out.println("shuffle");

      for ( int i = 0; i < 14; i++)
      {


         x2 = btn_2boton[i].getLocation().x;
         x3 = btn_2boton[6].getLocation().x;
         tmp = x2;
         x2 = x3;
         x3 = tmp;

         y2 = btn_2boton[i].getLocation().y;
         y3 = btn_2boton[6].getLocation().y;
         tmp2 = y2;
         y2 = y3;
         y3 = tmp2;

         btn_2boton[i].setLocation(x2  , y2);
         btn_2boton[6].setLocation(x3  , y3);

      }

      }








}
