INSERT INTO usuario (id, nombre, dni, apellidos, username, email, password, telefono, tiene_carnet_autoescuela, fecha_nacimiento, is_admin) VALUES (1, 'Juan', '12345678A', 'Pérez Gómez', 'admin', 'juan@example.com', '{bcrypt}$2y$10$FnVOEX.ACOsdRApkE1FmoeqD3HsncbSThYNlOj5gyW4dENGputb6a', '123456789', true, '2004-05-15', true);
INSERT INTO usuario (id, nombre, dni, apellidos, username, email, password, telefono, tiene_carnet_autoescuela, fecha_nacimiento, is_admin) VALUES (2, 'María', '87654321B', 'López García', 'user', 'maria@example.com', '{bcrypt}$2y$10$ZB.usHl6yiJdt7aR5M6Y2uirKqKK9V/KXIz1vPsdk.Cifa9Lt5AH6', '987654321', false, '2004-05-15', false);
INSERT INTO usuario (id, nombre, dni, apellidos, username, email, password, telefono, tiene_carnet_autoescuela, fecha_nacimiento, is_admin) VALUES (3, 'José', '23456789C', 'González Fernández', 'jose', 'jose@example.com', '{bcrypt}$2y$10$FnVOEX.ACOsdRApkE1FmoeqD3HsncbSThYNlOj5gyW4dENGputb6a', '555555555', true, '2004-03-20', false);
INSERT INTO usuario (id, nombre, dni, apellidos, username, email, password, telefono, tiene_carnet_autoescuela, fecha_nacimiento, is_admin) VALUES (4, 'Ana', '34567890D', 'Martínez Ruiz', 'ana', 'ana@example.com', '{bcrypt}$2y$10$FnVOEX.ACOsdRApkE1FmoeqD3HsncbSThYNlOj5gyW4dENGputb6a', '555555555', false, '2004-03-20', false);
INSERT INTO usuario (id, nombre, dni, apellidos, username, email, password, telefono, tiene_carnet_autoescuela, fecha_nacimiento, is_admin) VALUES (5, 'Carlos', '45678901E', 'Sánchez López', 'carlos', 'carlos@example.com', '{bcrypt}$2y$10$FnVOEX.ACOsdRApkE1FmoeqD3HsncbSThYNlOj5gyW4dENGputb6a', '123456789', true, '2003-10-25', false);
INSERT INTO usuario (id, nombre, dni, apellidos, username, email, password, telefono, tiene_carnet_autoescuela, fecha_nacimiento, is_admin) VALUES (6, 'Laura', '56789012F', 'García Martínez', 'laura', 'laura@example.com', '{bcrypt}$2y$10$ZB.usHl6yiJdt7aR5M6Y2uirKqKK9V/KXIz1vPsdk.Cifa9Lt5AH6', '987654321', false, '2003-07-12', false);
INSERT INTO usuario (id, nombre, dni, apellidos, username, email, password, telefono, tiene_carnet_autoescuela, fecha_nacimiento, is_admin) VALUES (7, 'David', '67890123G', 'Hernández García', 'david', 'david@example.com', '{bcrypt}$2y$10$FnVOEX.ACOsdRApkE1FmoeqD3HsncbSThYNlOj5gyW4dENGputb6a', '555555555', true, '2004-01-08', false);


ALTER SEQUENCE usuario_seq RESTART WITH 1000;


INSERT INTO vehiculo (tipo, num_bastidor, marca, modelo, anhos_antiguedad) VALUES ('coche', 1, 'Toyota', 'Corolla', 3);
INSERT INTO vehiculo (tipo, num_bastidor, marca, modelo, anhos_antiguedad) VALUES ('camión', 2, 'Volvo', 'FH16', 1);
INSERT INTO vehiculo (tipo, num_bastidor, marca, modelo, anhos_antiguedad) VALUES ('moto', 3, 'Honda', 'CBR600RR', 2);
INSERT INTO vehiculo (tipo, num_bastidor, marca, modelo, anhos_antiguedad) VALUES ('coche', 4, 'Ford', 'Focus', 2);
INSERT INTO vehiculo (tipo, num_bastidor, marca, modelo, anhos_antiguedad) VALUES ('coche', 5, 'Renault', 'Clio', 2);
INSERT INTO vehiculo (tipo, num_bastidor, marca, modelo, anhos_antiguedad) VALUES ('moto', 6, 'Yamaha', 'YZF-R6', 1);
INSERT INTO vehiculo (tipo, num_bastidor, marca, modelo, anhos_antiguedad) VALUES ('camión', 7, 'MAN', 'TGS', 3);


ALTER SEQUENCE vehiculo_seq RESTART WITH 1000;
INSERT INTO profesor (fecha_alta, fecha_baja, id, apellidos, nombre) VALUES ('2004-05-15', NULL, 1, 'López Maganha', 'Luis Miguel');
INSERT INTO profesor (fecha_alta, fecha_baja, id, apellidos, nombre) VALUES ('2004-05-15',NULL, 2, 'Naranjo González', 'Ángel');
INSERT INTO profesor (fecha_alta, fecha_baja, id, apellidos, nombre) VALUES ('2004-05-15',NULL, 3, 'Campos Rivera', 'Miguel');
INSERT INTO profesor (fecha_alta, fecha_baja, id, apellidos, nombre) VALUES ('2004-06-01', NULL, 4, 'Sánchez García', 'Pedro');
INSERT INTO profesor (fecha_alta, fecha_baja, id, apellidos, nombre) VALUES ('2005-03-15', NULL, 5, 'Ruiz González', 'Javier');
INSERT INTO profesor (fecha_alta, fecha_baja, id, apellidos, nombre) VALUES ('2006-07-20', NULL, 6, 'Rodríguez Martín', 'Carmen');
INSERT INTO profesor (fecha_alta, fecha_baja, id, apellidos, nombre) VALUES ('2007-01-10', NULL, 7, 'Gómez Sánchez', 'Luisa');


ALTER SEQUENCE profesor_seq RESTART WITH 1000;


INSERT INTO clase (esta_ocupada, fecha_clase, precio, id, profesor_id, usuario_id, vehiculo_num_bastidor) VALUES (false, '2004-05-15',39.99, 1, 1, 1, 1);
INSERT INTO clase (esta_ocupada, fecha_clase, precio, id, profesor_id, usuario_id, vehiculo_num_bastidor) VALUES (false, '2004-02-15', 40.22, 2, 2, 2, 2);
INSERT INTO clase (esta_ocupada, fecha_clase, precio, id, profesor_id, usuario_id, vehiculo_num_bastidor) VALUES (false, '2004-05-20', 41.99, 3, 3, 3, 3);
INSERT INTO clase (esta_ocupada, fecha_clase, precio, id, profesor_id, usuario_id, vehiculo_num_bastidor) VALUES (false, '2004-05-15', 39.99, 4, 4, 4, 4);
INSERT INTO clase (esta_ocupada, fecha_clase, precio, id, profesor_id, usuario_id, vehiculo_num_bastidor) VALUES (false, '2004-02-15', 40.22, 5, 5, 5, 5);
INSERT INTO clase (esta_ocupada, fecha_clase, precio, id, profesor_id, usuario_id, vehiculo_num_bastidor) VALUES (true, '2004-05-20', 41.99, 6, 6, 6, 6);

ALTER SEQUENCE clase_seq RESTART WITH 10000;

INSERT INTO compra_carnet(fechas_pk,usuario,carnet,fecha_inicio,fecha_fin);
ALTER SEQUENCE compra_carnet_seq RESTART WITH 10000;