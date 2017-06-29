-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 29, 2017 at 03:15 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bankweb`
--

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `id` int(11) NOT NULL,
  `accountnumber` int(11) NOT NULL,
  `balance` int(11) DEFAULT NULL,
  `dailydepofrequency` int(11) DEFAULT NULL,
  `dailywithdrawalfrequency` int(11) DEFAULT NULL,
  `datedeposited` varchar(50) DEFAULT NULL,
  `datewithdrawn` varchar(50) DEFAULT NULL,
  `deposited` int(11) DEFAULT NULL,
  `withdrawn` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`id`, `accountnumber`, `balance`, `dailydepofrequency`, `dailywithdrawalfrequency`, `datedeposited`, `datewithdrawn`, `deposited`, `withdrawn`) VALUES
(1, 102999292, 40000, 1, 1, '26-06-2017', '26-06-2017', 3000, 300),
(2, 102999292, 40500, 2, 1, '29-06-2017', '26-06-2017', 500, 300),
(3, 102999292, 41000, 3, 1, '29-06-2017', '26-06-2017', 500, 300),
(4, 102999292, 40800, 3, 2, '29-06-2017', '29-06-2017', 500, 200);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
