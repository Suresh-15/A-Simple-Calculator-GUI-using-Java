import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class Calculator implements ActionListener{
	
	JFrame frame;	JPanel panel;
	JTextField textField1,textField2;	
	RoundButton []keyButton  = new RoundButton[10];
	RoundButton []funcButton = new RoundButton[9];	
	RoundButton addButton,subButton,mulButton,divButton,modButton;
	RoundButton decButton,equButton,clrButton,sigButton;
	JButton delButton;
	Font font1 = new Font("Arial",Font.PLAIN,30);
	Font font2 = new Font("Arial",Font.PLAIN,20);
	Font font3 = new Font("Arial",Font.PLAIN,12);
	Font font4 = new Font("Arial",Font.PLAIN,35);
	double num1=0,num2=0,result=0;	char operator='\0',prevOp='\0';
	Border border = BorderFactory.createLineBorder(Color.gray,1);
	
	public Calculator(){
		
		Toolkit t = Toolkit.getDefaultToolkit();  
        Image image = t.getImage("Icon.png");
		
		frame = new JFrame("My Calculator Design");
		frame.setIconImage(image);	frame.setResizable(false);
		frame.setSize(325,540);	frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.lightGray);
		
		textField1 = new JTextField();			textField2 = new JTextField();
		textField1.setEditable(false);			textField2.setEditable(false);
		textField1.setBounds(10,30,290,40);		textField2.setBounds(10,70,290,40);
		textField1.setBorder(null);			textField2.setBorder(null);
		textField1.setFont(font2);			textField2.setFont(font2);

		textField1.setHorizontalAlignment(JTextField.RIGHT);
		textField2.setHorizontalAlignment(JTextField.RIGHT);
				
		addButton = new RoundButton("+");		addButton.setBounds(220,220,60,60);			
		subButton = new RoundButton("-");		subButton.setBounds(220,150,60,60);	    	
		mulButton = new RoundButton("x");		mulButton.setBounds(220,80,60,60);	    	
		divButton = new RoundButton("÷");		divButton.setBounds(220,10,60,60);	    	
		decButton = new RoundButton(".");		decButton.setBounds(80,290,60,60);	    	
		equButton = new RoundButton("=");		equButton.setBounds(220,290,60,60);			
		clrButton = new RoundButton("Clr");		clrButton.setBounds(10,10,60,60);	    	
		sigButton = new RoundButton("+/-");		sigButton.setBounds(80,10,60,60);	    	
		modButton = new RoundButton("%");		modButton.setBounds(150,10,60,60);	    	
		
		addButton.setPreferredSize(new Dimension(60,60));	
		subButton.setPreferredSize(new Dimension(60,60));	
		mulButton.setPreferredSize(new Dimension(60,60));   
		divButton.setPreferredSize(new Dimension(60,60));   
		decButton.setPreferredSize(new Dimension(60,60));   
		equButton.setPreferredSize(new Dimension(60,60));   
		clrButton.setPreferredSize(new Dimension(60,60));   
		sigButton.setPreferredSize(new Dimension(60,60));   
		modButton.setPreferredSize(new Dimension(60,60));   
		
		addButton.setBackground(Color.orange);		addButton.setForeground(Color.white);	addButton.setFont(font1);
		subButton.setBackground(Color.orange);      	subButton.setForeground(Color.white);	subButton.setFont(font1);
		mulButton.setBackground(Color.orange);      	mulButton.setForeground(Color.white);	mulButton.setFont(font1);
		divButton.setBackground(Color.orange);      	divButton.setForeground(Color.white);	divButton.setFont(font1);
		decButton.setBackground(Color.lightGray);	decButton.setForeground(Color.white);	decButton.setFont(font1);
		equButton.setBackground(Color.cyan);     	equButton.setForeground(Color.white);	equButton.setFont(font1);
		clrButton.setBackground(Color.orange);      	clrButton.setForeground(Color.white);	clrButton.setFont(font3);
		sigButton.setBackground(Color.orange);      	sigButton.setForeground(Color.white);	sigButton.setFont(font1);
		modButton.setBackground(Color.orange);      	modButton.setForeground(Color.white);	modButton.setFont(font1);
		
		ImageIcon imageDel = new ImageIcon(t.getImage("clearButton.png"));
		
		delButton = new JButton();				
		delButton.setFocusPainted(false);
		delButton.setIcon(imageDel);			
		delButton.setContentAreaFilled(false);	
		delButton.setBounds(150,290,60,60); 	
		delButton.setBorderPainted(false);
	
		//	addButton.setContentAreaFilled(false);	addButton.setFocusPainted(false);	addButton.setBorderPainted(false);
		//	subButton.setContentAreaFilled(false);	subButton.setFocusPainted(false);	subButton.setBorderPainted(false);
		//	mulButton.setContentAreaFilled(false);	mulButton.setFocusPainted(false);	mulButton.setBorderPainted(false);
		//	divButton.setContentAreaFilled(false);	divButton.setFocusPainted(false);	divButton.setBorderPainted(false);
		//	decButton.setContentAreaFilled(false);	decButton.setFocusPainted(false);	decButton.setBorderPainted(false);
		//	equButton.setContentAreaFilled(false);	equButton.setFocusPainted(false);	equButton.setBorderPainted(false);
		//	clrButton.setContentAreaFilled(false);	clrButton.setFocusPainted(false);	clrButton.setBorderPainted(false);
		//	sigButton.setContentAreaFilled(false);	sigButton.setFocusPainted(false);	sigButton.setBorderPainted(false);
		
		keyButton[0] = new RoundButton("0");	keyButton[0].setBounds(10,290,60,60);
		keyButton[1] = new RoundButton("1");	keyButton[1].setBounds(10,220,60,60);
		keyButton[2] = new RoundButton("2");	keyButton[2].setBounds(80,220,60,60);
		keyButton[3] = new RoundButton("3");	keyButton[3].setBounds(150,220,60,60);
		keyButton[4] = new RoundButton("4");	keyButton[4].setBounds(10,150,60,60);
		keyButton[5] = new RoundButton("5");	keyButton[5].setBounds(80,150,60,60);
		keyButton[6] = new RoundButton("6");	keyButton[6].setBounds(150,150,60,60);
		keyButton[7] = new RoundButton("7");  	keyButton[7].setBounds(10,80,60,60);
		keyButton[8] = new RoundButton("8");	keyButton[8].setBounds(80,80,60,60);
		keyButton[9] = new RoundButton("9");  	keyButton[9].setBounds(150,80,60,60);
																						 
		keyButton[0].setBackground(Color.lightGray);	keyButton[0].setForeground(Color.white);	keyButton[0].setFont(font1);
		keyButton[1].setBackground(Color.lightGray);    keyButton[1].setForeground(Color.white);	keyButton[1].setFont(font1);
		keyButton[2].setBackground(Color.lightGray);    keyButton[2].setForeground(Color.white);	keyButton[2].setFont(font1);
		keyButton[3].setBackground(Color.lightGray);    keyButton[3].setForeground(Color.white);	keyButton[3].setFont(font1);
		keyButton[4].setBackground(Color.lightGray);    keyButton[4].setForeground(Color.white);	keyButton[4].setFont(font1);
		keyButton[5].setBackground(Color.lightGray);    keyButton[5].setForeground(Color.white);	keyButton[5].setFont(font1);
		keyButton[6].setBackground(Color.lightGray);    keyButton[6].setForeground(Color.white);	keyButton[6].setFont(font1);
		keyButton[7].setBackground(Color.lightGray);    keyButton[7].setForeground(Color.white);	keyButton[7].setFont(font1);
		keyButton[8].setBackground(Color.lightGray);    keyButton[8].setForeground(Color.white);	keyButton[8].setFont(font1);
		keyButton[9].setBackground(Color.lightGray);	keyButton[9].setForeground(Color.white);	keyButton[9].setFont(font1);
		
		keyButton[0].addActionListener(this);	addButton.addActionListener(this);	addButton.setFont(font1);
		keyButton[1].addActionListener(this);	subButton.addActionListener(this); 	subButton.setFont(font4);
		keyButton[2].addActionListener(this);	mulButton.addActionListener(this);  	mulButton.setFont(font1);
		keyButton[3].addActionListener(this);	divButton.addActionListener(this);  	divButton.setFont(font4);
		keyButton[4].addActionListener(this);	decButton.addActionListener(this);  	decButton.setFont(font1);
		keyButton[5].addActionListener(this);	equButton.addActionListener(this);  	equButton.setFont(font2);
		keyButton[6].addActionListener(this);	delButton.addActionListener(this);	delButton.setFont(font2);
		keyButton[7].addActionListener(this);	clrButton.addActionListener(this);  	clrButton.setFont(font2);
		keyButton[8].addActionListener(this);	sigButton.addActionListener(this);  	sigButton.setFont(font2);
		keyButton[9].addActionListener(this);	modButton.addActionListener(this);  	modButton.setFont(font2);

		panel = new JPanel();
		panel.setLayout(null);	
		panel.setBounds(10,130,310,400);
		panel.add(clrButton);		panel.add(sigButton);		panel.add(delButton);		panel.add(divButton);
		panel.add(keyButton[7]);	panel.add(keyButton[8]);	panel.add(keyButton[9]);	panel.add(mulButton);
		panel.add(keyButton[4]);	panel.add(keyButton[5]);	panel.add(keyButton[6]);	panel.add(subButton);
		panel.add(keyButton[1]);	panel.add(keyButton[2]);	panel.add(keyButton[3]);	panel.add(addButton);
		panel.add(keyButton[0]);	panel.add(decButton);		panel.add(modButton);		panel.add(equButton);
		
		frame.add(textField1);	
		frame.add(textField2);		
		frame.add(panel);	
		frame.setLayout(null);	
		frame.setVisible(true);
	}
	
	public void calcInternally(){
		String emergency = textField1.getText();
		try{
			textField1.setText("("+textField1.getText()+(String.valueOf(operator))+(textField2.getText())+")");
			num2=Double.parseDouble(textField2.getText());
			switch(operator){
				
			case '+'->	num1=num1+num2; 
			case '-'->	num1=num1-num2; 
			case '*'->	num1=num1*num2; 
			case '%'->	num1=num1%num2; 
			case '/'->	{
				try{
					num1=num1/num2; 
				}catch(ArithmeticException a){
					textField2.setText("Math Error"); return;
				}
			}
			default->{
				num1=num2;
			}
			}
			textField2.setText("");
			num2=0;	operator='\0';
		}catch(Exception e){
			textField1.setText(emergency);
		}
		
	}
	
	public void actionPerformed(ActionEvent ae){
		try{
			for(int i=0;i<10;i++)
				if(ae.getSource()==keyButton[i]){
					textField2.setText(textField2.getText().concat(String.valueOf(i)));
				}
			if(ae.getSource()==decButton){
				textField2.setText(textField2.getText().concat("."));
				textField2.setText(textField2.getText());
			}
			if(ae.getSource()==addButton){
				if(operator!='\0')
					calcInternally();
				else if(operator=='\0'){
					num1=Double.parseDouble(textField2.getText());	operator='+';
					if(prevOp == '='){	textField1.setText(textField2.getText());	prevOp='\0';  }
					else	textField1.setText(textField1.getText()+textField2.getText());
					textField2.setText("");
				}
				operator='+';
			}
			if(ae.getSource()==subButton){
				if(operator!='\0')
					calcInternally();
				else if(operator=='\0'){
					num1=Double.parseDouble(textField2.getText());	operator='-';
					if(prevOp == '='){	textField1.setText(textField2.getText());	prevOp='\0';  }
					else	textField1.setText(textField1.getText()+textField2.getText());
					textField2.setText("");
				}
				operator='-';
			}
			if(ae.getSource()==mulButton){
				if(operator!='\0')
					calcInternally();
				else if(operator=='\0'){
					num1=Double.parseDouble(textField2.getText());	operator='*';	
					if(prevOp == '='){	textField1.setText(textField2.getText());	prevOp='\0';  }
					else	textField1.setText(textField1.getText()+textField2.getText());
					textField2.setText("");
				}
				operator='*';
			}
			if(ae.getSource()==divButton){
				if(operator!='\0')
					calcInternally();
				else if(operator=='\0'){
					num1=Double.parseDouble(textField2.getText());	operator='/';
					if(prevOp == '='){	textField1.setText(textField2.getText());	prevOp='\0';  }
					else	textField1.setText(textField1.getText()+textField2.getText());
					textField2.setText("");
				}
				operator='/';	
			}
			if(ae.getSource()==modButton){
				num1=Double.parseDouble(textField2.getText());	operator='%';	
				textField1.setText(textField2.getText());
				textField2.setText("");
			}
			if(ae.getSource()==equButton){
				textField1.setText(textField1.getText()+(String.valueOf(operator))+textField2.getText());
				if(operator == '\0')
					textField1.setText(String.valueOf(result));
				num2=Double.parseDouble(textField2.getText());
				switch(operator){
					
				case '+'->	result=num1+num2; 
				case '-'->	result=num1-num2; 
				case '*'->	result=num1*num2; 
				case '%'->	result=num1%num2; 
				case '/'->	{
					try{
						result=num1/num2; 
					}catch(ArithmeticException a){
						textField2.setText("Math Error");
					}
				}
				default->{
					result=num2;	textField1.setText(String.valueOf(result));
				}
				}
				textField2.setText(String.valueOf(result));
				num1=result;   num2=0;	 operator='\0';	prevOp='=';
			}
			if(ae.getSource()==clrButton){
				textField1.setText("");	textField2.setText("");	
				num1=0;	num2=0; result=0; operator='\0';  prevOp='\0';	
			}
			if(ae.getSource()==delButton){
				String temp=textField2.getText();	textField2.setText("");
				for(int i=0;i<temp.length()-1;i++)
					textField2.setText(textField2.getText().concat(String.valueOf(temp.charAt(i))));
			}
			if(ae.getSource()==sigButton){
				num1=Double.parseDouble(textField2.getText());	result=-(num1);		
				textField2.setText(String.valueOf(result));
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
	public static void main(String[] args){
		new Calculator();
	}
}
