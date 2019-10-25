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
$shop = new shop($db);
 
// set ID property of record to read
$shop->barcode = isset($_GET['shop_id']) ? $_GET['shop_id'] : die();
 
// read the details of product to be edited
$shop->readOne();
 
if($shop->shop_name!=null){
    // create array
    $product_arr = array(
        "shop_id" =>  $shop->shop_id,
        "shop_name" => $shop->shop_name,
        "contact_number" => $shop->contact_number,
        "contact_person" => $shop->contact_person,
        "address" => $shop->address
        
       
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