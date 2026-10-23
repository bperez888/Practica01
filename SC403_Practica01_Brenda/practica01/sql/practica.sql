-- =====================================================
-- Practica 01 - Catalogo de suculentas
-- Ejecutar con un usuario administrador (ej. root) en MySQL Workbench
-- =====================================================
DROP DATABASE IF EXISTS practica;
CREATE DATABASE practica
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

-- Usuario de la aplicacion
DROP USER IF EXISTS 'usuario_practica'@'%';
CREATE USER 'usuario_practica'@'%' IDENTIFIED BY 'la_Clave';
GRANT ALL PRIVILEGES ON practica.* TO 'usuario_practica'@'%';
FLUSH PRIVILEGES;

USE practica;

CREATE TABLE suculenta (
    id_suculenta      BIGINT        NOT NULL AUTO_INCREMENT,
    nombre_comun      VARCHAR(80)   NOT NULL,
    nombre_cientifico VARCHAR(120)  NOT NULL,
    familia           VARCHAR(60)   NOT NULL,
    color_principal   VARCHAR(40)   NOT NULL,
    altura_cm         DECIMAL(6,1)  NOT NULL,
    precio_estimado   DECIMAL(10,2) NOT NULL,
    nivel_riego       VARCHAR(30)   NOT NULL,
    ruta_imagen       VARCHAR(500)  NOT NULL,
    PRIMARY KEY (id_suculenta)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Registros de prueba
-- NOTA: las URLs apuntan a Wikimedia Commons (nube). Verifique que abran; si alguna no carga,
-- reemplacela por otra URL publica (la aplicacion muestra una imagen de respaldo si falla).
INSERT INTO suculenta
    (nombre_comun, nombre_cientifico, familia, color_principal, altura_cm, precio_estimado, nivel_riego, ruta_imagen)
VALUES
('Echeveria',          'Echeveria elegans',        'Crassulaceae',  'Verde azulado',   10.0, 3500.00, 'Bajo',
 'https://commons.wikimedia.org/wiki/Special:FilePath/Echeveria_elegans.jpg'),
('Aloe vera',          'Aloe vera',                'Asphodelaceae', 'Verde',           60.0, 6000.00, 'Moderado',
 'https://commons.wikimedia.org/wiki/Special:FilePath/Aloe_vera_flower_inset.png'),
('Planta de jade',     'Crassula ovata',           'Crassulaceae',  'Verde brillante', 45.0, 5500.00, 'Bajo',
 'https://commons.wikimedia.org/wiki/Special:FilePath/Crassula_ovata_1.jpg'),
('Haworthia cebra',    'Haworthiopsis fasciata',   'Asphodelaceae', 'Verde oscuro',    12.0, 4000.00, 'Moderado',
 'https://commons.wikimedia.org/wiki/Special:FilePath/Haworthia_fasciata.jpg'),
('Rosa de piedra',     'Sempervivum tectorum',     'Crassulaceae',  'Verde rojizo',     8.0, 2500.00, 'Bajo',
 'https://commons.wikimedia.org/wiki/Special:FilePath/Sempervivum_tectorum.jpg'),
('Cola de burro',      'Sedum morganianum',        'Crassulaceae',  'Verde grisaceo',  30.0, 7500.00, 'Bajo',
 'https://commons.wikimedia.org/wiki/Special:FilePath/Sedum_morganianum.jpg'),
('Piedras vivas',      'Lithops salicola',         'Aizoaceae',     'Gris',             3.0, 3000.00, 'Bajo',
 'https://commons.wikimedia.org/wiki/Special:FilePath/Lithops_salicola.jpg'),
('Kalanchoe',          'Kalanchoe blossfeldiana',  'Crassulaceae',  'Rojo',            25.0, 4500.00, 'Moderado',
 'https://commons.wikimedia.org/wiki/Special:FilePath/Kalanchoe_blossfeldiana.jpg');

SELECT * FROM suculenta;
