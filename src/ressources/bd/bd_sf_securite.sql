-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 06 nov. 2023 à 19:52
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bd_sf_securite`
--

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `code` varchar(300) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mot_de_passe` longtext NOT NULL,
  `statut` tinyint(1) NOT NULL DEFAULT 1,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `nom`, `code`, `prenom`, `email`, `mot_de_passe`, `statut`, `created_at`) VALUES
(5, 'okok', 'EF6oeIYH+eFfOLEO7HACGQ==', 'ioio', 'bbbb', 'K3vULd3pn0g4SDnA9mbG3A==', 1, '2023-11-05 14:39:20'),
(6, 'Blaise', 'YdBfut/CmQ+3i+lxQj4EIw==', 'Mounix', 'blaisemounix@gmail.com', 'GP9Bcs34dnApBzzSKgBinw==', 1, '2023-11-05 14:40:26'),
(7, 'Mounix', 'XDiAsbqXAu+zC7RAwB43EQ==', 'Snay', 'snay@gmail.com', 'hAAlGiy+Hs6c2Fuy1yRnhw==', 1, '2023-11-05 14:44:10'),
(8, 'a', '/xx7+D4aiqe5OmLDEWqG1g==', 'a', 'a', 'iuVXexBwjeapqjcdNcLhvg==', 1, '2023-11-05 14:46:18'),
(9, 'Ali', 'XjwaKtRXKGMAczbVDEyJLw==', 'Moussa', 'ali@gmail.com', 'KOwUnc/tdBcd4X/Ulaa/Rg==', 1, '2023-11-05 16:42:11'),
(18, 'hello', '3LVJe1vouzSM5+e8Zxt4Yg==', 'good', 'bui', 'Yd1tpgp5G51JUuPO5juW0g==', 1, '2023-11-05 17:28:49'),
(19, 'Kali', 'VW0BcIMm5x7b/AomsDKFtQ==', 'Linux', 'kali@gmail.org', 'qQl4fwO+f1GzM2wTZTFg2g==', 1, '2023-11-05 17:34:15'),
(20, 'Salif', 'JmpPd4p8j6tRbKhiHaWOHw==', 'Adoum', 'salif@gmail.com', '9ERLdy7+QzDjFxzbKQhqLQ==', 1, '2023-11-05 17:38:38');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
