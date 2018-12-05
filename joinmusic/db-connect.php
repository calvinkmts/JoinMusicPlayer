<?php
/**
 * Created by PhpStorm.
 * User: calvi
 * Date: 12/6/2018
 * Time: 3:40 AM
 */
include_once 'config.php';

class DbConnect {

    private $connect;

    public function __construct()
    {

        $this->connect = mysqli_connect(DB_HOST, DB_USER, DB_USER, DB_PASSWORD, DB_NAME);

        if (mysqli_connect_errno($this->connect)) {
            echo "Unable to connect to MySQL Database: " . mysqli_connect_error();
        }

    }

    /**
     * @return mysqli
     */
    public function getDb(){
        return $this->connect;
    }
}