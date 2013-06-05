-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 04-06-2013 a las 23:09:46
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `scool`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE IF NOT EXISTS `alumnos` (
  `idalumno` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `direccion` varchar(120) NOT NULL,
  `email` varchar(25) NOT NULL,
  `password` varchar(15) NOT NULL,
  `telefono` int(9) NOT NULL,
  `centro` int(11) NOT NULL,
  `curso` varchar(3) NOT NULL,
  `club` int(11) NOT NULL,
  PRIMARY KEY (`idalumno`,`club`),
  KEY `club` (`club`),
  KEY `centro` (`centro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`idalumno`, `nombre`, `apellidos`, `dni`, `direccion`, `email`, `password`, `telefono`, `centro`, `curso`, `club`) VALUES
(1, 'Antonio', 'Pardeza Gomez', '72154578F', 'Calle Pando nº 3 3ºF', 'anto@parde.com', '1234', 942851456, 1, '1A', 1),
(2, 'Juan', 'De Dios', '721458935', 'Calle Las Rosas nº4 4ºJ', 'jdios@mail.com', '1234', 942584758, 2, '1B', 1),
(3, 'Isabel', 'Fernandez Garcia', '72568545W', 'Calle Sierra nº3 9ºH', 'isa@mail.com', '1234', 618452365, 3, '2A', 2),
(4, 'Beatriz', 'Lopez Ingunza', '72651534O', 'Calle Piruleta nº2 8ºA', 'bea@gmail.com', '1234', 685324592, 4, '1A', 3),
(5, 'Sonia', 'Velez Estibez', '72451478U', 'Calle Carmona nº1 1ºA', 'soni@mail.com', '1234', 613256478, 1, '1A', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `centros`
--

CREATE TABLE IF NOT EXISTS `centros` (
  `idcentro` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Localidad` varchar(20) NOT NULL,
  `Provincia` varchar(20) NOT NULL,
  PRIMARY KEY (`idcentro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `centros`
--

INSERT INTO `centros` (`idcentro`, `Nombre`, `Localidad`, `Provincia`) VALUES
(1, 'I.E.S. Miguel Herrer', 'Torrelavega', 'Cantabria'),
(2, 'I.E.S Zapatón', 'Torrelavega', 'Cantabria'),
(3, 'I.E.S. Augusto Garci', 'Santander', 'Cantabria'),
(4, 'I.E.S. Barajas', 'Madrid', 'Madrid'),
(5, 'Colegio Nuestra Seño', 'Torrelavega', 'Cantabria'),
(6, 'Universidad de Ovied', 'Oviedo', 'Asturias');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clubs`
--

CREATE TABLE IF NOT EXISTS `clubs` (
  `idclub` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `actividad` varchar(200) NOT NULL,
  `miembros` int(11) NOT NULL,
  PRIMARY KEY (`idclub`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clubs`
--

INSERT INTO `clubs` (`idclub`, `nombre`, `actividad`, `miembros`) VALUES
(1, 'Jaque Mate', 'Ajedrez', 0),
(2, 'CorreCorre', 'Atletismo', 0),
(3, 'Extra Life', 'Videojuegos', 0),
(4, 'MundoLibro', 'Lectura', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materias`
--

CREATE TABLE IF NOT EXISTS `materias` (
  `idmateria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  PRIMARY KEY (`idmateria`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `materias`
--

INSERT INTO `materias` (`idmateria`, `nombre`, `descripcion`) VALUES
(1, 'Matemáticas', 'Materia sobre números.'),
(2, 'Lenguaje', 'Materia sobre la lengua castellana.'),
(3, 'Fisica', 'Materia sobre la física de la tierra.'),
(4, 'Dibujo', 'Materia de creación artística.'),
(5, 'Educación Física', 'Materia deportiva.'),
(6, 'Tutoría', 'Charlas con el tutor.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `padres`
--

CREATE TABLE IF NOT EXISTS `padres` (
  `idpadre` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `direccion` varchar(120) NOT NULL,
  `email` varchar(25) NOT NULL,
  `password` varchar(15) NOT NULL,
  `telefono` int(9) NOT NULL,
  `hijo` int(11) NOT NULL,
  PRIMARY KEY (`idpadre`),
  KEY `hijo` (`hijo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `padres`
--

INSERT INTO `padres` (`idpadre`, `nombre`, `apellidos`, `dni`, `direccion`, `email`, `password`, `telefono`, `hijo`) VALUES
(1, 'Juan Antonio', 'Pardeza Gutierrez', '72564815P', 'Calle Pando nº 3 3ºF', 'juanan@papi.com', '1234', 616856415, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE IF NOT EXISTS `profesores` (
  `idprofesor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `direccion` varchar(120) NOT NULL,
  `email` varchar(25) NOT NULL,
  `password` varchar(15) NOT NULL,
  `telefono` int(9) NOT NULL,
  `centro` int(11) NOT NULL,
  `materia` int(11) NOT NULL,
  `padrino` tinyint(1) NOT NULL,
  `club` int(11) NOT NULL,
  PRIMARY KEY (`idprofesor`),
  KEY `club` (`club`),
  KEY `materia` (`materia`),
  KEY `centro` (`centro`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COMMENT='Tabla profesores' AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `profesores`
--

INSERT INTO `profesores` (`idprofesor`, `nombre`, `apellidos`, `dni`, `direccion`, `email`, `password`, `telefono`, `centro`, `materia`, `padrino`, `club`) VALUES
(1, 'Ramiro', 'Carballo Lopez', '72548312A', 'Calle Falsa nº123 1ºH', 'ramiro@profe.com', '1234', 914785623, 1, 1, 1, 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD CONSTRAINT `alumnos_ibfk_1` FOREIGN KEY (`club`) REFERENCES `clubs` (`idclub`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `alumnos_ibfk_2` FOREIGN KEY (`centro`) REFERENCES `centros` (`idcentro`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `padres`
--
ALTER TABLE `padres`
  ADD CONSTRAINT `padres_ibfk_1` FOREIGN KEY (`hijo`) REFERENCES `alumnos` (`idalumno`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD CONSTRAINT `profesores_ibfk_1` FOREIGN KEY (`club`) REFERENCES `clubs` (`idclub`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `profesores_ibfk_2` FOREIGN KEY (`materia`) REFERENCES `materias` (`idmateria`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `profesores_ibfk_3` FOREIGN KEY (`centro`) REFERENCES `centros` (`idcentro`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
