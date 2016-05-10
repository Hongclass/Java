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
		//设置布局方式
		this.setLayout(new FlowLayout());
	 
	    //添加6个按钮，和1个文本框
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(bplus);
		this.add(bsub);
		this.add(bequal);
			
		this.add(text);
		
		
		
		//使Frame可见
		this.setVisible(true);
		
		//使Frame紧凑
		this.pack();
		
		//添加侦听器，为6个按钮添加
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
		{//如果点击了=，就开始计算
			SimpleCalculator run = new SimpleCalculator();
			
			double value = run.calculate(this.express);
			this.text.setText(Double.toString(value));
			this.express="";//计算完了，要把表达式清空
			
		}
		else{//如果点击其它按钮，就不断更改表达式。
		 
		    //由于e.getSource()返回的是Object对象，所以要转义为Button
			String label = ((Button)e.getSource()).getLabel();
			this.express += label;
			this.text.setText(this.express);
		}
	}
	
	
	
	public static void main(String[] s){
		
		MyCal cal = new MyCal();
		
	}
	
	
	
	
	
}