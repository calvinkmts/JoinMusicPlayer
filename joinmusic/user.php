<?php
/**
 * Created by PhpStorm.
 * User: calvi
 * Date: 12/6/2018
 * Time: 3:51 AM
 */

include_once 'db-connect.php';

class User {

    private $db;

    private $db_table = "user";

    public function __construct()
    {
        $this->db = new DbConnect();
    }

    public function IsLoginExist($nrp, $password) {

        $query = "SELECT * FROM " . $this->db_table . "WHERE nrp = '$nrp' AND password = '$password' LIMIT 1";

        $result = mysqli_query($this->db->getDb(), $query);

        if (mysqli_num_rows($result) > 0) {

            mysqli_close($this->db->getDb());
            return true;
        }
    }

    public function IsEmailNrpExist($nrp, $email) {

        $query = "SELECT * FROM " . $this->db_table . "WHERE nrp = '$nrp' AND email = 'email'";

        $result = mysqli_query($this->db->getDb(), $query);

        if (mysqli_num_rows($result) > 0) {

            mysqli_close($this->db->getDb());
            return true;
        }

        return false;
    }

    public function isValidEmail($email){
        return filter_var($email, FILTER_VALIDATE_EMAIL) !== false;
    }

    public function createNewRegisterUser($nrp, $password, $email){

        $isExisting = $this->isEmailNrpExist($nrp, $email);

        if($isExisting){

            $json['success'] = 0;
            $json['message'] = "Error in registering. Probably the nrp/email already exists";
        }

        else{

            $isValid = $this->isValidEmail($email);

            if($isValid)
            {
                $query = "INSERT INTO ".$this->db_table." (nrp, password, email) values ('$nrp', '$password', '$email', NOW(), NOW())";

                $inserted = mysqli_query($this->db->getDb(), $query);

                if($inserted == 1){

                    $json['success'] = 1;
                    $json['message'] = "Successfully registered the user";

                }else{

                    $json['success'] = 0;
                    $json['message'] = "Error in registering. Probably the nrp/email already exists";

                }

                mysqli_close($this->db->getDb());
            }
            else{
                $json['success'] = 0;
                $json['message'] = "Error in registering. Email Address is not valid";
            }

        }

        return $json;

    }

    public function loginUsers($nrp, $password){

        $json = array();

        $canUserLogin = $this->isLoginExist($nrp, $password);

        if($canUserLogin){

            $json['success'] = 1;
            $json['message'] = "Successfully logged in";

        }else{
            $json['success'] = 0;
            $json['message'] = "Incorrect details";
        }
        return $json;
    }
}