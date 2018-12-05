<?php
/**
 * Created by PhpStorm.
 * User: calvi
 * Date: 12/6/2018
 * Time: 3:27 AM
 */


    require_once 'user.php';

    $nrp = "";

    $password = "";

    $email = "";

    if(isset($_POST['nrp'])){

        $nrp = $_POST['nrp'];

    }

    if(isset($_POST['password'])){

        $password = $_POST['password'];

    }

    if(isset($_POST['email'])){

        $email = $_POST['email'];

    }

    $userObject = new User();

    // Registration

    if(!empty($nrp) && !empty($password) && !empty($email)){

        $hashed_password = md5($password);

        $json_registration = $userObject->createNewRegisterUser($nrp, $hashed_password, $email);

        echo json_encode($json_registration);

    }

    // Login

    if(!empty($nrp) && !empty($password) && empty($email)){

        $hashed_password = md5($password);

        $json_array = $userObject->loginUsers($nrp, $hashed_password);

        echo json_encode($json_array);
    }
