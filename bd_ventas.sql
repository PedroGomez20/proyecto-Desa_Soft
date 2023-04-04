-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-12-2022 a las 20:39:00
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 5.6.39

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_ventas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `IdCliente` int(11) UNSIGNED NOT NULL,
  `Dni` varchar(8) CHARACTER SET utf8 DEFAULT NULL,
  `Nombres` varchar(244) CHARACTER SET utf8 DEFAULT NULL,
  `Direccion` varchar(244) CHARACTER SET utf8 DEFAULT NULL,
  `Estado` varchar(1) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ventas`
--

CREATE TABLE `detalle_ventas` (
  `IdDetalleVentas` int(11) UNSIGNED NOT NULL,
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `IdProducto` int(11) UNSIGNED NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `PrecioVenta` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `IdProducto` int(11) UNSIGNED NOT NULL,
  `Nombres` varchar(244) CHARACTER SET utf8 DEFAULT NULL,
  `Precio` double NOT NULL,
  `Stock` int(11) NOT NULL,
  `Estado` varchar(1) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedor`
--

CREATE TABLE `vendedor` (
  `IdVendedor` int(11) UNSIGNED NOT NULL,
  `Dni` varchar(8) CHARACTER SET utf8 DEFAULT NULL,
  `Nombres` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Telefono` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `Estado` varchar(1) CHARACTER SET utf8 DEFAULT NULL,
  `User` varchar(8) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vendedor`
--

INSERT INTO `vendedor` (`IdVendedor`, `Dni`, `Nombres`, `Telefono`, `Estado`, `User`) VALUES
(1, '12345678', 'Empleado 0001', '9631415782', '1', 'emp01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `IdCliente` int(11) UNSIGNED NOT NULL,
  `IdVendedor` int(11) UNSIGNED NOT NULL,
  `NumeroVentas` varchar(244) CHARACTER SET utf8 DEFAULT NULL,
  `FechaVentas` date DEFAULT NULL,
  `Monto` double DEFAULT NULL,
  `Estado` varchar(1) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`IdCliente`);

--
-- Indices de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD PRIMARY KEY (`IdDetalleVentas`),
  ADD KEY `IdVentas_fk` (`IdVentas`),
  ADD KEY `IdProducto_fk` (`IdProducto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`IdProducto`);

--
-- Indices de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`IdVendedor`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`IdVentas`),
  ADD KEY `IdCliente_fk` (`IdCliente`),
  ADD KEY `IdVendedor_fk` (`IdVendedor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `IdCliente` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  MODIFY `IdDetalleVentas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `IdProducto` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `vendedor`
--
ALTER TABLE `vendedor`
  MODIFY `IdVendedor` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `IdVentas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD CONSTRAINT `IdProducto_fk` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `IdVentas_fk` FOREIGN KEY (`IdVentas`) REFERENCES `ventas` (`IdVentas`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `IdCliente_fk` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `IdVendedor_fk` FOREIGN KEY (`IdVendedor`) REFERENCES `vendedor` (`IdVendedor`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
