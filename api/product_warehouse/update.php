<?php
// required headers
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Methods: POST");
header("Access-Control-Max-Age: 3600");
header("Access-Control-Allow-Headers: Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
 
// include database and object files
include_once '../config/database.php';
include_once '../objects/product_warehouse.php';
 
// get database connection
$database = new database();
$db = $database->getConnection();
 
// prepare product object
$product_warehouse = new product_warehouse($db);
 
// get id of product to be edited
$data = json_decode(file_get_contents("php://input"));
 
// set ID property of product to be edited
$product_warehouse->barcode = $data->barcode;
 
// set product property values
$product_warehouse->quantity = $data->quantity;
$product_warehouse->category = $data->category;
$product_warehouse->type = $data->type;
$product_warehouse->weight = $data->weight;
$product_warehouse->manufacture_name = $data->manufacture_name;
$product_warehouse->manufacture_date = $data->manufacture_date;
$product_warehouse->expiry_date = $data->manufacture_date;
$product_warehouse->location = $data->location;
$product_warehouse->fragile = $data->fragile;
$product_warehouse->perishable = $data->perishable;
 
// update the product
if($product_warehouse->update()){
 
    // set response code - 200 ok
    http_response_code(200);
 
    // tell the user
    echo json_encode(array("message" => "Product was updated."));
}
 
// if unable to update the product, tell the user
else{
 
    // set response code - 503 service unavailable
    http_response_code(503);
 
    // tell the user
    echo json_encode(array("message" => "Unable to update product."));
}
?>