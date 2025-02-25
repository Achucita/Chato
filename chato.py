import socket
import threading

# Configuración del servidor
host = "0.0.0.0"  
port = 12345      

# Preguntar si este dispositivo será el servidor o el cliente
modo = input("Escribe 'servidor' o 'cliente': ").strip().lower()

# Crear socket
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Configuración del servidor
if modo == "servidor":
    sock.bind((host, port))
    sock.listen(1)
    print(f"Esperando conexiones en {host}:{port}...")
    conn, addr = sock.accept()
    print(f"Conectado a {addr}")


#Función para recibir mensajes en un hilo separado
def recibir_mensajes():
    while True:
        try:
            mensaje = conn.recv(1024).decode()
            if not mensaje:
                break
            print("\nMensaje recibido:\n", mensaje)
        except:
            break

# Iniciar hilo para recibir mensajes
t = threading.Thread(target=recibir_mensajes, daemon=True)
t.start()
