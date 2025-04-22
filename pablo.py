//PabloApestoso
import tkinter as tk

# Clase que representa la aplicación
class HolaMundoApp:
    def __init__(self, master):
        self.master = master
        self.master.title("Aplicación Hola Mundo")
        self.master.geometry("300x150")
        
        self.etiqueta = tk.Label(master, text="Presiona el botón para saludar")
        self.etiqueta.pack(pady=10)
        
        self.boton = tk.Button(master, text="¡Saludar!", command=self.mostrar_mensaje)
        self.boton.pack()
        
        self.salida = tk.Label(master, text="")
        self.salida.pack(pady=10)

    def mostrar_mensaje(self):
        try:
            mensaje = self.generar_mensaje()
            self.salida
