package com.calculator;

/* Добавляем библиотеки для работы с текстовыми полями, метками, для создания графического окна */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

/* Главный класс, реализующий интерфейс ActionListener, который отвечает за обработку события нажатия на кнопку */
public class Calculator implements ActionListener{
	public int id = 0;
	
	/* Главное окно */
    JFrame frame = new JFrame("Расчет количества символов в тексте");
	/* Панель с метками */
    JPanel panelLeft = new JPanel();
	/* Панель с текстовыми полями */
    JPanel panelRight = new JPanel();
	/* Панель с кнопками */
    JPanel panelBottom = new JPanel();
	/* Массив текстовых полей */
    public JTextField[] fields = new JTextField[2];

    /* Конструктор */
    public Calculator() {
        /* Устанавливаем менеджер компоновки для панели с метками и выравнивание по вертикали */
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        /* Устанавливаем размер 250 на 300 пикселей */
        panelLeft.setPreferredSize(new Dimension(250, 300));

        /* Устанавливаем менеджер компоновки для панели с текстовыми полями и выравнивание по вертикали */
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        /* Устанавливаем  размер 130 на 300 пикселей */
        panelRight.setPreferredSize(new Dimension(370,300));

        /* Добавляем метки через метод addLabel */
        addLabel(panelLeft, "Текст:", Color.BLACK);
        addLabel(panelLeft, "Количество символов в тексте:", Color.BLACK);
        /* Добавляем текстовые поля через цикл и записываем их в массив */
        for(int i = 0; i < fields.length; i++){
            if(fields.length >= 0){
                /* Записываем ссылку из метода в массив для дальнейшей работы с текстовым полем */
                fields[i] = addTextField(panelRight);}
        }


        /* Добавляем кнопку расчета количества символов */
        JButton calc = addButton(panelBottom, "Расчет символов");
        /* Добавляем слушатель на событие нажатия */
        calc.addActionListener(this);
		/* Добавляем кнопку сброса */
        JButton reset = addButton(panelBottom, "Сброс");
        /* Добавляем слушатель на событие нажатия */
        reset.addActionListener(this);
		/* Добавляем кнопку авторизации */
        JButton authorization = addButton(panelBottom, "Авторизация");
        /* Добавляем слушатель на событие нажатия */
        authorization.addActionListener(this);
        /* Добавляем кнопку расчета количества знаков препинания */
        JButton punMarks = addButton(panelBottom, "Расчет точек и запятых");
        /* Добавляем слушатель на событие нажатия */
        punMarks.addActionListener(this);


        /* Делаем главную форму видимой */
        frame.setVisible(true);
        /* Устанавливаем действие при нажатии на крестик - завершение приложения */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* Устанавливаем начальное положение относительно центра экрана (по центру) */
        frame.setLocationRelativeTo(null);
        /* Устанавливаем размер главного окна(650 на 200) */
        frame.setSize(600,200);
        /* Добавляем метку с информацией в самый верх окна */
        JLabel top = new JLabel("Первое поле является обязательным для заполнения");
        /* Устанавливаем выравнивание текста в метке по центру */
        top.setHorizontalAlignment(JLabel.CENTER);

        /* Добавляем панели на клавное окно */
        frame.add(top, BorderLayout.NORTH);
        frame.add(panelLeft, BorderLayout.WEST);
        frame.add(panelRight, BorderLayout.EAST);
        frame.add(panelBottom, BorderLayout.SOUTH);
		/* Запрещаем изменение размеров главного окна */
        frame.setResizable(false);
    }


    /* Метод добавления текстовых меток */
    public void addLabel(JComponent container, String name, Color color){
        /* Создаем текстовую метку с именем name */
        JLabel label = new JLabel(name);
        /* Устанавливаем максимально допустимый размер */
        label.setMaximumSize(new Dimension(200,20));
        /* Устанавливаем цвета текста */
        label.setForeground(color);
        /* Устанавливаем выравнивание по правому краю */
        label.setHorizontalAlignment(JLabel.RIGHT);
        /* Добавляем рамку */
        label.setBorder(new EtchedBorder());
        /* Добавляем текстовую метку в панель */
        container.add(label);
    }

    /* Метод добавления текстовых полей */
    public JTextField addTextField(JComponent container){
        /* Создаем текстовое поле */
        JTextField field = new JTextField();
        /* Устанавливаем максимально допустимый размер поля */
        field.setMaximumSize(new Dimension(350,20));
        /* Добавляем текстовое поле на панель */
        container.add(field);
        /* Возвращаем ссылку на текстовое поле */
        return field;
    }

    /* Метод добавления кнопок */
    public JButton addButton(JComponent container, String name){
        /* Создаем кнопку */
        JButton button = new JButton(name);
        /* Устанавливаем максимально допустимый размер */
        button.setMaximumSize(new Dimension(100,20));
        /* Выравниваем по горизонтали по центру */
        button.setHorizontalAlignment(JButton.CENTER);
        /* Добавляем кнопку на панель */
        container.add(button);
        /* Возвращаем ссылку на кнопку */
        return button;
    }
    
    /* Метод расчета количества символов */
    public void calculate() throws Exception {
		/* Записываем введенный текст из поля ввода в переменную */
    	String getText = fields[0].getText();
		/* Рассчитываем длину введенного текста */
        String valueOf = String.valueOf(getText.length());
		/* Записываем результат расчета в поле вывода */
        fields[1].setText(valueOf);
    }
    
    /* Метод расчета количества знаков препинания */
    public void calculatePunMarks() throws Exception {
		/* Записываем введенный текст из поля ввода в переменную */
    	int valueOf = 0;
    	String getText = fields[0].getText();
    	for (int i = 0; i < getText.length(); i++) {
    		if ((getText.charAt(i) == ',') || (getText.charAt(i) == '.')) {
    			valueOf += 1;
    		}
    	}
    	String result = String.valueOf(valueOf);
		/* Записываем результат расчета в поле вывода */
        fields[1].setText(result);
    } 

    /* Метод обработки события нажатия на кнопку */
    @Override
    public void actionPerformed(ActionEvent e) {
        /* Узнаем имя кнопки, на которую нажали */
        if (e.getActionCommand().equals("Расчет символов")) {
            try {
                /* Выполняем расчет */
                calculate();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Проверьте правильность ввода");
            }
        } else if (e.getActionCommand().equals("Авторизация")) {
        	try {
                /* Запускает процесс авторизации */
                CalcAuthorization calcAut = new CalcAuthorization();
                calcAut.runAut();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Проверьте правильность ввода");
            }
        } else if (e.getActionCommand().equals("Расчет точек и запятых")) {
        	try {
                if(id == 0) {
                	JOptionPane.showMessageDialog(null, "Авторизируйтесь, чтобы получить доступ к этой функции");
                } else if (id == 1) {
                	calculatePunMarks();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Проверьте правильность ввода");
            } 
        } else{
            /* Очищаем все поля */
            for(int i=0; i<fields.length; i++){
                fields[i].setText("");
            }
        }
    }
    
    /* Главный метод класса, запускающий калькулятор */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator();
            }
        });
    }
}