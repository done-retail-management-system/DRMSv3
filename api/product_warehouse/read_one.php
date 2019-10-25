<?php
// required headers
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: access");
header("Access-Control-Allow-Methods: GET");
header("Access-Control-Allow-Credentials: true");
header('Content-Type: application/json');
 
// include database and object files
include_once '../config/database.php';
include_once '../objects/product_warehouse.php';
 
// get database connection
$database = new database();
$db = $database->getConnection();
 
// prepare product object
$product_warehouse = new product_warehouse($db);
 
// set ID property of record to read
$product_warehouse->barcode = isset($_GET['barcode']) ? $_GET['barcode'] : die();
 
// read the details of product to be edited
$product_warehouse->readOne();
 
if($product_warehouse->manufacture_name!=null){
    // create array
    $product_arr = array(
        "barcode" =>  $product_warehouse->barcode,
        "manufacture_name" => $product_warehouse->manufacture_name,
        "category" => $product_warehouse->category,
        "weight" => $product_warehouse->weight,
        "location" => $product_warehouse->location,
        "quantity" => $product_warehouse->quantity
       
 
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