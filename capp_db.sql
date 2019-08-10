-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 10, 2019 at 11:01 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 5.6.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `capp_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `contactId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `name` text NOT NULL,
  `phone` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` text NOT NULL,
  `remark` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`contactId`, `userId`, `name`, `phone`, `email`, `address`, `remark`) VALUES
(5, 5, 'irfan ansari', '14547479794', 'irfanas542@gmail.com', 'Harinagar Champaran', 'High School Harinagar'),
(6, 5, 'Sameer Ansari', '2154543', 'sameer@gmail.com', 'Rampur ', 'West Rampur'),
(10, 4, 'irfan ', '565649', 'irfanas542@gmail.com', 'Canada TOronto', 'ans'),
(15, 4, 'Asgar Ansari', '5511464', 'asgar@gmail.com', 'harinagar', 'champaran'),
(17, 4, 'Asgar Ansari', '5525454', 'asgar@gmail.com', 'harinagar', 'Delhi\r\n'),
(19, 4, 'sandhya kumari ggg', '54656 552 fghj', 'sandd@gmail.com', 'Harinagar dcvb', 'HSH dcv v'),
(20, 5, 'Rehan ', '6464662', 'rehan@gmail.com', 'Harinagar Champaran', 'Engineer'),
(21, 4, 'Rahul Kumar', '5456468', 'rahul@gmail.com', 'Haryana', 'Rocky'),
(22, 4, 'Hemanth ', '135464646', 'hema@gmail.com', 'hanamkonda waranla\r\ntelangan', 'Rathore');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userId` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(150) NOT NULL,
  `loginName` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` int(1) NOT NULL,
  `loginStatus` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `name`, `phone`, `email`, `address`, `loginName`, `password`, `role`, `loginStatus`) VALUES
(1, 'irfan', '7981784872', 'irfanas542@gmail.com', 'Hanamkonda', 'ansariboy', '1234', 1, 1),
(4, 'sameer', '454561548', 'sara123@gmail.com', 'madhavpur', 'sam', '2255', 2, 1),
(5, 'asgar ansari', '4548785545', 'asgar@gmail.com', 'Bettiah west champaran', 'ans', '786', 2, 1),
(6, 'sandhya ', '1454615454', 'msmukesh@gamil.com', 'Harinagar west champaran', 'sandhya', '420', 2, 1),
(7, 'rajkumar', '4644645487', 'rajkumar@gmail.com', 'warangal hanamkonda', 'raj', 'abc', 2, 1),
(8, 'unknown', '21315456', 'unknown@gmail.com', 'unknown place known town', 'rajkumar', '546', 2, 1),
(9, 'raj', 'fghjk', 'dmnmd', ' d m dm dm,d', 'raju', 'mc,m,', 2, 1),
(10, 'irfan ', '554798989', 'irfan@gamil.com', 'harinagar west champaran bihar', 'ansari', '123', 2, 1),
(11, 'sameer', '33453121', 'sam@gmail.com', 'lkjkm  jvkmlm vmmv vmv v;', 'sameer', '0000', 2, 1),
(13, 'rahul', '45464564', 'rahul@gmail.com', 'new delhi', 'akhtar', '0420', 2, 1),
(15, 'jio', '333113', 'jio@gmail.com', 'b n n   j m', 'jioG', '2255', 2, 1),
(16, 'chunni', '2312454646', 'chunni@gmail.com', 'warangal hanamkonda\r\ntelangana', 'chunnu', '7894', 2, 2),
(17, 'again ', '4646513', 'agian@gamil.com', 'zila west champaran\r\nbihar', 'baua', '420', 2, 1),
(18, 'Aayat ', '346464', 'aayat@gmail.com', 'New Delhi Greater Noida', 'Aayat', '123456', 2, 1),
(21, 'Aayat', '3146', 'aayat@gmail.com', 'Greater Noida Delhi', 'sara', '12345', 2, 1),
(22, '', '', '', '', 't', '', 2, 1),
(25, 'Deepak Kumar', '3234646123', 'deepakjha@gamil.com', 'Gujarat Surat', 'Deep', 'deep123', 2, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`contactId`),
  ADD KEY `contact_ibfk_1` (`userId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`),
  ADD UNIQUE KEY `loginName` (`loginName`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
  MODIFY `contactId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contact`
--
ALTER TABLE `contact`
  ADD CONSTRAINT `contact_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
