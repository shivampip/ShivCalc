import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

class ShivCalc extends Frame implements ActionListener,KeyListener
{
static String eq;
static int num[]=new int[100];
Label l1,l2;
TextField t1;
Button b1,b2,b3;
Panel p1;

ShivCalc()
{
initComponent();
}

public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
eq=t1.getText();
int aa=cal(eq);
l2.setText("Ans is "+aa);
if(error){l2.setText("Limit exceed");
l2.setBackground(new java.awt.Color(255,153,153));}
}
else if(e.getSource()==b2)
{
System.exit(0);
}
else if(e.getSource()==b3)
{
t1.setText("");
l2.setText("");
l2.setBackground(new java.awt.Color(204,204, 255));
}
}


public void keyPressed(KeyEvent e)
{
if(e.getKeyCode()==KeyEvent.VK_ENTER)
	{
		eq=t1.getText();
		int aa=cal(eq);
		l2.setText("Ans is "+aa);
		if(error){l2.setText("Limit exceed");
		l2.setBackground(new java.awt.Color(255,153,153));}
	}
else if(e.getKeyCode()==KeyEvent.VK_SPACE)
	{
		t1.setText("");
		l2.setText("");
		error=false;
		l2.setBackground(new java.awt.Color(204,204, 255));
	}
else if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
	{
		System.exit(0);
	}
}
public void keyReleased(KeyEvent e)
{}
public void keyTyped(KeyEvent e)
{}

void initComponent()
{
l1=new Label("Enter your Equation");
l1.setFont(new java.awt.Font("Dialog", 1, 40));
t1=new TextField(10);
l2=new Label("");
t1.setBackground(new java.awt.Color(204,204, 255));
t1.setFont(new java.awt.Font("Dialog", 1, 35));
l2.setFont(new java.awt.Font("Dialog", 1, 35));
l2.setBackground(new java.awt.Color(204,204, 255));
b1=new Button("Calculate");
b2=new Button("Exit");
b1.setFont(new java.awt.Font("Dialog", 1, 35));
b2.setFont(new java.awt.Font("Dialog", 1, 35));
b3=new Button("Reset");
b3.setFont(new java.awt.Font("Dialog", 1, 35));
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
p1=new Panel();
p1.setLayout(new FlowLayout());
p1.add(b3);
p1.add(b2);
setLocation(300,200);
setBackground(new java.awt.Color(153, 153, 255));
setLayout(new GridLayout(5,1));
add(l1);
add(t1);
add(b1);
add(l2);
add(p1);
t1.addKeyListener(this);
pack();
}


/*---------------------------------------------------------------Calculation Part-------------------------------------------------------------------------*/
static boolean error=false;
static boolean isInt(char a)
{
	String aa=""+a;
	try{int aaa=Integer.parseInt(aa);
	return true;
	}
	catch(Exception e){
	return false;}
}

static int cal(String eq)
{
int ans=0;
char equa[]=new char[eq.length()];
eq.getChars(0,eq.length(),equa,0);

try{int k=0;
for(int i=0;i<eq.length();i++)
{
	if(isInt(equa[i]))
	{
	num[k]=Integer.parseInt(""+equa[i]);
try{	if(isInt(equa[i+1]))
	{
	num[k]=num[k]*10+Integer.parseInt(""+equa[i+1]);
	i++;
try{	if(isInt(equa[i+1]))
	{
	num[k]=num[k]*10+Integer.parseInt(""+equa[i+1]);
	i++;
	}}catch(Exception e){}
	}}catch(Exception e){}
	k++;
	}
}


char oper[]=new char[10];
int op=0;
for(char a:equa)
{
if(a=='+')
{oper[op]='+'; op++;}
else if(a=='-')
{oper[op]='-'; op++;}
else if(a=='*')
{oper[op]='*'; op++;}
else if(a=='/')
{oper[op]='/'; op++;}

}



for(int pp=0;pp<10;pp++)
{
if(oper[pp]=='+')
ans=num[0]+num[1];
else if(oper[pp]=='-')
ans=num[0]-num[1];
else if(oper[pp]=='*')
ans=num[0]*num[1];
else if(oper[pp]=='/')
ans=num[0]/num[1];

num[0]=ans;
for(int h=1;h<10;h++)
num[h]=num[h+1];
}}catch(Exception e){error=true;}


return ans;
}




public static void main(String as[])
{
new ShivCalc().setVisible(true);
}
}



