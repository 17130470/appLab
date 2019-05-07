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
public class CalcAuthorization implements ActionListener{
	
	/* Главное окно */
    JFrame frameAut = new JFrame("Авторизация");
	/* Панель с метками */
    JPanel panelLeftAut = new JPanel();
	/* Панель с текстовыми полями */
    JPanel panelRightAut = new JPanel();
	/* Панель с кнопками */
    JPanel panelBottomAut = new JPanel();
	/* Массив текстовых полей */
    public JTextField[] fieldsAut = new JTextField[2];

    /* Конструктор */
    public CalcAuthorization() {
        /* Устанавливаем менеджер компоновки для панели с метками и выравнивание по вертикали */
        panelLeftAut.setLayout(new BoxLayout(panelLeftAut, BoxLayout.Y_AXIS));
        /* Устанавливаем размер gfytkb 250 на 300 пикселей */
        panelLeftAut.setPreferredSize(new Dimension(250, 300));

        /* Устанавливаем менеджер компоновки для панели с текстовыми полями и выравнивание по вертикали */
        panelRightAut.setLayout(new BoxLayout(panelRightAut, BoxLayout.Y_AXIS));
        /* Устанавливаем  размер 130 на 300 пикселей */
        panelRightAut.setPreferredSize(new Dimension(230,300));

        /* Добавляем метки через метод addLabel */
        addLabel(panelLeftAut, "Логин:", Color.BLACK);
        addLabel(panelLeftAut, "Пароль:", Color.BLACK);
        /* Добавляем текстовые поля через цикл и записываем их в массив */
        for(int i = 0; i < fieldsAut.length; i++){
            if(fieldsAut.length >= 0){
                /* Записываем ссылку из метода в массив для дальнейшей работы с текстовым полем */
                fieldsAut[i] = addTextField(panelRightAut);}
        }


        /* Добавляем кнопку подтверждения авторизации */
        JButton signInAut = addButton(panelBottomAut, "Авторизоваться");
        /* Добавляем слушатель на событие нажатия */
        signInAut.addActionListener(this);
		/* Добавляем кнопку сброса */
        JButton resetAut = addButton(panelBottomAut, "Сброс");
        /* Добавляем слушатель на событие нажатия */
        resetAut.addActionListener(this);


        /* Делаем главную форму видимой */
        frameAut.setVisible(true);
        /* Устанавливаем действие при нажатии на крестик - завершение приложения */
        frameAut.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* Устанавливаем начальное положение относительно центра экрана (по центру) */
        frameAut.setLocationRelativeTo(null);
        /* Устанавливаем размер главного окна(400 на 450) */
        frameAut.setSize(450,200);
        /* Добавляем метку с информацией в самый верх окна */
        JLabel topAut = new JLabel("Введите логин и пароль");
        /* Устанавливаем выравнивание текста в метке по центру */
        topAut.setHorizontalAlignment(JLabel.CENTER);

        /* Добавляем панели на клавное окно */
        frameAut.add(topAut, BorderLayout.NORTH);
        frameAut.add(panelLeftAut, BorderLayout.WEST);
        frameAut.add(panelRightAut, BorderLayout.EAST);
        frameAut.add(panelBottomAut, BorderLayout.SOUTH);
		/* Запрещаем изменение размеров главного окна */
        frameAut.setResizable(false);
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
    public void signIn() throws Exception {
    	String login = fieldsAut[0].getText();
    	String password = fieldsAut[1].getText();
    	String[] loginArray = {"Ard", "Bay", "Shay", "Step"};
    	String[] passwordArray = {"17130470", "17130175", "17130180", "17130705"};
    	
    	for (int i = 0; i < loginArray.length; i++) {
    		if ((login.equals(loginArray[i])) && (password.equals(passwordArray[i]))) {
        		Calculator calc = new Calculator();
        		calc.id = 1;
        		JOptionPane.showMessageDialog(null, "Авторизация пройдена успешно");
        		frameAut.setVisible(false);
        	}
    	}
    }
           
    /* Метод обработки события нажатия на кнопку */
    @Override
    public void actionPerformed(ActionEvent e) {
        /* Узнаем имя кнопки, на которую нажали */
        if (e.getActionCommand().equals("Авторизоваться")) {
            try {
                /* Выполнение авторизации */
            	signIn();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Проверьте правильность ввода");
            }
        }else{
            /* Очищаем все поля */
            for(int i=0; i<fieldsAut.length; i++){
                fieldsAut[i].setText("");
            }
        }
    }
    
    /* Главный метод класса, запускающий калькулятор */
    public void runAut() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalcAuthorization();
            }
        });
    }
}
