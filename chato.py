import socket
import threading

# Configuración del servidor
host = "0.0.0.0"  
port = 12345      

# Preguntar si este dispositivo será el servidor o el cliente
modo = input("Escribe 'servidor' o 'cliente': ").strip().lower()

# Crear socket
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
