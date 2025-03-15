package com.mycompany.chatclient;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.Vector;

public class ChatClient {
    private JFrame loginFrame, chatFrame;
    private JTextField nameField, serverField, portField, inputField;
    private JComboBox<String> colorBox, roomBox, userDropdown;
    private JTextArea chatArea;
    private JButton sendButton, backButton;
    private PrintWriter out;
    private String username, userColor, chatRoom;
    private Vector<String> userList;
    private JScrollPane scrollPane;

    // Constructor de la clase y función para mostrar la ventana de login
    public ChatClient() {
        showLoginWindow();
    }

    private void showLoginWindow() {
        loginFrame = new JFrame("🔧 Configuración del Chat");
        loginFrame.setSize(500, 600);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(null);
        loginFrame.setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("👤 Nombre:");
        nameLabel.setBounds(50, 50, 150, 30);
        loginFrame.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(200, 50, 220, 30);
        loginFrame.add(nameField);

        JLabel serverLabel = new JLabel("🌐 Servidor:");
        serverLabel.setBounds(50, 100, 150, 30);
        loginFrame.add(serverLabel);

        serverField = new JTextField("192.168.1.100");
        serverField.setBounds(200, 100, 220, 30);
        loginFrame.add(serverField);

        JLabel portLabel = new JLabel("🔌 Puerto:");
        portLabel.setBounds(50, 150, 150, 30);
        loginFrame.add(portLabel);

        portField = new JTextField("12345");
        portField.setBounds(200, 150, 220, 30);
        loginFrame.add(portField);

        JLabel colorLabel = new JLabel("🎨 Color:");
        colorLabel.setBounds(50, 200, 150, 30);
        loginFrame.add(colorLabel);

        String[] colors = {"Verde", "Gris", "Rosa", "Azul", "Naranja"};
        colorBox = new JComboBox<>(colors);
        colorBox.setBounds(200, 200, 220, 30);
        loginFrame.add(colorBox);

        JLabel roomLabel = new JLabel("🏠 Sala:");
        roomLabel.setBounds(50, 250, 150, 30);
        loginFrame.add(roomLabel);

        String[] rooms = {"Sala 1", "Sala 2", "Sala 3", "Sala 4", "Sala 5"};
        roomBox = new JComboBox<>(rooms);
        roomBox.setBounds(200, 250, 220, 30);
        loginFrame.add(roomBox);

        JButton startButton = new JButton("🚀 Iniciar Chat");
        startButton.setBounds(150, 320, 200, 50);
        loginFrame.add(startButton);

        startButton.addActionListener(e -> {
            username = nameField.getText().trim();
            userColor = (String) colorBox.getSelectedItem();
            chatRoom = (String) roomBox.getSelectedItem();
            String serverIP = serverField.getText();
            int port = Integer.parseInt(portField.getText());

            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(null, "⚠ Ingresa un nombre de usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            loginFrame.setVisible(false);
            startChatWindow(serverIP, port);
        });

        loginFrame.setVisible(true);
    }
