import java.awt.event.*;
import java.awt.*;

public class MyCal extends Frame implements ActionListener{
	
	Button b1 = new Button("1");
	Button b2 = new Button("2");
	Button b3 = new Button("3");
	Button bplus = new Button("+");
	Button bsub = new Button("-");
	Button bequal = new Button("=");
	
	TextField text = new TextField(10);
	
	String express = "";
	
	MyCal()
	{
		//���ò��ַ�ʽ
		this.setLayout(new FlowLayout());
	 
	    //���6����ť����1���ı���
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(bplus);
		this.add(bsub);
		this.add(bequal);
			
		this.add(text);
		
		
		
		//ʹFrame�ɼ�
		this.setVisible(true);
		
		//ʹFrame����
		this.pack();
		
		//�����������Ϊ6����ť���
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		bplus.addActionListener(this);
		bsub.addActionListener(this);
		bequal.addActionListener(this);
	
		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		 if(e.getSource()==this.bequal)
		{//��������=���Ϳ�ʼ����
			SimpleCalculator run = new SimpleCalculator();
			
			double value = run.calculate(this.express);
			this.text.setText(Double.toString(value));
			this.express="";//�������ˣ�Ҫ�ѱ��ʽ���
			
		}
		else{//������������ť���Ͳ��ϸ��ı��ʽ��
		 
		    //����e.getSource()���ص���Object��������Ҫת��ΪButton
			String label = ((Button)e.getSource()).getLabel();
			this.express += label;
			this.text.setText(this.express);
		}
	}
	
	
	
	public static void main(String[] s){
		
		MyCal cal = new MyCal();
		
	}
	
	
	
	
	
}