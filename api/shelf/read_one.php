<?php
// required headers
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: access");
header("Access-Control-Allow-Methods: GET");
header("Access-Control-Allow-Credentials: true");
header('Content-Type: application/json');
 
// include database and object files
include_once '../config/database.php';
include_once '../objects/shelf.php';
 
// get database connection
$database = new database();
$db = $database->getConnection();
 
// prepare product object
$shelf = new shelf($db);
 
// set ID property of record to read
$shelf->barcode_shelf = isset($_GET['barcode_shelf']) ? $_GET['barcode_shelf'] : die();
 
// read the details of product to be edited
$shelf->readOne();
 
if($shelf->barcode_shelf!=null){
    // create array
    $product_arr = array(
        "barcode_shelf" =>  $shelf->barcode_shelf,
    );
 
    // set response code - 200 OK
    http_response_code(200);
 
    // make it json format
    echo json_encode($product_arr);
}
 
else{
    // set response code - 404 Not found
    http_response_code(404);
 
    // tell the user product does not exist
    echo json_encode(array("message" => "Product does not exist."));
}
?>