CREATE TABLE especialidades(
    id_especialidad BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre_especialidad VARCHAR(50) NOT NULL,
    descripcion_especialidad VARCHAR(200) NOT NULL,
    area_medica VARCHAR(40) NOT NULL
);
