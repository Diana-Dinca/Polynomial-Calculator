package gui;

import model.Polynomial;
import operations.Operations;
import operations.OperationsInterface;
import operations.PolynomialConvertor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static operations.PolynomialConvertor.parsePolynomial;

public class CalculatorGUI extends JFrame implements ActionListener {
    private JTextField p1Field;
    private JTextField p2Field;
    private JTextField result1Field;
    private JTextField result2Field;
    private JLabel result1Label;
    private JLabel result2Label;
    private JButton addButton;
    private JButton subButton;
    private JButton divisionButton;
    private JButton multiplicationButton;
    private JButton differentiationButton;
    private JButton integrationButton;

    public CalculatorGUI() {
        setTitle("Polynomial Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.put("Button.background", new Color(93, 143, 236));
        defaults.put("Button.foreground", Color.BLACK);

        p1Field = new JTextField(30);
        p2Field = new JTextField(30);
        p2Field.setVisible(false);

        result1Field = new JTextField(30);
        result1Field.setEditable(false);
        result1Field.setVisible(false);
        result2Field = new JTextField(30);
        result2Field.setEditable(false);
        result2Field.setVisible(false);

        addButton = new JButton("Add");
        addButton.addActionListener(this);
        subButton = new JButton("Subtract");
        subButton.addActionListener(this);

        divisionButton = new JButton("Divide");
        divisionButton.addActionListener(this);
        multiplicationButton = new JButton("Multiply");
        multiplicationButton.addActionListener(this);

        differentiationButton = new JButton("Differentiate");
        differentiationButton.addActionListener(this);
        integrationButton = new JButton("Integrate");
        integrationButton.addActionListener(this);

        JPanel bigPanel = new JPanel();
        bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.Y_AXIS));

        JPanel panelP1= new JPanel();
        panelP1.add(new JLabel("Polynomial 1: "));
        panelP1.add(p1Field);
        JPanel panelP2= new JPanel();
        JLabel polynom2Label = new JLabel("Polynomial 2: ");
        polynom2Label.setVisible(false);
        panelP2.add(polynom2Label);
        panelP2.add(p2Field);
        JButton polynom2Button = new JButton("+ Polynomial 2");
        polynom2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p2Field.setVisible(true);
                polynom2Label.setVisible(true);
                polynom2Button.setVisible(false);
            }
        });
        panelP2.add(polynom2Button);

        JPanel panelR1= new JPanel();
        result1Label= new JLabel("Result: ");
        result1Label.setVisible(false);
        panelR1.add(result1Label);
        panelR1.add(result1Field);

        JPanel panelR2= new JPanel();
        result2Label= new JLabel("Remainder: ");
        result2Label.setVisible(false);
        panelR2.add(result2Label);
        panelR2.add(result2Field);

        JPanel panelAddSubDivMul= new JPanel();
        panelAddSubDivMul.add(addButton);
        panelAddSubDivMul.add(subButton);
        panelAddSubDivMul.add(divisionButton);
        panelAddSubDivMul.add(multiplicationButton);
        JPanel panelDifInt= new JPanel();
        panelDifInt.add(differentiationButton);
        panelDifInt.add(integrationButton);

        bigPanel.add(panelP1);
        bigPanel.add(panelP2);
        bigPanel.add(panelAddSubDivMul);
        bigPanel.add(panelDifInt);

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        resultPanel.add(panelR1);
        resultPanel.add(panelR2);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(bigPanel, BorderLayout.NORTH);
        getContentPane().add(resultPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        PolynomialConvertor pc= new PolynomialConvertor();
        String polynomial1 = p1Field.getText();
        String polynomial2 = p2Field.getText();
        OperationsInterface op= new Operations();
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1= parsePolynomial(polynomial1);
        p2= parsePolynomial(polynomial2);

        if (e.getSource() == addButton || e.getSource() == subButton ||
                e.getSource() == multiplicationButton || e.getSource() == divisionButton) {
            //we need 2 valid polynomials
            if(p1.getMonomials().firstEntry()==null)
            {
                JOptionPane.showMessageDialog(this, "Polynomial 1 is not valid", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(p2.getMonomials().firstEntry()==null)
            {
                JOptionPane.showMessageDialog(this, "Polynomial 2 is not valid", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (e.getSource() == addButton) {
                result1Field.setText(op.add(p1, p2).toString());

            } else if (e.getSource() == subButton) {
                result1Field.setText(op.sub(p1, p2).toString());

            } else if (e.getSource() == divisionButton) {
                //x^3-2x^2+6x-5
                //x^2-1
                Polynomial[] result= op.division(p1, p2);

                result1Field.setText(result[0].toString());
                result2Field.setText(result[1].toString());

            } else if (e.getSource() == multiplicationButton) {
                result1Field.setText(op.multiplication(p1, p2).toString());

            }
        }
        else {
            //we need only 1 valid polynomial
            if(p1.getMonomials().firstEntry()!=null && p2.getMonomials().firstEntry()!=null)
            {
                JOptionPane.showMessageDialog(this, "Introduce only 1 polynomial!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if(p1.getMonomials().firstEntry()!=null && p2.getMonomials().firstEntry()==null) {
                if (e.getSource() == differentiationButton) {
                    result1Field.setText(op.differentiation(p1).toString());

                } else if (e.getSource() == integrationButton) {
                    result1Field.setText(op.integration(p1).toString()+"+C");

                }
            }
            else if(p1.getMonomials().firstEntry()==null && p2.getMonomials().firstEntry()!=null) {
                if (e.getSource() == differentiationButton) {
                    result1Field.setText(op.differentiation(p2).toString());

                } else if (e.getSource() == integrationButton) {
                    result1Field.setText(op.integration(p2).toString()+"+C");

                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Polynomial is not valid", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

        }
        if (e.getSource() == addButton || e.getSource() == subButton ||
                e.getSource() == multiplicationButton || e.getSource() == differentiationButton || e.getSource() == integrationButton) {
            result1Label.setVisible(true);
            result1Field.setVisible(true);
            result2Label.setVisible(false);
            result2Field.setVisible(false);
        } else if (e.getSource() == divisionButton) {
            result1Label.setVisible(true);
            result1Field.setVisible(true);
            result2Label.setVisible(true);
            result2Field.setVisible(true);
        }
    }
    public static void main(String[] args) {
        new CalculatorGUI().setVisible(true);
    }
}
