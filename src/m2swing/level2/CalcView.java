package m2swing.level2;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcView {

	private JFrame frm;
	private JPanel pan;
	private JTextField tf;
	private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	private JButton btnCls, btnEquals, btnPlus, btnMinus, btnMul, btnDiv;
	private GridLayout grid;
	private CalcWindowEventProcessor winEventProc;
	private CalcActionEventProcessor actionEventProc;

	public CalcView() {
		frm = new JFrame("사칙연산기");
		pan = new JPanel();
		tf = new JTextField();
		btn0 = new JButton("0");	btn1 = new JButton("1");	btn2 = new JButton("2");
		btn3 = new JButton("3");	btn4 = new JButton("4");	btn5 = new JButton("5");
		btn6 = new JButton("6");	btn7 = new JButton("7");	btn8 = new JButton("8");
		btn9 = new JButton("9");
		btnCls = new JButton("CLS");	btnEquals = new JButton("=");
		btnPlus = new JButton("+");		btnMinus = new JButton("-");
		btnMul = new JButton("*");		btnDiv = new JButton("/");
		grid = new GridLayout(4, 4);
	}

	public void makeGui() {
		frm.setSize(500, 500);
		frm.add(tf, BorderLayout.NORTH);
		frm.add(pan, BorderLayout.CENTER);
		//================================
		pan.setLayout(grid);
		pan.add(btn7);	pan.add(btn8);		pan.add(btn9);		pan.add(btnDiv);
		pan.add(btn4);	pan.add(btn5);		pan.add(btn6);		pan.add(btnMul);
		pan.add(btn1);	pan.add(btn2);		pan.add(btn3);		pan.add(btnMinus);
		pan.add(btn0);	pan.add(btnCls);	pan.add(btnEquals);	pan.add(btnPlus);
		//================================
		frm.setVisible(true);
	}

	public void addEvent() {
		winEventProc = new CalcWindowEventProcessor();
		frm.addWindowListener(winEventProc);
		actionEventProc = new CalcActionEventProcessor(tf);
		btn0.addActionListener(actionEventProc);	btn1.addActionListener(actionEventProc);
		btn2.addActionListener(actionEventProc);	btn3.addActionListener(actionEventProc);
		btn4.addActionListener(actionEventProc);	btn5.addActionListener(actionEventProc);
		btn6.addActionListener(actionEventProc);	btn7.addActionListener(actionEventProc);
		btn8.addActionListener(actionEventProc);	btn9.addActionListener(actionEventProc);
		btnCls.addActionListener(actionEventProc);	btnEquals.addActionListener(actionEventProc);
		btnPlus.addActionListener(actionEventProc);	btnMinus.addActionListener(actionEventProc);
		btnMul.addActionListener(actionEventProc);	btnDiv.addActionListener(actionEventProc);
	}

	public static void main(String[] args) {
		CalcView cv = new CalcView();
		cv.makeGui();
		cv.addEvent();
	} // main

} // class
