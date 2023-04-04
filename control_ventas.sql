-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-04-2023 a las 06:55:54
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `control_ventas`
--
CREATE DATABASE IF NOT EXISTS `control_ventas` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `control_ventas`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `ID_cliente` int(10) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  `Telefono` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`ID_cliente`, `Nombre`, `Apellidos`, `Telefono`) VALUES
(1, 'Esdras', 'Nehemias', '9631848340'),
(2, 'Juan', 'Perez', '9671450283'),
(3, 'Pedro', 'Mendez', '6647841547');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

CREATE TABLE `detalle_venta` (
  `ID_detalles` int(100) NOT NULL,
  `Cantidad` int(15) NOT NULL,
  `Precio_venta` double NOT NULL,
  `ID_venta` int(10) NOT NULL,
  `ID_producto` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle_venta`
--

INSERT INTO `detalle_venta` (`ID_detalles`, `Cantidad`, `Precio_venta`, `ID_venta`, `ID_producto`) VALUES
(121, 4, 350, 1, 1),
(122, 2, 500, 2, 3),
(123, 3, 350, 3, 1),
(124, 2, 250, 3, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `ID_producto` int(10) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Talla` int(5) NOT NULL,
  `Precio` double NOT NULL,
  `Stock` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`ID_producto`, `Nombre`, `Talla`, `Precio`, `Stock`) VALUES
(1, 'Botas Rojas', 26, 350, 25),
(2, 'Zapatos de verano', 22, 250, 30),
(3, 'Pantalones', 28, 500, 45);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID_Usuario` int(10) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  `Telefono` varchar(50) NOT NULL,
  `User` blob NOT NULL,
  `Password` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID_Usuario`, `Nombre`, `Apellidos`, `Telefono`, `User`, `Password`) VALUES
(1, 'Esdras Nehemias', 'Morales Monjaras', '9631848340', 0x657364726173, 0x6d6f72616c6573),
(2, 'Carlos', 'Monjaras', '9845124714', 0x6361726c6f736d, 0x3132333435);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `ID_venta` int(50) NOT NULL,
  `Fecha_venta` varchar(10) NOT NULL,
  `Monto` varchar(50) NOT NULL,
  `Usuario` varchar(50) NOT NULL,
  `ID_cliente` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`ID_venta`, `Fecha_venta`, `Monto`, `Usuario`, `ID_cliente`) VALUES
(1, '2022-2-26', '$1400.00', 'esdras', 1),
(2, '2022-2-26', '$1000.00', 'carlosm', 1),
(3, '2022-13-26', '$1550.00', 'esdras', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`ID_cliente`);

--
-- Indices de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD PRIMARY KEY (`ID_detalles`),
  ADD KEY `ID_venta` (`ID_venta`),
  ADD KEY `ID_producto` (`ID_producto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`ID_producto`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID_Usuario`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`ID_venta`),
  ADD KEY `ID_usuario` (`Usuario`),
  ADD KEY `ID_cliente` (`ID_cliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  MODIFY `ID_detalles` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=125;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD CONSTRAINT `detalle_venta_ibfk_2` FOREIGN KEY (`ID_producto`) REFERENCES `producto` (`ID_producto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`ID_cliente`) REFERENCES `cliente` (`ID_cliente`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
