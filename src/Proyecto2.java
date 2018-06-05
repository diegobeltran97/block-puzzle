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
      int distanciax, distanciay;
      int[]nums = { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
      int []nums2 = { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
      //shuffle

      b bob = new b();

    public void shuffle()
    {

     int tmp,random;
     for ( int i= 0; i < nums.length;i++)
      {
     	random =(int)(Math.random() * nums.length);
     	random = Math.min(random, nums.length -1);
     	tmp = nums[i];
     	nums[i] = nums[random];
     	nums[random] = tmp;
      }

    }

    public void crear()
   {

      int a;
      //System.out.println("crear");
      for ( int i = 0  ; i < nums.length ; i++)
      {
         a = i + 1;
         btn_boton = new JButton(Integer.toString(a));
         btn_boton.setBounds(60+ 60 *( nums[i] % 4), 70+70*( nums[i] / 4),60,70);
         btn_boton.addActionListener(this);
         ventana.add(btn_boton);


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
         shuffle();
         crear();
      }
      else
      {
         int x1, y1,o;
         btn_tmp = (JButton)e.getSource();
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

        	System.out.println(distanciax);
        	moverx( x1, y1, distanciax);

	     	}

	     	System.out.println(x1);

      	}

   	}

     void moverx ( int x1, int y1, int distanciax) {

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


}
