CREATE TABLE medico(
    id_medico BIGINT PRIMARY KEY AUTO_INCREMENT,
    rut_medico VARCHAR(13) UNIQUE NOT NULL,
    nombre_medico VARCHAR(50) NOT NULL,
    apellido_medico VARCHAR(50) NOT NULL,
    telefono_medico VARCHAR(15) NOT NULL,
    correo_medico VARCHAR(50) NOT NULL,
    id_especialidad BIGINT NOT NULL,
    annios_experiencia INT NOT NULL

);