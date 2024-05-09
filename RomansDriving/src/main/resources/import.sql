-- Insertar datos en la tabla Usuario
INSERT INTO usuario (id, nombre, dni, apellidos,username, email, password, telefono, tiene_carnet_autoescuela, fecha_nacimiento, is_admin) VALUES (1, 'Juan', '12345678A', 'Pérez Gómez', 'juanito123', 'juan@example.com', 'contraseña123', '123456789', true, '2004-05-15', false);
INSERT INTO usuario (id, nombre, dni, apellidos,username, email, password, telefono, tiene_carnet_autoescuela, fecha_nacimiento, is_admin) VALUES (2, 'María', '87654321B', 'López García', 'marialo', 'maria@example.com', 'clave123', '987654321', false, '2004-05-15', false);
INSERT INTO usuario (id, nombre, dni, apellidos,username, email, password, telefono, tiene_carnet_autoescuela, fecha_nacimiento, is_admin) VALUES (3, 'Carlos', '11223344C', 'Martinez Rodríguez', 'carlitos87', 'carlos@example.com', 'password123', '1122334455', true, '2004-05-15', false);
INSERT INTO usuario (id, nombre, dni, apellidos,username, email, password, telefono, tiene_carnet_autoescuela, fecha_nacimiento, is_admin) VALUES (4, 'Juan', '12345678A', 'Pérez Gómez', 'admin', 'juan@example.com', '{bcrypt}$2a$12$EhsO83mRb86phLnCqTdWQeCKmJO0AeprMWy32TMeHaAW/fmwmwJiC', '123456789', true, '2004-05-15', true);
INSERT INTO usuario (id, nombre, dni, apellidos,username, email, password, telefono, tiene_carnet_autoescuela, fecha_nacimiento, is_admin) VALUES (5, 'María', '87654321B', 'López García', 'user', 'maria@example.com', '{bcrypt}$2a$12$jbe8n81L7HS.Qv9zNPLK.uEPomcOzgLEqO/Ue0olbzvIna4a80b5i', '987654321', false, '2004-05-15', false);
ALTER SEQUENCE usuario_seq RESTART WITH 55;
--
---- Insertar datos en la tabla Vehiculo
INSERT INTO vehiculo (tipo, num_bastidor, marca, modelo, anhos_antiguedad) VALUES ('coche', 1, 'Toyota', 'Corolla', 3);
INSERT INTO vehiculo (tipo, num_bastidor, marca, modelo, anhos_antiguedad) VALUES ('camion', 2, 'Volvo', 'FH16', 1);
INSERT INTO vehiculo (tipo, num_bastidor, marca, modelo, anhos_antiguedad) VALUES ('moto', 3, 'Honda', 'CBR600RR', 2);

ALTER SEQUENCE vehiculo_seq RESTART WITH 53;
--
--
---- Insertar datos en la tabla Profesor
INSERT INTO profesor (fecha_alta, fecha_baja, id, apellidos, nombre) VALUES ('2004-05-15', '2004-05-20', 1, 'Lopez Maganha', 'Luis Miguel');
INSERT INTO profesor (fecha_alta, fecha_baja, id, apellidos, nombre) VALUES ('2004-05-15', '2004-05-20', 2, 'Naranjo Gonzalez', 'Angel');
INSERT INTO profesor (fecha_alta, fecha_baja, id, apellidos, nombre) VALUES ('2004-05-15', '2004-05-20', 3, 'Campos Rivera', 'Miguel');
ALTER SEQUENCE profesor_seq RESTART WITH 53;
--
--
---- Insertar datos en la tabla Clase
INSERT INTO clase (esta_ocupada, fecha_clase, precio, id, profesor_id, usuario_id, vehiculo_num_bastidor) VALUES (false, '2004-05-15', 1.0, 1, 1, 1, 1);
INSERT INTO clase (esta_ocupada, fecha_clase, precio, id, profesor_id, usuario_id, vehiculo_num_bastidor) VALUES (true, '2004-02-15', 1.0, 2, 2, 2, 2);
INSERT INTO clase (esta_ocupada, fecha_clase, precio, id, profesor_id, usuario_id, vehiculo_num_bastidor) VALUES (false, '2004-05-15', 1.0, 3, 3, 3, 3);
ALTER SEQUENCE clase_seq RESTART WITH 53;


