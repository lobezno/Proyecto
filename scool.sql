-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 29-05-2013 a las 23:40:50
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `centros`
--

CREATE TABLE IF NOT EXISTS `centros` (
  `idcentro` int(11) NOT NULL,
  `Nombre` int(11) NOT NULL,
  `Localidad` int(11) NOT NULL,
  `Provincia` int(11) NOT NULL,
  PRIMARY KEY (`idcentro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla profesores' AUTO_INCREMENT=1 ;

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
