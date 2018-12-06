<?php
/**
 * Created by PhpStorm.
 * User: calvi
 * Date: 12/6/2018
 * Time: 3:40 AM
 */
include_once 'config.php';

$connect = mysqli_connect(DB_HOST, DB_USER, DB_PASSWORD, DB_NAME);

/** @var TYPE_NAME $connect */
if (!$connect) {
    echo "Error: Unable to connect to MySQL." . PHP_EOL;
    echo "Debugging errno: " . mysqli_connect_errno() . PHP_EOL;
    echo "Debugging error: " . mysqli_connect_error() . PHP_EOL;
    exit;
}
