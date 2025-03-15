    // Función para iniciar la ventana de chat y gestionar la barra superior
    private void startChatWindow(String serverIP, int port) {
        chatFrame = new JFrame(chatRoom + " - " + username);
        chatFrame.setSize(500, 600);
        chatFrame.setLayout(null);
        chatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chatFrame.setLocationRelativeTo(null);

        JPanel topBar = new JPanel();
        topBar.setBounds(0, 0, 500, 50);
        topBar.setLayout(null);

        switch (userColor) {
            case "Verde": topBar.setBackground(Color.GREEN); break;
            case "Gris": topBar.setBackground(Color.GRAY); break;
            case "Rosa": topBar.setBackground(new Color(255, 105, 180)); break;
            case "Azul": topBar.setBackground(Color.BLUE); break;
            case "Naranja": topBar.setBackground(Color.ORANGE); break;
        }

        backButton = new JButton("⬅");
        backButton.setBounds(10, 10, 50, 30);
        backButton.addActionListener(e -> {
            chatFrame.setVisible(false);
            showLoginWindow();
        });

        JLabel roomLabel = new JLabel(chatRoom, SwingConstants.CENTER);
        roomLabel.setBounds(200, 10, 100, 30);
        roomLabel.setForeground(Color.WHITE);

        userList = new Vector<>();
        userDropdown = new JComboBox<>(userList);
        userDropdown.setBounds(350, 10, 130, 30);

        topBar.add(backButton);
        topBar.add(roomLabel);
        topBar.add(userDropdown);
        chatFrame.add(topBar);
