
INSERT INTO usuario  (id,nombre, dni, apellidos, usuario, email, contrasenha, telefono, tiene_carnet_autoescuela, dtype) VALUES (1,'Juan', '12345678A', 'Pérez Gómez', 'juanito123', 'juan@example.com', 'contraseña123', '123456789', true,'C');
INSERT INTO usuario  (id,nombre, dni, apellidos, usuario, email, contrasenha, telefono, tiene_carnet_autoescuela,dtype) VALUES (2,'María', '87654321B', 'López García', 'marialo', 'maria@example.com', 'clave123', '987654321', false,'C');
INSERT INTO usuario  (id,nombre, dni, apellidos, usuario, email, contrasenha, telefono, tiene_carnet_autoescuela,dtype) VALUES (3,'Carlos', '11223344C', 'Martinez Rodríguez', 'carlitos87', 'carlos@example.com', 'password123', '1122334455', true,'A');
alter sequence usuario_seq restart with (53);
