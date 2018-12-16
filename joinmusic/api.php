<?php
/**
 * Created by PhpStorm.
 * User: calvi
 * Date: 12/6/2018
 * Time: 5:58 AM
 */


	require_once 'db-connect.php';

	$response = array();

	if(isset($_GET['apicall'])){

        switch($_GET['apicall']){

            case 'signup':
                if(isTheseParametersAvailable(array('nrp', 'nama', 'email','password'))){
                    $nrp = $_POST['nrp'];
                    $nama = $_POST['nama'];
                    $email = $_POST['email'];
                    $password = md5($_POST['password']);

                    $stmt = $connect->prepare("SELECT id FROM user WHERE nrp = ? OR email = ?");
                    $stmt->bind_param("ss", $nrp, $email);
                    $stmt->execute();
                    $stmt->store_result();

                    if($stmt->num_rows > 0){
                        $response['error'] = true;
                        $response['message'] = 'User already registered';
                        $stmt->close();
                    }else{
                        $stmt = $connect->prepare("INSERT INTO user (nrp, nama, email, password) VALUES (?, ?, ?, ?)");
                        $stmt->bind_param("ssss", $nrp, $nama, $email, $password);

                        if($stmt->execute()){
                            $stmt = $connect->prepare("SELECT id, nrp, nama, email FROM user WHERE nrp = ?");
                            $stmt->bind_param("s",$nrp);
                            $stmt->execute();
                            $stmt->bind_result($id, $nrp, $nama, $email);
                            $stmt->fetch();

                            $user = array(
                                'id'=>$id,
                                'nrp'=>$nrp,
                                'nama'=>$nama,
                                'email'=>$email
                            );

                            $stmt->close();

                            $response['error'] = false;
                            $response['message'] = 'User registered successfully';
                            $response['user'] = $user;
                        }
                    }

                }else{
                    $response['error'] = true;
                    $response['message'] = 'required parameters are not available';
                }

                break;

            case 'login':

                if(isTheseParametersAvailable(array('nrp', 'password'))){

                    $nrp = $_POST['nrp'];
                    $password = md5($_POST['password']);

                    $stmt = $connect->prepare("SELECT id, nrp, nama, email FROM user WHERE nrp = ? AND password = ?");
                    $stmt->bind_param("ss",$nrp, $password);

                    $stmt->execute();

                    $stmt->store_result();

                    if($stmt->num_rows > 0){

                        $stmt->bind_result($id, $nrp, $nama, $email);
                        $stmt->fetch();

                        $user = array(
                            'id'=>$id,
                            'nrp'=>$nrp,
                            'nama'=>$nama,
                            'email'=>$email
                        );

                        $response['error'] = false;
                        $response['message'] = 'Login successfull';
                        $response['user'] = $user;
                    }else{
                        $response['error'] = false;
                        $response['message'] = 'Invalid nrp or password';
                    }
                }
                break;

            default:
                $response['error'] = true;
                $response['message'] = 'Invalid Operation Called';
        }

    }else{
        $response['error'] = true;
        $response['message'] = 'Invalid API Call';
    }

	echo json_encode($response);

	function isTheseParametersAvailable($params){

        foreach($params as $param){
            if(!isset($_POST[$param])){
                return false;
            }
        }
        return true;
    }