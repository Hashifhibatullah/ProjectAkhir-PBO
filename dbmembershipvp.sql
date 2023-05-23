-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2023 at 11:45 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbmembershipvp`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_membervp`
--

CREATE TABLE `data_membervp` (
  `NoHP` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `masaBerlaku` int(50) NOT NULL,
  `tipe_member` varchar(50) NOT NULL,
  `tanggal` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_membervp`
--

INSERT INTO `data_membervp` (`NoHP`, `nama`, `masaBerlaku`, `tipe_member`, `tanggal`) VALUES
('123', 'awda', 3, 'Silver', '21'),
('234', 'awda', 3, 'Silver', '21');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_membervp`
--
ALTER TABLE `data_membervp`
  ADD PRIMARY KEY (`NoHP`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
