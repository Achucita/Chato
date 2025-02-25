# Configuración inicial y creación del socket
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

# Configuración del cliente
else:
    server_ip = input("Introduce la IP del servidor: ").strip()
    sock.connect((server_ip, port))
    conn = sock  # En modo cliente, usamos directamente sock

# Función para recibir mensajes en un hilo separado
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

# Envío de mensajes y cierre de conexión
while True:
    mensaje = input("Escribe un mensaje: ")
    if mensaje.lower() == "salir":
        break
    conn.send(mensaje.encode())

conn.close()
