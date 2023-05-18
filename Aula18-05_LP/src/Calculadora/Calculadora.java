package Calculadora;

import Exemplo1.CapturaEventoBotao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora implements ActionListener {
    private JFrame frame;
    private JTextField textField;
    private JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private JButton buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonEqual, buttonClear;

    private double num1, num2;
    private String operator;

    public Calculadora() {
        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());

        textField = new JTextField();
        frame.add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        button7 = createButton("7", buttonPanel);
        button8 = createButton("8", buttonPanel);
        button9 = createButton("9", buttonPanel);
        buttonDivide = createButton("/", buttonPanel);

        button4 = createButton("4", buttonPanel);
        button5 = createButton("5", buttonPanel);
        button6 = createButton("6", buttonPanel);
        buttonMultiply = createButton("*", buttonPanel);

        button1 = createButton("1", buttonPanel);
        button2 = createButton("2", buttonPanel);
        button3 = createButton("3", buttonPanel);
        buttonSubtract = createButton("-", buttonPanel);

        button0 = createButton("0", buttonPanel);
        buttonEqual = createButton("=", buttonPanel);
        buttonClear = createButton("C", buttonPanel);
        buttonAdd = createButton("+", buttonPanel);

        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private JButton createButton(String label, JPanel panel) {
        JButton button = new JButton(label);
        button.addActionListener(this);
        panel.add(button);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9]")) {
            textField.setText(textField.getText() + command);
        } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            num1 = Double.parseDouble(textField.getText());
            operator = command;
            textField.setText("");
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            double result = calculateResult();
            textField.setText(String.valueOf(result));
        } else if (command.equals("C")) {
            textField.setText("");
        }
    }

    private double calculateResult() {
        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }

        return result;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculadora();
            }
        });
    }
}
