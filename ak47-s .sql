-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2022 at 03:20 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ak47-s`
--

-- --------------------------------------------------------

--
-- Table structure for table `billitem`
--

CREATE TABLE `billitem` (
  `id` int(10) NOT NULL,
  `date` datetime NOT NULL DEFAULT current_timestamp(),
  `productname` varchar(200) NOT NULL,
  `rate` varchar(50) NOT NULL,
  `qty` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `billprice`
--

CREATE TABLE `billprice` (
  `id` int(11) NOT NULL,
  `total` int(255) NOT NULL,
  `subtotal` int(255) NOT NULL,
  `paidamount` int(255) NOT NULL,
  `dueamount` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `itemID` int(10) NOT NULL,
  `itemName` varchar(255) NOT NULL,
  `Brand` varchar(100) NOT NULL,
  `Price` int(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `contity` int(2) NOT NULL,
  `sprice` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `id` int(50) NOT NULL,
  `subtotal` int(11) NOT NULL,
  `pay` int(11) NOT NULL,
  `balnce` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`id`, `subtotal`, `pay`, `balnce`) VALUES
(1, 26736, 30000, 3264);

-- --------------------------------------------------------

--
-- Table structure for table `sales_product`
--

CREATE TABLE `sales_product` (
  `id` int(15) NOT NULL,
  `sales_id` int(15) NOT NULL,
  `prod_id` int(15) NOT NULL,
  `price` int(15) NOT NULL,
  `qty` int(15) NOT NULL,
  `total` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sales_product`
--

INSERT INTO `sales_product` (`id`, `sales_id`, `prod_id`, `price`, `qty`, `total`) VALUES
(1, 1, 4, 4456, 5, 22280),
(2, 1, 4, 4456, 1, 4456);

-- --------------------------------------------------------

--
-- Table structure for table `stork`
--

CREATE TABLE `stork` (
  `id` int(10) NOT NULL,
  `itemname` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL,
  `quntity` varchar(5) NOT NULL,
  `companey` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stork`
--

INSERT INTO `stork` (`id`, `itemname`, `price`, `quntity`, `companey`) VALUES
(2, 'katta', '6546', '456', 'hfgh'),
(4, 'cvbcv', '4456', '5654', 'dsfsd');

-- --------------------------------------------------------

--
-- Table structure for table `supplierdetails`
--

CREATE TABLE `supplierdetails` (
  `ID` int(11) NOT NULL,
  `Sname` varchar(100) NOT NULL,
  `Cantact-Number` int(10) NOT NULL,
  `Companey` varchar(10) NOT NULL,
  `Joindate` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplierdetails`
--

INSERT INTO `supplierdetails` (`ID`, `Sname`, `Cantact-Number`, `Companey`, `Joindate`) VALUES
(1, 'gsdfgfd', 222, 'hfgh', '2022-12-08'),
(3, 'dfg', 58555, 'dsfsd', '2022-12-08');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `billitem`
--
ALTER TABLE `billitem`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `billprice`
--
ALTER TABLE `billprice`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`itemID`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sales_product`
--
ALTER TABLE `sales_product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stork`
--
ALTER TABLE `stork`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `supplierdetails`
--
ALTER TABLE `supplierdetails`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `billitem`
--
ALTER TABLE `billitem`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `billprice`
--
ALTER TABLE `billprice`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `itemID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `sales_product`
--
ALTER TABLE `sales_product`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `stork`
--
ALTER TABLE `stork`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `supplierdetails`
--
ALTER TABLE `supplierdetails`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
