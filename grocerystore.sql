-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 07, 2023 at 08:21 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `stores`
--

-- --------------------------------------------------------

--
-- Table structure for table `grocerystore`
--

CREATE TABLE `grocerystore` (
  `pid` int(11) NOT NULL,
  `productname` varchar(100) NOT NULL,
  `category` varchar(100) NOT NULL,
  `batchno` varchar(10) NOT NULL,
  `quantity` varchar(11) NOT NULL,
  `mfgdate` date NOT NULL,
  `expdate` date NOT NULL,
  `Description` text NOT NULL,
  `mrp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `grocerystore`
--

INSERT INTO `grocerystore` (`pid`, `productname`, `category`, `batchno`, `quantity`, `mfgdate`, `expdate`, `Description`, `mrp`) VALUES
(1, 'Rice-meals', 'Rice/pulses/grains', 'RPG01', '500 gm', '2021-12-03', '2024-12-30', 'This rice meal is a tasty and convenient option for any mealtime. Made with fluffy rice and savory ingredients, it is sure to satisfy your cravings. Whether you are looking for a protein-packed meal or a veggie-packed option, this rice meal has you covered. Try the chicken and vegetable option for a delicious blend of tender chicken and colorful veggies, or opt for the spicy shrimp and rice dish for a bold and flavorful kick. If you are in the mood for something simpler, the veggie fried rice meal is a tasty blend of rice and fresh veggies with savory seasonings. And if you are a fan of beef and broccoli, you will love the tender beef, crisp broccoli, and fluffy rice in the beef and broccoli rice meal. Whatever your preference, this rice meal is a delicious and easy option for any occasion.', 39),
(2, 'Rice-Boiled', 'Rice/pulses/grains', 'RPG02', '500 gm', '2022-11-03', '2024-12-30', 'Boiled rice is a staple in many cuisines around the world, and for good reason. This simple and versatile dish is the perfect accompaniment to a wide range of meals, from spicy curries to comforting stews. Made with fluffy and tender grains of rice, boiled rice is easy to prepare and can be seasoned to taste with salt, herbs, or spices. Whether you\'re looking for a neutral base to showcase the flavors of your main dish or a comforting side to fill out your plate, boiled rice is a delicious and satisfying option.', 30),
(3, 'Wheat', 'Rice/pulses/grains', 'RPG03', '500 gm', '2022-06-08', '2023-12-30', 'Wheat is a versatile and nutritious ingredient that can be found in a variety of foods, from bread and pasta to cereals and snacks. Whole wheat flour is a popular choice for baking, offering a nutty flavor and hearty texture to breads, cakes, and other baked goods. Wheat berries, the whole grains of wheat, can be used as a side dish or added to soups and salads for a boost of fiber, protein, and essential nutrients. Wheat germ, the nutrient-rich part of the wheat kernel, can be used as a topping for yogurt or oatmeal, or added to smoothies for a nutritional boost. With its many forms and health benefits, wheat is a valuable addition to any diet.\r\n', 25),
(4, 'Chanadal', 'Rice/pulses/grains', 'RPG04', '500 gm', '2022-07-16', '2025-12-15', 'Chanadal, also known as split Bengal gram, is a staple in Indian cuisine. These small, yellow lentils are rich in protein, fiber, and essential nutrients like iron and potassium. They have a mild, nutty flavor and a creamy texture that makes them a great addition to soups, stews, and curries. Chanadal is also a popular ingredient in savory snacks like dal vada and dal pakora. With its versatility and nutritional benefits, chanadal is a delicious and healthy choice for any meal.\r\n\r\n', 43),
(5, 'Sabudana', 'Rice/pulses/grains', 'RPG05', '1 kg', '2022-01-19', '2022-12-15', 'Sabudana, also known as tapioca pearls, is a popular ingredient in Indian cuisine. These small, white pearls are made from the starch extracted from cassava roots and are often used to make desserts and snacks. Sabudana is a gluten-free and vegan-friendly ingredient that is high in carbohydrates and low in fat, making it a great source of energy. It has a chewy and translucent texture that adds a unique mouthfeel to dishes like sabudana khichdi and sabudana kheer. With its versatility and nutritional benefits, sabudana is a delicious and healthy choice for anyone looking to explore new flavors and textures in their cooking.\r\n\r\n', 150),
(6, 'Rajama', 'Rice/pulses/grains', 'RPG06', '1 kg', '2021-05-12', '2023-12-15', 'Rajama, also known as kidney beans, is a popular ingredient in Indian and Mexican cuisine. These large, red beans are packed with protein, fiber, and essential nutrients like iron and magnesium. Rajama has a slightly sweet and nutty flavor that makes it a great addition to soups, stews, and chili. It can also be mashed and used as a filling for tacos and burritos. Rajama is a versatile ingredient that can be used in a variety of dishes, making it a staple in many households around the world.\r\n', 180),
(7, 'Sugar', 'Sugar/Salt/Spices', 'SSS01', '500 gm', '2022-05-10', '2023-11-09', 'Sugar is a common household ingredient used in cooking and baking. It is a type of carbohydrate that provides the body with energy. White granulated sugar is the most commonly used type of sugar and is made from sugarcane or sugar beet. Brown sugar is also a popular type of sugar that contains molasses and has a slightly different flavor and texture. Sugar can be used to sweeten drinks, desserts, and savory dishes. However, it is important to consume sugar in moderation as excessive consumption can lead to health problems like diabetes and obesity.\r\n', 55),
(8, 'Salt', 'Sugar/Salt/Spices', 'SSS02', '500 gm', '2022-01-15', '2023-05-30', 'Salt is a mineral that is essential for human health and is commonly used as a seasoning in cooking. It enhances the flavor of food and can also be used as a preservative. Salt is made up of sodium and chloride ions and is found in many natural sources, such as seawater and rock deposits. It is important to consume salt in moderation, as excessive consumption can lead to health problems like high blood pressure and heart disease. However, a small amount of salt is necessary for the body to function properly, and it is recommended to use iodized salt to prevent iodine deficiency.', 13),
(9, 'Jaggery', 'Sugar/Salt/Spices', 'SSS03', '500 gm', '2022-09-13', '2025-05-12', 'Jaggery is a traditional sweetener commonly used in South Asian and African cuisine. It is made by boiling sugar cane juice or palm sap until it solidifies into a dense, dark brown block. Jaggery has a rich, caramel-like flavor and is often used as a healthier alternative to refined sugar. It is a good source of iron and other essential nutrients, making it a popular ingredient in traditional medicines. Jaggery can be used to sweeten desserts, tea, and savory dishes, adding a unique flavor and nutritional benefits to your meals.', 77),
(10, 'Turmeric Powder', 'Sugar/Salt/Spices', 'SSS04', '1 kg', '2023-05-16', '2025-05-12', 'Turmeric powder is a bright yellow spice commonly used in Indian and Middle Eastern cuisine. It is made from the root of the turmeric plant and has a warm, slightly bitter flavor. Turmeric powder is often used as a natural dye for food and textiles due to its intense color. It also has many health benefits, including anti-inflammatory and antioxidant properties. Turmeric powder can be used to flavor curries, rice dishes, and soups, and is also commonly used as a natural remedy for various ailments.', 260),
(11, 'Dry Chilli', 'Sugar/Salt/Spices', 'SSS05', '500 gm', '2023-01-19', '2024-07-13', 'Dry chili is a type of chili pepper that has been dried and preserved for later use. It is a common ingredient in many cuisines around the world and adds a spicy and smoky flavor to dishes. There are many varieties of dry chili, ranging in heat from mild to extremely hot. Dry chili can be ground into a powder or used whole in soups, stews, and marinades. It is also used as a seasoning in many spice blends and rubs. Dry chili is a versatile and flavorful ingredient that adds heat and complexity to any dish.', 38),
(12, 'Tarmarind', 'Sugar/Salt/Spices', 'SSS06', '500 gm', '2023-07-12', '2024-07-13', 'Tamarind is a sweet and sour fruit commonly used in Indian, Thai, and Latin American cuisine. It is a brown, pod-like fruit that grows on tall trees and contains sticky pulp and seeds. Tamarind is known for its tangy flavor and is often used in chutneys, curries, and sauces. It is also used as a natural preservative and flavoring agent for meat and fish dishes. Tamarind is rich in vitamins, minerals, and antioxidants, making it a popular ingredient in traditional medicine. Tamarind paste or concentrate can be found in most grocery stores and is a convenient way to add the distinctive flavor of tamarind to your cooking.', 200),
(13, 'Milk', 'Dairy/Frozen Food', 'DFF01', '500 ml', '2023-07-12', '2023-07-13', 'Milk is a nutrient-rich, white liquid that is produced by mammals to nourish their young. It is a staple food in many cultures around the world and is commonly consumed as a beverage or used as an ingredient in cooking and baking. Milk is an excellent source of calcium, protein, and other essential nutrients, making it an important part of a healthy diet. There are many varieties of milk available, including whole, skim, and low-fat, as well as non-dairy alternatives like soy and almond milk. Milk can be enjoyed on its own or used to make a variety of dishes, from creamy soups and sauces to baked goods and desserts.', 32),
(14, 'Butter', 'Dairy/Frozen Food', 'DFF02', '1 kg', '2023-07-12', '2023-08-13', 'Butter is a dairy product made from churning cream or milk until it solidifies into a spreadable, golden substance. It has a rich, creamy flavor and is a common ingredient in cooking and baking. Butter is high in fat and calories, but also contains important nutrients like vitamins A and D. It is often used as a topping for bread, toast, and vegetables, and is also used as a cooking fat for sautéing and frying. Butter can be found in salted and unsalted varieties, and can also be made from plant-based sources like nuts and seeds for those with dietary restrictions.', 490),
(15, 'Cheese', 'Dairy/Frozen Food', 'DFF03', '1 kg', '2023-07-12', '2023-08-13', 'Cheese is a dairy product made by coagulating milk proteins and separating them from the liquid whey. It comes in a wide variety of textures and flavors, from soft and creamy to hard and sharp. Cheese is a versatile ingredient that is used in many cuisines around the world, from pizza and pasta dishes to sandwiches and charcuterie boards. It is a good source of calcium, protein, and other important nutrients, making it a popular food among both children and adults. Cheese can be enjoyed on its own or used as an ingredient in countless recipes, adding flavor and texture to any dish.\r\n', 400),
(16, 'Khova', 'Dairy/Frozen Food', 'DFF04', '1 kg', '2023-08-12', '2024-12-13', 'Khova is a dairy product widely used in Indian and Pakistani cuisine. It is made by slowly simmering and evaporating whole milk until it solidifies into a dense, creamy mass. Khova has a rich, nutty flavor and is often used as a base for many Indian sweets, such as gulab jamun, barfi, and ras malai. It is also used in savory dishes like curries and biryanis to add richness and depth of flavor. Khova can be found in most Indian grocery stores and can also be made at home using whole milk and a little bit of patience.\r\n', 200),
(17, 'Curd', 'Dairy/Frozen Food', 'DFF05', '250 gm', '2023-08-12', '2024-08-22', 'Curd is a dairy product made by fermenting milk with specific strains of bacteria. It has a tangy flavor and a thick, creamy texture. Curd is a popular ingredient in many cuisines around the world and is often used in dips, sauces, marinades, and dressings. It is also a good source of calcium, protein, and probiotics, making it a healthy addition to any diet. Curd can be enjoyed on its own or used as an ingredient in sweet and savory dishes alike. It comes in many different varieties, including plain, flavored, and Greek-style, and can be found in most grocery stores.\r\n', 35),
(18, 'Paneer', 'Dairy/Frozen Food', 'DFF06', '250 gm', '2023-05-12', '2024-08-22', 'Paneer is a fresh, unsalted cheese that is widely used in Indian and Pakistani cuisine. It is made by curdling hot milk with an acidic ingredient like lemon juice or vinegar, and then straining the curds to remove the whey. Paneer has a mild, slightly sweet flavor and a firm, crumbly texture. It is a popular ingredient in many vegetarian dishes like curries, palak paneer, and mattar paneer. Paneer is also a good source of protein and calcium, making it a healthy addition to any diet. It can be found in most Indian grocery stores and can also be made at home with just a few simple ingredients.\r\n', 65);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `grocerystore`
--
ALTER TABLE `grocerystore`
  ADD PRIMARY KEY (`pid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `grocerystore`
--
ALTER TABLE `grocerystore`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
