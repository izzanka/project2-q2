-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 13, 2022 at 03:58 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `adidas_store`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `name`) VALUES
(1, 'skateboard'),
(2, 'lifestyle'),
(3, 'running');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `status` varchar(20) NOT NULL,
  `total_qty` int(11) NOT NULL,
  `total_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `user_id`, `status`, `total_qty`, `total_price`) VALUES
(12, 2, 'ordered', 1, 3300000),
(13, 2, 'on cart', 3, 6600000);

-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--

CREATE TABLE `order_details` (
  `id` int(11) NOT NULL,
  `shoe_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `size` int(11) NOT NULL,
  `total_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_details`
--

INSERT INTO `order_details` (`id`, `shoe_id`, `order_id`, `qty`, `size`, `total_price`) VALUES
(10, 5, 12, 1, 34, 3300000),
(11, 10, 13, 1, 39, 2200000),
(12, 10, 13, 2, 39, 4400000);

-- --------------------------------------------------------

--
-- Table structure for table `shoes`
--

CREATE TABLE `shoes` (
  `id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `description` text NOT NULL,
  `price` int(11) NOT NULL,
  `sold` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `size` int(11) NOT NULL,
  `images` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shoes`
--

INSERT INTO `shoes` (`id`, `category_id`, `name`, `description`, `price`, `sold`, `stock`, `size`, `images`) VALUES
(1, 2, 'RETROPY E5 SHOES\r\n\r\n', 'For the Retropy E5 Shoes, we started with the foundation of the famed adidas Racing 1 trainers and then built off it to create what you see here: a highly modernised shape with hints of sports nostalgia. The premium upper and luxe suede details come together to emphasise the more progressive look. Plush BOOST cushioning keeps the vibe high with its unparalleled comfort.', 2200000, 30, 40, 40, '[\"https://www.adidas.co.id/media/catalog/product/cache/3bec5fdb79d91223b1a151be2b21ce8d/g/x/gx2170_sl_ecom.jpg\", \"https://www.adidas.co.id/media/catalog/product/g/x/gx2170_sl_ecom.jpg\"]'),
(2, 2, 'SEPATU ULTRA 4D', 'At the debut of the adidas Ultraboost in 2015, these shoes had an impact that spread beyond the world of running. For this version of the shoe, we brought you a new design with a 3D printed midsole. The denser construction of the grille provides better support, and the exposed parts feel softer.', 4000000, 5, 15, 31, '[\"https://www.adidas.co.id/media/catalog/product/f/y/fy3960_sl_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/f/y/fy3960_smc_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/f/y/fy3960_blt_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/f/y/fy3960_bt_ecom.jpg\" ]'),
(3, 3, 'ozrah gm shoe 3', 'Exceeding your expectations, the adidas Ozrah shoe takes a bold stand with a progressive concept, soft cushioning and eye-catching design. With his unique eye, Tokyo-based designer and artist Guccimaze is making a style splash with metallic accents, reflective details and \"STAY TECHNO\" graphics that stand out in UV light.   ', 1500000, 1, 5, 32, '[\"https://www.adidas.co.id/media/catalog/product/g/y/gy1130_flt_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/x/gx3032_flt_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/y/gy1130_smc_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/y/gy1130_tpp_ecom.jpg\"]'),
(4, 3, 'NMD_V3 SHOES', 'Look confident every time you wear these adidas NMD_V3 junior shoes. If you think these shoes look simple, take a closer look. The subtle reflections of warm and cool colors create texture and uniqueness.', 1900000, 20, 50, 33, '[\"https://www.adidas.co.id/media/catalog/product/g/x/gx5689_sl_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/x/gx5689_smc_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/x/gx5689_blt_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/x/gx5689_by_ecom.jpg\" ]'),
(5, 1, 'ULTRABOOST DNA', 'These shoes are made with BOOST for incredible energy return and instant comfort. An adidas PRIMEKNIT upper wraps the foot with a supportive fit that enhances movement. The Stretchweb outsole with Continental™ Rubber flexes naturally and provides superior traction on slick or slanting surfaces.', 3300000, 5, 10, 34, '[\"https://www.adidas.co.id/media/catalog/product/g/z/gz0431_sl_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/z/gz0431_smc_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/z/gz0431_blt_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/z/gz0431_bt_ecom.jpg\"]'),
(6, 3, 'KARLIE KLOSS X9000', 'A collaboration with Karlie Kloss, these adidas running shoes have a bold look that acts as extra motivation to lace in and get out in the morning.', 2200000, 5, 10, 35, '[\"https://www.adidas.co.id/media/catalog/product/g/y/gy0846_sl_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/y/gy0846_s.mc_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/y/gy0846_blt_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/y/gy0846_bt_ecom.jpg\"]'),
(7, 1, 'ULTRABOOST 4 DNA', 'Every stride in these Ultraboost running shoes brings you closer to where you want to be. BOOST delivers incredible energy return and instant comfort while an adidas PRIMEKNIT upper wraps the foot with a supportive fit that you can rely on.', 3300000, 10, 15, 36, '[\"https://www.adidas.co.id/media/catalog/product/g/y/gy0284_sl_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/y/gy0284_smc_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/y/gy0284_blt_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/y/gy0284_bt_ecom.jpg\"]'),
(8, 3, 'ULTRABOOST 5.0 DNA', 'Why should runners get all the best shoes? We asked the same question and came up with an answer — the Ultraboost DNA. It has all the features of one of our most popular performance runners, but it\'s made for wearing every day, everywhere.', 3300000, 5, 10, 40, '[\"https://www.adidas.co.id/media/catalog/product/g/x/gx9328_sl_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/x/gx9328_smc_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/x/gx9328_blt_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/x/gx9328_bt_ecom.jpg\"]'),
(9, 3, 'ULTRABOOST 5 DNA SHOES', 'Appreciate every detail. These running shoes are made for all-around comfort that sticks around through long days on your feet.', 3300000, 5, 20, 38, '[\"https://www.adidas.co.id/media/catalog/product/g/x/gx9331_sl_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/y/gy6959_smc_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/y/gy6959_bt_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/y/gy6959_tpp_ecom.jpg\"]'),
(10, 1, 'SEPATU OZRAH GM', 'Exceeding your expectations, the adidas Ozrah shoe takes a bold stand with a progressive concept, soft cushioning and eye-catching design. With his unique eye, Tokyo-based designer and artist Guccimaze is making a style splash with metallic accents, reflective details and \"STAY TECHNO\" graphics that stand out in UV light.   ', 2200000, 100, 35, 39, '[\"https://www.adidas.co.id/media/catalog/product/g/y/gy1130_flt_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/x/gx3032_flt_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/y/gy1130_smc_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/y/gy1130_tpp_ecom.jpg\"]'),
(11, 3, 'SEPATU ULTRABOOST 4 DNA', 'Every step in these Ultraboost running shoes brings you closer to where you want to be. The BOOST delivers incredible energy return and instant comfort, while the adidas PRIMEKNIT upper wraps the foot in a supportive fit you can count on.', 3300000, 10, 50, 40, '[\"https://www.adidas.co.id/media/catalog/product/g/y/gy0286_sl_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/y/gy0286_blt_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/y/gy0286_bt_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/y/gy0286_tpp_ecom.jpg\"]'),
(12, 1, 'SEPATU OZRAH', 'The pinnacle of expression, the adidas Ozrah shoe breaks through another dimension of the OZWEEGO universe. Progressive design seems to push the expected limits. The TPU case wraps around the textile upper for a cutting-edge 360-degree look. Adiprene cushioning makes every movement comfortable.', 2200000, 1, 12, 41, '[\"https://www.adidas.co.id/media/catalog/product/g/w/gw5824_sl_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/w/gw5824_smc_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/w/gw5824_bt_ecom.jpg\",\"https://www.adidas.co.id/media/catalog/product/g/w/gw5824_tpp_ecom.jpg\"]');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `phone`, `address`) VALUES
(1, 'test', 'test@gmail.com', 'password', NULL, NULL),
(2, 'i', 'i@gmail.com', 'i', NULL, NULL),
(16, 'iz', 'iz@gmail.com', 'pw', NULL, NULL),
(18, 'z', 'z@gmail.com', 'z', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_orders_users` (`user_id`);

--
-- Indexes for table `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_orderDetails_orders` (`order_id`),
  ADD KEY `fk_orderDetails_shoes` (`shoe_id`);

--
-- Indexes for table `shoes`
--
ALTER TABLE `shoes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_shoes_categories` (`category_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`),
  ADD UNIQUE KEY `name` (`name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `order_details`
--
ALTER TABLE `order_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `shoes`
--
ALTER TABLE `shoes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `fk_orders_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `order_details`
--
ALTER TABLE `order_details`
  ADD CONSTRAINT `fk_orderDetails_orders` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  ADD CONSTRAINT `fk_orderDetails_shoes` FOREIGN KEY (`shoe_id`) REFERENCES `shoes` (`id`);

--
-- Constraints for table `shoes`
--
ALTER TABLE `shoes`
  ADD CONSTRAINT `fk_shoes_categories` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
